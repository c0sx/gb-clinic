package appointment

class Appointments(list: List<Appointment>) {
    private val appointments = list.toMutableList();

    public fun register(appointment: Appointment) {
        val isBusy = appointments.any {
            it.isSame(appointment)
        }

        if (isBusy) {
            throw Exception("Нельзя записаться на это время")
        }

        appointments.add(appointment);
    }
}