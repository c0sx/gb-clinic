package app.endpoint.reception.doctors.getDoctors

import com.google.gson.annotations.Expose
import java.util.*

data class DoctorsResponse(
    @Expose
    public val id: UUID,

    @Expose
    public val surname: String,

    @Expose
    public val name: String,

    @Expose
    public val middlename: String?
)