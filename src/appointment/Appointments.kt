package appointment

import id.Id

class Appointments(
    private val medicalCardId: Id,
    private val doctorId: Id,
    list: List<Appointment>
) {
    private val  appointments = list.toMutableList();

    public fun register(appointment: Appointment) {
        if (!appointment.medicalCardId.isEqual(medicalCardId)) {
            throw Exception("Запись не относится к пациенту");
        }

        if (!appointment.doctorId.isEqual(doctorId)) {
            throw Exception("Запись не относится к доктору");
        }

        if (isBusy(appointment)) {
            throw Exception("Время записи занято");
        }

        appointments.add(appointment);
    }

    private fun isBusy(appointment: Appointment): Boolean {
        return appointments.any {
            it.isIntersect(appointment)
        }
    }
}