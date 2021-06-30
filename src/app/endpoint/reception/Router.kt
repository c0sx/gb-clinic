package app.endpoint.reception

import app.endpoint.reception.doctors.getDoctors.getDoctors
import app.endpoint.reception.doctors.newDoctor.newDoctor
import io.ktor.application.*
import io.ktor.routing.*

fun Application.receptionRouter() {
    routing {
        newDoctor()
        getDoctors()
    }
}