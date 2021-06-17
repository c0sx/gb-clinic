package com.example.customer

import kotlinx.serialization.Serializable

@Serializable
data class Customer(val id: String, val firstName: String, val lastName: String)

val customerStorage = mutableListOf<Customer>()