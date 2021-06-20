package appointment

import id.Id

interface AppointmentsRepository {
    fun get(medicalCardId: Id, doctorId: Id): Appointments;
    fun save(appointment: Appointments);
}