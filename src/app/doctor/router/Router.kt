package app.doctor.router

import io.ktor.routing.*
import io.ktor.application.*

fun Application.registerDoctorRouter() {
    routing {
        getAppointments()
    }
}