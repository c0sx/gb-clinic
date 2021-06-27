package reception.reception

import id.Id
import reception.RegisterDate
import reception.appointments.Appointment
import reception.doctor.Doctor
import reception.patient.Patient

class Reception(
    private val patient: Patient,
    private val doctor: Doctor
) {
    public fun register(patientId: Id, doctorId: Id, date: RegisterDate): Appointment {
        val planned = Appointment(
            patientId,
            doctorId,
            date
        )

        patient.register(planned)
        doctor.register(planned)

        return planned
    }
}