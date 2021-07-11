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
import app.endpoint.doctor.DoctorSession
import io.ktor.sessions.*

fun Route.getAppointments() {
    get("/api/doctor/appointments") {
        val id = call.sessions.get<DoctorSession>()?.id ?: return@get call.respond(HttpStatusCode.BadRequest)

        val appointments = transaction {
            Appointments
                .select {
                    Appointments.doctorId eq UUID.fromString(id)
                }
                .iterator()
                .asSequence()
                .toList()
                .map {
                    val row = AppointmentEntity.wrapRow(it)
                    AppointmentsResponse(
                        row.patientId,
                        Date.from(row.appointmentAt.atZone(ZoneId.systemDefault()).toInstant())
                    )
                }
        }

        call.respond(appointments)
    }
}