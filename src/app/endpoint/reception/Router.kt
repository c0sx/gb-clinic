package app.endpoint.reception

import io.ktor.application.*
import io.ktor.routing.*

import app.endpoint.reception.doctors.getDoctors.getDoctors
import app.endpoint.reception.doctors.newDoctor.newDoctor
import app.endpoint.reception.registerAppointment.registerAppointment

fun Application.receptionRouter() {
    routing {
        newDoctor()
        getDoctors()
        registerAppointment()
    }
}