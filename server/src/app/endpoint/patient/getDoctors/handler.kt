package app.endpoint.patient.getDoctors

import app.database.dao.doctors.DoctorEntity
import app.database.dao.doctors.Doctors
import app.database.dao.users.UserEntity
import app.database.dao.users.Users

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.getDoctors() {
    get("/api/patient/doctors") {
        val doctors = transaction {
            Doctors
                .innerJoin(Users)
                .select {
                    Doctors.deletedAt.isNull()
                }
                .map {
                    val doctor = DoctorEntity.wrapRow(it)
                    val user = UserEntity.wrapRow(it)

                    DoctorsResponse(
                        doctor.id.value,
                        user.surname,
                        user.name,
                        user.middlename
                    )
                }
        }

        call.respond(doctors)
    }
}