package app.database.dao.patients

import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class PatientEntity(id: EntityID<UUID>): UUIDEntity(id) {
    companion object: UUIDEntityClass<PatientEntity>(Patients)

    var userId by Patients.userId
    var surname by Patients.surname
    var name by Patients.name
    var dateOfBirth by Patients.dateOfBirth
}