package reception

import id.Id
import reception.reception.Reception

class RegisterAppointment(
    private val doctors: Doctors,
    private val patients: Patients,
    private val appointments: Appointments
) {
    public fun register(patientId: Id, doctorId: Id, date: RegisterDate) {
        val patient = patients.byId(patientId)
        val doctor = doctors.byId(doctorId)

        val reception = Reception(patient, doctor)
        val appointment = reception.register(patientId, doctorId, date)

        appointments.add(appointment)
    }
}