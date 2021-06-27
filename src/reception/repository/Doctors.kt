package reception.repository

import app.database.dao.appointments.AppointmentEntity
import app.database.dao.appointments.Appointments
import app.database.dao.doctors.DoctorEntity
import id.Id
import reception.RegisterDate
import reception.appointments.Appointment
import reception.doctor.Doctor
import reception.Doctors as ReceptionDoctors

import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class Doctors: ReceptionDoctors {
    public override fun byId(id: Id): Doctor = transaction {
        val entity = DoctorEntity[id.toUUID()]

        val appointments = Appointments
            .select {
                Appointments.doctorId eq id.toUUID()
            }
            .iterator()
            .asSequence()
            .toList()

        return@transaction Doctor(
            Id(entity.id.toString()),
            appointments.map {
                val appointment = AppointmentEntity.wrapRow(it)
                Appointment(
                    Id(appointment.patientId.toString()),
                    Id(appointment.doctorId.toString()),
                    RegisterDate.fromLocalDateTime(appointment.appointmentAt)
                )
            }
        )
    }
}