package app.endpoint.patient.getAppointments

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*

fun Route.getAppointments() {
    get("/api/patients/{id}/appointments") {
        call.respond<List<String>>(HttpStatusCode.OK, emptyList())
    }
}