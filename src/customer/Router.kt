package com.example.customer

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*

fun Application.registerCustomerRouter() {
    routing {
        route("/customer") {
            get {
                call.respond("hello from customers");
            }
        }
    }
}
