package app

import app.database.initDatabase
import app.patient.registerPatientRouter
import app.serialize.deserialize
import app.serialize.serialize

import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.gson.*
import io.ktor.features.*
import java.util.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    initDatabase()

    install(ContentNegotiation) {
        gson {
            registerTypeAdapter(Date::class.java, serialize)
            registerTypeAdapter(Date::class.java, deserialize)
        }
    }

    routing {
        registerPatientRouter()
    }
}

