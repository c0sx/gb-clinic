package appointment.appointments

import id.Id
import java.util.*

interface IAppointment {
    public fun patientId(): Id
    public fun doctorId(): Id
    public fun date(): Date

    public fun isActive(): Boolean
    public fun isIntersectInterval(date: Date): Boolean
}