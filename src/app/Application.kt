package app

import app.database.initDatabase
import app.patient.registerPatientRouter

import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.gson.*
import io.ktor.features.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    initDatabase()

    install(ContentNegotiation) {
        gson {

        }
    }

    routing {
        registerPatientRouter()
    }
}

