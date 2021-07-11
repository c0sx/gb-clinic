package app.endpoint.patient.getInfo

import app.database.dao.patients.PatientEntity
import app.endpoint.patient.PatientSession
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

fun Route.getPatientInfo() {
    get("/api/patient/info") {
        val id = call.sessions.get<PatientSession>()?.id ?: return@get call.respond(HttpStatusCode.BadRequest)
        val patient = transaction {
            PatientEntity.findById(UUID.fromString(id))
        }

        if (patient == null) {
            call.respond(UnauthorizedResponse())
        } else {
            call.respond(PatientResponse(patient.id.value))
        }
    }
}