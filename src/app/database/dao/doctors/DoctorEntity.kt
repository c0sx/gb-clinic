package app.database.dao.doctors

import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class DoctorEntity(id: EntityID<UUID>): UUIDEntity(id) {
    companion object: UUIDEntityClass<DoctorEntity>(Doctors)

    var userId by Doctors.userId
}