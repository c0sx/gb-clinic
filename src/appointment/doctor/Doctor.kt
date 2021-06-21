package appointment.doctor

import appointment.AppointmentData
import appointment.appointments.IAppointment
import appointment.patient.Patient
import appointment.appointments.NewPlanned
import appointment.exception.DoctorIsBusyException
import appointment.exception.InvalidDoctorException
import id.Id

class Doctor(
    public val id: Id,
    private val currentAppointment: IAppointment,
    appointments: List<IAppointment>
) {
    private val _appointments = appointments.toMutableList()

    public fun register(appointment: AppointmentData, patient: Patient): NewPlanned {
        if (!id.isEqual(appointment.doctorId)) {
            throw InvalidDoctorException()
        }

        if (isBusy(appointment)) {
            throw DoctorIsBusyException()
        }

        val planned = NewPlanned(
            appointment.medicalCardId,
            appointment.doctorId,
            appointment.plannedDate
        )

        _appointments.add(planned)

        try {
            patient.register(planned)
            return planned
        }
        catch (e: Exception) {
            unregister(planned)
            patient.unregister(planned)

            throw e
        }
    }

    public fun hasActiveAppointment(): Boolean {
        return currentAppointment.isActive()
    }

    public fun isEqual(doctor: Doctor): Boolean {
        return id.isEqual(doctor.id)
    }

    private fun unregister(appointment: IAppointment) {
        _appointments.remove(appointment)
    }

    private fun isBusy(appointment: AppointmentData): Boolean {
        return _appointments.any {
            it.isIntersectInterval(appointment.plannedDate)
        }
    }
}