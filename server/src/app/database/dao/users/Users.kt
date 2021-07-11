package app.database.dao.users

import org.jetbrains.exposed.dao.id.UUIDTable

object Users: UUIDTable("users") {
    val surname = varchar("surname", 300)
    val name = varchar("name", 300)
    val middlename = varchar("middlename", 300).nullable()
    val username = varchar("username", 100)
    val password = varchar("password_hash", 256)
}