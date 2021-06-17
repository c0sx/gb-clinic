package com.example.singup

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*

fun Application.registerSignupRouter() {
    routing {
        route("/signup") {
            get {
                call.respond("kek")
            }
        }
    }
}
