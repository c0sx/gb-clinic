package app.patient.appointments.registerAppointment

import appointment.Appointment
import appointment.AppointmentsRepository

class RegisterAppointment(private val repository: AppointmentsRepository) {
    public fun register(appointment: Appointment) {
        val appointments = repository.get(appointment.medicalCardId, appointment.doctorId);
        appointments.register(appointment)

        repository.save(appointments)
    }
}