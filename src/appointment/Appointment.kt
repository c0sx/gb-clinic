package appointment

import id.Id
import java.util.*

data class Appointment(
    public val medicalCardId: Id,
    public val doctorId: Id,
    public val date: Date
) {
    public fun isIntersect(appointment: Appointment): Boolean {
        return Duration(this).isIntersect(appointment);
    }
}