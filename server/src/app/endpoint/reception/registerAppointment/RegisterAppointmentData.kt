package app.endpoint.reception.registerAppointment

import java.util.*

data class RegisterAppointmentData(
    public val patientId: String,
    public val doctorId: String,
    public val date: Date
)