package app.endpoint.doctor

import io.ktor.auth.*

data class DoctorSession(val id: String): Principal