package app.endpoint.patient.getInfo

import com.google.gson.annotations.Expose
import java.util.*

data class PatientResponse(
    @Expose
    val id: UUID
)