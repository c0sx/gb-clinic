package app.endpoint.doctor.getInfo

import app.endpoint.doctor.DoctorSession
import app.database.dao.doctors.DoctorEntity
import app.endpoint.patient.getInfo.PatientResponse
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

fun Route.getDoctorInfo() {
    get("/api/doctor/info") {
        val id = call.sessions.get<DoctorSession>()?.id ?: return@get call.respond(HttpStatusCode.BadRequest)
        val doctor = transaction {
            DoctorEntity.findById(UUID.fromString(id))
        }

        if (doctor == null) {
            call.respond(UnauthorizedResponse())
        } else {
            call.respond(PatientResponse(doctor.id.value))
        }
    }
}