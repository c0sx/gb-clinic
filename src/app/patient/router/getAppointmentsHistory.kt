package app.patient.router

import app.patient.appointments.Finder
import id.Id
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.getAppointmentsHistory() {
    get {
        val finder = Finder()

        call.respond(finder.getAppointmentsHistory(Id("patientId")))
    }
}