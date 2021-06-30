package app.endpoint

import app.endpoint.patient.getAppointments.getAppointments
import app.endpoint.patient.getDoctors.getDoctors
import app.endpoint.patient.registerAppointment.registerAppointment

import io.ktor.routing.*
import io.ktor.application.*

fun Application.registerPatientRouter() {
    routing {
        getDoctors()
        getAppointments()
        registerAppointment()
    }
}