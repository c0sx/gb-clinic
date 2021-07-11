package reception.patient

import reception.appointments.Appointment
import reception.exception.InvalidPatientException
import reception.exception.PatientIsBusyException
import id.Id
import reception.RegisterDate

class Patient(
    private val id: Id,
    appointments: List<Appointment>
){
    private val _appointments = appointments.toMutableList()

    public fun register(appointment: Appointment) {
        if (!isEqual(appointment.patientId())) {
            throw InvalidPatientException()
        }

        if (isBusy(appointment.date())) {
            throw PatientIsBusyException()
        }

        _appointments.add(appointment)
    }

    private fun isEqual(patientId: Id): Boolean {
        return id.isEqual(patientId)
    }

    private fun isBusy(date: RegisterDate): Boolean {
        return _appointments.any {
            it.isIntersectInterval(date)
        }
    }
}