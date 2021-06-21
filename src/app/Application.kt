package app;

import app.doctor.router.registerDoctorRouter
import app.patient.registerPatientRouter

import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.gson.*
import io.ktor.features.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {

        }
    }

    routing {
        registerPatientRouter()
        registerDoctorRouter()
    }
}

