package app.endpoint.doctor.getInfo

import com.google.gson.annotations.Expose
import java.util.*

data class DoctorResponse(
    @Expose
    val id: UUID
)