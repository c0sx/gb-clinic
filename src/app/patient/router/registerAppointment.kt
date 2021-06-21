package app.patient.router

import app.patient.appointments.registerAppointment.RegisterAppointment
import app.patient.appointments.Appointments
import appointment.Appointment
import id.Id

import java.util.*
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*

fun Route.registerAppointment() {
    post("/api/patient/appointments") {
        val registrator = RegisterAppointment(
            Appointments()
        )

        val appointment = Appointment(Id("medical1"), Id("doctor1"), Date())
        registrator.register(appointment)

        call.respond(HttpStatusCode.OK)
    }
}