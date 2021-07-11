package app.endpoint.patient.signup

import java.util.*

data class SignupData(
    public val username: String,
    public val password: String,
    public val surname: String,
    public val name: String,
    public val dateOfBirth: Date,
)