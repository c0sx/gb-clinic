package app.endpoint.patient.getAppointments

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
import app.database.dao.doctors.DoctorEntity
import app.database.dao.doctors.Doctors
import app.database.dao.users.UserEntity
import app.database.dao.users.Users
import app.endpoint.patient.PatientSession
import io.ktor.sessions.*

fun Route.getAppointments() {
    get("/api/patient/appointments") {
        val id = call.sessions.get<PatientSession>()?.id ?: return@get call.respond(HttpStatusCode.BadRequest)

        val appointments = transaction {
            val rows = Appointments
                .select {
                    Appointments.patientId eq UUID.fromString(id)
                }
                .map { AppointmentEntity.wrapRow(it) }

            val ids = rows.map { it.doctorId }
            val doctors = Doctors
                .select {
                    Doctors.id inList ids
                }
                .map {
                    DoctorEntity.wrapRow(it)
                }

            val users = Users
                .select {
                    Users.id inList doctors.map { it.userId }
                }
                .map { UserEntity.wrapRow(it) }

            rows.map { row ->
                val doctor = doctors.find { it.id.value == row.doctorId }
                val user = users.find { it.id.value == doctor?.userId }

                AppointmentsResponse(
                    row.doctorId,
                    user?.surname ?: "",
                    user?.name ?: "",
                    Date.from(row.appointmentAt.atZone(ZoneId.systemDefault()).toInstant())
                )
            }
        }

        call.respond(appointments)
    }
}