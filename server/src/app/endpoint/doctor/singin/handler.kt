package app.endpoint.doctor.singin

import app.auth.Password
import app.endpoint.doctor.DoctorSession
import app.database.dao.doctors.DoctorEntity
import app.database.dao.doctors.Doctors
import app.database.dao.users.UserEntity
import app.database.dao.users.Users
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.signin() {
    post("/api/doctor/sign-in") {
        val data = call.receive<SigninData>()

        val doctor = transaction {
            val user = UserEntity
                .find {
                    Users.username eq data.username
                }
                .first()

            val userPassword = Password(user.password)
            if (!userPassword.compare(data.password)) {
                return@transaction null
            }

            return@transaction DoctorEntity
                .find {
                    Doctors.userId eq user.id.value
                }
                .firstOrNull()
        }

        if (doctor == null) {
            call.respond(UnauthorizedResponse())
        } else {
            val session = DoctorSession(doctor.id.toString())
            call.sessions.set(session)
            call.respond(HttpStatusCode.OK)
        }
    }
}