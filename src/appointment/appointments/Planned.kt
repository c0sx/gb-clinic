package appointment.appointments

import appointment.exception.InvalidDoctorException
import id.Id
import java.util.*

class Planned(
    public val id: Id,
    private val patientId: Id,
    private val doctorId: Id,
    private val date: Date
) {
    public fun activate(doctorId: Id): Active {
        if (!this.doctorId.isEqual(doctorId)) {
            throw InvalidDoctorException()
        }

        return Active(
            patientId,
            doctorId,
            date
        )
    }
}