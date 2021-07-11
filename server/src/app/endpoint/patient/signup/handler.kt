package app.endpoint.patient.signup

import app.auth.Password
import app.database.dao.patients.PatientEntity
import app.database.dao.users.UserEntity
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.routing.*
import io.ktor.request.*
import io.ktor.response.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.ZoneId

fun Route.signup() {
    post("/api/patient/sign-up") {
        val data = call.receive<SignupData>()
        val pwd = Password.hash(data.password)

        transaction {
            val user = UserEntity.new {
                surname = data.surname
                name = data.name
                username = data.username
                password = pwd.hash
            }

            println(data);
            val local = data.dateOfBirth.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()

            PatientEntity.new {
                userId = user.id.value
                dateOfBirth = local
            }
        }

        call.respond(HttpStatusCode.OK)
    }
}