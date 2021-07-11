package app.endpoint.doctor.getAppointments

import java.time.ZoneId
import java.util.*
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

import app.database.dao.appointments.AppointmentEntity
import app.database.dao.appointments.Appointments
import app.database.dao.patients.Patients
import app.database.dao.patients.PatientEntity
import app.database.dao.users.UserEntity
import app.database.dao.users.Users
import app.endpoint.doctor.DoctorSession
import io.ktor.sessions.*

fun Route.getAppointments() {
    get("/api/doctor/appointments") {
        val id = call.sessions.get<DoctorSession>()?.id ?: return@get call.respond(HttpStatusCode.BadRequest)

        val appointments = transaction {
            val rows = Appointments
                .select {
                    Appointments.doctorId eq UUID.fromString(id)
                }
                .map { AppointmentEntity.wrapRow(it) }

            val ids = rows.map { it.patientId }
            val patients = Patients
                .select {
                    Patients.id inList ids
                }
                .map {
                    PatientEntity.wrapRow(it)
                }

            val users = Users
                .select {
                    Users.id inList patients.map { it.userId }
                }
                .map { UserEntity.wrapRow(it) }

            rows.map { row ->
                val patient = patients.find { it.id.value == row.patientId }
                val user = users.find { it.id.value == patient?.userId }

                AppointmentsResponse(
                    row.patientId,
                    user?.surname ?: "",
                    user?.name ?: "",
                    Date.from(row.appointmentAt.atZone(ZoneId.systemDefault()).toInstant())
                )
            }
        }

        call.respond(appointments)
    }
}