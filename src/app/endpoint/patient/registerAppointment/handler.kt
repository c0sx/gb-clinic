package app.endpoint.patient.registerAppointment

import app.reception.Appointments
import app.reception.Doctors
import app.reception.Patients
import id.Id
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import reception.RegisterAppointment
import reception.RegisterDate

fun Route.registerAppointment() {
    post("/api/patient/{id}/appointments") {
        val id = call.parameters["id"] ?: return@post call.respond(HttpStatusCode.BadRequest)

        val data = call.receive<RegisterAppointmentData>()

        val registry = RegisterAppointment(
            Doctors(),
            Patients(),
            Appointments()
        )

        registry.register(Id(id), Id(data.doctorId), RegisterDate(data.date))
    }
}