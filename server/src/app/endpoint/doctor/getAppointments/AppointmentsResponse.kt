package app.endpoint.doctor.getAppointments

import com.google.gson.annotations.Expose
import java.util.*

data class AppointmentsResponse(
    @Expose
    public val patientId: UUID,
    @Expose
    public val surname: String,
    @Expose
    public val name: String,
    @Expose
    public val date: Date
)