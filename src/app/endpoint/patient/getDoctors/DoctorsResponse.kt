package app.endpoint.patient.getDoctors

import com.google.gson.annotations.Expose
import java.util.*

data class DoctorsResponse(
    @Expose
    public val id: UUID,
    public val surname: String,
    public val name: String,
    public val middlename: String?
)