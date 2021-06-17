package com.example.customer.router

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.getCustomers() {
    get {
        call.respond("hello from customers 2");
    }
}