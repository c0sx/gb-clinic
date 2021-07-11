package reception.doctor

import reception.appointments.Appointment
import reception.exception.DoctorIsBusyException
import reception.exception.InvalidDoctorException
import id.Id

class Doctor(
    private val id: Id,
    appointments: List<Appointment>
) {
    private val _appointments = appointments.toMutableList()

    public fun register(appointment: Appointment) {
        if (!id.isEqual(appointment.doctorId())) {
            throw InvalidDoctorException()
        }

        if (isBusy(appointment)) {
            throw DoctorIsBusyException()
        }

        _appointments.add(appointment)
    }

    private fun isBusy(appointment: Appointment): Boolean {
        return _appointments.any {
            it.isIntersectInterval(appointment.date())
        }
    }
}