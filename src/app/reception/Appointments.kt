package app.reception

import reception.appointments.Appointment
import reception.Appointments as ReceptionAppointments

class Appointments: ReceptionAppointments {
    private val appointments: MutableList<Appointment> = emptyList<Appointment>().toMutableList()

    override fun add(appointment: Appointment) {
        appointments.add(appointment)
    }
}