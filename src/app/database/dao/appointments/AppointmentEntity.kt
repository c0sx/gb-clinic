package app.database.dao.appointments

import app.database.dao.doctors.DoctorEntity
import app.database.dao.doctors.Doctors
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class AppointmentEntity(id: EntityID<UUID>): UUIDEntity(id) {
    companion object: UUIDEntityClass<AppointmentEntity>(Appointments)

    var patientId by Appointments.patientId
    var doctorId by Appointments.doctorId

    var appointmentAt by Appointments.appointmentAt
}