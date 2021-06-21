package appointment

import id.Id
import java.util.*

data class AppointmentData(
    public val medicalCardId: Id,
    public val doctorId: Id,
    public val plannedDate: Date
)