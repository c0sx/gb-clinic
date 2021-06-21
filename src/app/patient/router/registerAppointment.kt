package app.patient.router

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*

fun Route.registerAppointment() {
    post("/api/patient/appointments") {
        call.respond(HttpStatusCode.OK)
    }
}