package app.endpoint.doctor.signout

import app.endpoint.doctor.DoctorSession
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.sessions.*

fun Route.signout() {
    get("/api/doctor/sign-out") {
        println(call.sessionId);

        call.sessions.clear<DoctorSession>()
        println("logout");

        println(call.sessionId);

        call.respondRedirect("/")
    }
}