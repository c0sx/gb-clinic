package app.reception

import app.database.dao.appointments.AppointmentEntity
import app.database.dao.patients.PatientEntity
import app.database.dao.appointments.Appointments
import id.Id
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import reception.RegisterDate
import reception.appointments.Appointment
import reception.patient.Patient
import reception.Patients as ReceptionPatients

class Patients: ReceptionPatients {
    public override fun byId(id: Id): Patient = transaction {
        val entity = PatientEntity[id.toUUID()]

        val appointments = Appointments
            .select {
                Appointments.patientId eq id.toUUID()
            }
            .iterator()
            .asSequence()
            .toList()

        return@transaction Patient(
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