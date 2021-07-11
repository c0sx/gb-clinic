package app.endpoint.patient.signout

import app.endpoint.patient.PatientSession
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*

fun Route.signout() {
    get {
        call.sessions.clear<PatientSession>()
        call.respondRedirect("/patient")
    }
}