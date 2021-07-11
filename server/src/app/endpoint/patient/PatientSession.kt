package app.endpoint.patient

import io.ktor.auth.*

data class PatientSession(val id: String): Principal