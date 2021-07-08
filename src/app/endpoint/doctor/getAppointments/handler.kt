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

fun Route.getAppointments() {
    get("/api/doctors/appointments") {
        val id = call.parameters["id"] ?: return@get call.respond(HttpStatusCode.BadRequest)

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