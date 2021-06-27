package app.endpoint.patient.getDoctors

import com.google.gson.annotations.Expose
import java.util.*

data class DoctorsResponse(
    @Expose
    public val uuid: UUID
)