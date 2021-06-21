package appointment.patient

import appointment.appointments.NewPlanned
import appointment.exception.InvalidPatientException
import appointment.exception.PatientIsBusyException
import id.Id

import java.util.*

class Patient(
    private val id: Id,
    appointments: List<NewPlanned>
){
    private val _appointments = appointments.toMutableList()

    public fun register(appointment: NewPlanned) {
        if (!isEqual(appointment.patientId())) {
            throw InvalidPatientException()
        }

        if (isBusy(appointment.date())) {
            throw PatientIsBusyException()
        }

        _appointments.add(appointment)
    }

    public fun unregister(appointment: NewPlanned) {
        _appointments.remove(appointment)
    }

    private fun isEqual(medicalCardId: Id): Boolean {
        return id.isEqual(medicalCardId)
    }

    private fun isBusy(date: Date): Boolean {
        return _appointments.any {
            it.isIntersectInterval(date)
        }
    }
}