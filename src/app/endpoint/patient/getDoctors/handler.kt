package app.endpoint.patient.getDoctors

import app.database.dao.doctors.DoctorEntity

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.getDoctors() {
    get("/api/patients/{id}/doctors") {
        val doctors = transaction {
            DoctorEntity
                .all()
                .map {
                    DoctorsResponse(it.id.value)
                }
        }

        call.respond(doctors)
    }
}