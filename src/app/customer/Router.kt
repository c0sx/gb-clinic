package app.customer

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*

fun Application.registerCustomerRouter() {
    routing {
        route("/app/customer") {
            get {
                call.respond("hello from customers");
            }
        }
    }
}
