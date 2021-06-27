package app.database.dao.patients

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.`java-time`.date

object Patients: UUIDTable("patients") {
    val userId = uuid("user_id")
    val surname = varchar("surname", length = 100)
    val name = varchar("name", length = 100)
    val dateOfBirth = date("birth_date")
}