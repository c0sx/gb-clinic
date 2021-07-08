package app.endpoint.patient.signin

import app.auth.Password
import app.auth.UserSession
import app.database.dao.patients.PatientEntity
import app.database.dao.patients.Patients
import app.database.dao.users.UserEntity
import app.database.dao.users.Users
import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.sessions.*
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.singin() {
    post("/api/patients/signin") {
        val data = call.receive<SigninData>()

        val patient = transaction {
            val user = UserEntity
                .find {
                    Users.username eq data.username
                }
                .first()

            val userPassword = Password(user.password)
            if (!userPassword.compare(data.password)) {
                return@transaction null
            }

            return@transaction PatientEntity
                .find {
                    Patients.userId eq user.id.value
                }
                .firstOrNull()
        }

        if (patient == null) {
            call.respond(UnauthorizedResponse())
        } else {
            val session = UserSession(patient.userId.toString())
            call.sessions.set(session)
            call.respond(HttpStatusCode.OK)
        }
    }
}