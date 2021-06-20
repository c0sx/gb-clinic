package appointment

class Appointments(
    private val patient: PatientAppointments,
    private val doctor: DoctorAppointments
) {
//    public fun register(appointment: Appointment): NewAppointment {
//        val isPatientNotBusy = patient.isNotBusy(appointment);
//    }
//    public fun register(appointment: PatientAppointments) {
//        val isBusy = appointments.any {
//            it.isSame(appointment)
//        }
//
//        if (isBusy) {
//            throw Exception("Нельзя записаться на это время")
//        }
//
//        appointments.add(appointment);
//    }
}