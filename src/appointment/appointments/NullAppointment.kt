package appointment.appointments

import id.Id
import java.util.*

class NullAppointment: IAppointment {
    public override fun patientId(): Id {
        return Id.empty()
    }

    public override fun doctorId(): Id {
        return Id.empty()
    }

    public override fun isActive(): Boolean {
        return false
    }

    public override fun date(): Date {
        return Date()
    }

    public override fun isIntersectInterval(date: Date): Boolean {
        return false
    }
}