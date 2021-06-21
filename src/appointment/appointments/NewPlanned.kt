package appointment.appointments

import id.Id
import java.util.*

class NewPlanned(
    private val patientId: Id,
    private val doctorId: Id,
    private val date: Date
): IAppointment {


    public override fun patientId(): Id {
        return patientId
    }

    public override fun doctorId(): Id {
        return doctorId
    }

    public override fun date(): Date {
        return date
    }

    public override fun isActive(): Boolean {
        return false
    }

    public override fun isIntersectInterval(date: Date): Boolean {
        return Duration().isIntersect(this.date, date)
    }
}