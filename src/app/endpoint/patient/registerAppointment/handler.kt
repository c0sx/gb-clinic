package app.endpoint.patient.registerAppointment

import reception.repository.Appointments
import reception.repository.Doctors
import reception.repository.Patients

import id.Id

import reception.RegisterAppointment
import reception.RegisterDate

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*

fun Route.registerAppointment() {
    post("/api/patients/{id}/appointments") {
        val id = call.parameters["id"] ?: return@post call.respond(HttpStatusCode.BadRequest)
        val data = call.receive<RegisterAppointmentData>()

        val registry = RegisterAppointment(
            Doctors(),
            Patients(),
            Appointments()
        )

        registry.register(Id(id), Id(data.doctorId), RegisterDate(data.date))

        call.respond(HttpStatusCode.OK)
    }
}