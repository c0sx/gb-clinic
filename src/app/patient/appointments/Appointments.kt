package app.patient.appointments

import appointment.Appointments
import appointment.AppointmentsRepository
import id.Id

class Appointments: AppointmentsRepository {
    override fun get(medicalCardId: Id, doctorId: Id): Appointments {
        TODO("Not yet implemented")
    }

    override fun save(appointment: Appointments) {
        TODO("Not yet implemented")
    }
}