package app.auth

import io.ktor.auth.*

data class UserSession(val id: String): Principal