package app.endpoint.reception.registerAppointment

import java.time.LocalDateTime
import java.time.ZoneId

import id.Id
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*

import reception.repository.Appointments
import reception.repository.Doctors
import reception.repository.Patients
import reception.RegisterAppointment
import reception.RegisterDate

fun Route.registerAppointment() {
    post("/api/reception/appointments") {
        val data = call.receive<RegisterAppointmentData>()

        val registry = RegisterAppointment(
            Doctors(),
            Patients(),
            Appointments()
        )

        val local = LocalDateTime.ofInstant(data.date.toInstant(), ZoneId.systemDefault())
        registry.register(Id(data.patientId), Id(data.doctorId), RegisterDate(local))

        call.respond(HttpStatusCode.OK)
    }
}