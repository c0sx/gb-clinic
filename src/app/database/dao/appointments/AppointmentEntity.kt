package app.database.dao.appointments

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