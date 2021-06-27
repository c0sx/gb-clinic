package reception.repository

import app.database.dao.appointments.AppointmentEntity
import org.jetbrains.exposed.sql.transactions.transaction
import reception.appointments.Appointment
import reception.Appointments as ReceptionAppointments

class Appointments: ReceptionAppointments {
    override fun add(appointment: Appointment): Unit = transaction {
        AppointmentEntity.new {
            patientId = appointment.patientId().toUUID()
            doctorId = appointment.doctorId().toUUID()
            appointmentAt = appointment.date().date
        }
    }
}