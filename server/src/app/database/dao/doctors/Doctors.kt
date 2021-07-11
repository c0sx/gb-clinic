package app.database.dao.doctors

import app.database.dao.users.Users
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.`java-time`.timestamp

object Doctors: UUIDTable("doctors") {
    val userId = uuid("user_id").references(Users.id)
    val deletedAt = timestamp("deleted_at").nullable()
}

