package app.endpoint.reception.doctors.getDoctors

import app.database.dao.doctors.DoctorEntity
import app.database.dao.doctors.Doctors
import app.database.dao.users.UserEntity
import app.database.dao.users.Users
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.getDoctors() {
    get("/api/reception/doctors") {
        val doctors = transaction {
            Doctors
                .innerJoin(Users)
                .select {
                    Doctors.deletedAt.isNull()
                }
                .iterator()
                .asSequence()
                .toList()
                .map {
                    val doctor = DoctorEntity.wrapRow(it)
                    val user = UserEntity.wrapRow(it)

                    println(it)

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