package app.database.dao.patients

import app.database.dao.users.Users
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.`java-time`.date

object Patients: UUIDTable("patients") {
    val userId = uuid("user_id").references(Users.id)
    val dateOfBirth = date("birth_date")
}