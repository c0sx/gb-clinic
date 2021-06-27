package app.endpoint.patient.registerAppointment

import java.util.*

data class RegisterAppointmentData(
    public val doctorId: String,
    public val date: Date
)