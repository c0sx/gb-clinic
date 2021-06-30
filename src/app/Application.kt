package app

import app.auth.UserSession
import app.database.initDatabase
import app.endpoint.patientRouter
import app.endpoint.reception.receptionRouter
import app.serialize.deserialize
import app.serialize.serialize

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.routing.*
import io.ktor.gson.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.sessions.*
import java.util.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    initDatabase()

    install(Sessions) {
        cookie<UserSession>("user_session")
    }

    install(Authentication) {
        session<UserSession>("auth-session") {
            validate {
                if (it.id.startsWith("123")) {
                    it
                } else {
                    null
                }
            }
            challenge {
                call.respond(UnauthorizedResponse())
            }
        }
    }

    install(ContentNegotiation) {
        gson {
            registerTypeAdapter(Date::class.java, serialize)
            registerTypeAdapter(Date::class.java, deserialize)
        }
    }

    routing {
        authenticate("auth-session") {
            patientRouter()
            receptionRouter()
        }
    }
}

