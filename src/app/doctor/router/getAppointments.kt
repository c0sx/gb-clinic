package app.doctor.router

import app.doctor.appointments.Finder
import id.Id
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.getAppointments() {
    get("/api/doctor/appointments") {
        val finder = Finder()

        call.respond(finder.getAppointments(Id("doctorId")))
    }
}