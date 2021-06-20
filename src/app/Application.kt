package ru.gbclinic

import ru.gbclinic.customer.registerCustomerRouter
import ru.gbclinic.customer.router.getCustomers
import ru.gbclinic.singup.registerSignupRouter

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.gson.*
import io.ktor.features.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(ContentNegotiation) {
        gson {

        }
    }

    routing {
        route("/api") {
            route("/customers2") {
                getCustomers()
            }
        }

        registerSignupRouter()
        registerCustomerRouter()
    }

    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }
    }
}

