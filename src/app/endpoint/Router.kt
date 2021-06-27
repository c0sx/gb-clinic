package app.patient

import app.endpoint.patient.registerAppointment.registerAppointment

import io.ktor.routing.*
import io.ktor.application.*

fun Application.registerPatientRouter() {
    routing {
        registerAppointment()
    }
}