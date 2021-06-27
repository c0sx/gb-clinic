package reception.appointments

import id.Id
import reception.RegisterDate

class Appointment(
    private val patientId: Id,
    private val doctorId: Id,
    private val date: RegisterDate
) {

    public fun patientId(): Id {
        return patientId
    }

    public fun doctorId(): Id {
        return doctorId
    }

    public fun date(): RegisterDate {
        return date
    }

    public fun isIntersectInterval(date: RegisterDate): Boolean {
        return Duration().isIntersect(this.date, date)
    }
}