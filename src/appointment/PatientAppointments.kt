package appointment;

import id.Id;

class PatientAppointments(
    private val medicalCardId: Id,
    list: List<Appointment>,
) {
    private val appointments = list.toMutableList();

    public fun register(appointment: Appointment) {
        if (!appointment.medicalCardId.isEqual(medicalCardId)) {
            throw Exception("Запись не относится к пользователю")
        }

        if (isBusy(appointment)) {
            throw Exception("Время записи занято")
        }

        appointments.add(appointment)
    }

    private fun isBusy(appointment: Appointment): Boolean {
        return appointments.any {
            it.isIntersect(appointment)
        }
    }
}