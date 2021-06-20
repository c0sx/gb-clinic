package app;

import app.customer.registerCustomerRouter
import app.customer.router.getCustomers
import app.patient.appointments.Finder
import app.patient.registerPatientRouter
import app.patient.router.getAppointments
import app.singup.registerSignupRouter
import id.Id

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.gson.*
import io.ktor.features.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {

        }
    }

    routing {
        route("/api") {
            route("/patient") {
                route("/appointments") {
                    getAppointments()
                }
            }
        }

        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }
    }
}

