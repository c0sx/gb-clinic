package app.endpoint.doctor.signout

import app.endpoint.doctor.DoctorSession
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.sessions.*

fun Route.signout() {
    get("/api/doctor/sign-out") {
        call.sessions.clear<DoctorSession>()
        call.respondRedirect("/doctor")
    }
}