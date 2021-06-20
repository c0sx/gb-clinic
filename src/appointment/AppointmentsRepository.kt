package appointment

import id.Id

interface AppointmentsRepository {
    fun getByMedicalCard(cardId: Id): Appointments;
    fun save(appointment: PatientAppointments);
}