package app.patient

import app.patient.router.getAppointments
import app.patient.router.getAppointmentsHistory
import app.patient.router.registerAppointment

import io.ktor.routing.*
import io.ktor.application.*

fun Application.registerPatientRouter() {
    routing {
        registerAppointment()
        getAppointments()
        getAppointmentsHistory()
    }
}