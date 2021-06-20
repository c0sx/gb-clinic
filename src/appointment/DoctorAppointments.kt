package appointment

class DoctorAppointments(
    private val doctor: Doctor,
    list: List<PatientAppointments>
) {
    private val appointments = list.toMutableList();

    public fun register(appointment: PatientAppointments) {
//        if (doctor.id.isEqual(appointment.doctorId)) {
//            throw Exception("Запись не относится к доктору")
//        }

//        val isBusy = appointments.any {
//            it.isSameDate(appointment)
//        }
    }
}