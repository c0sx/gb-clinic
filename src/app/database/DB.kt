package app.database

import io.ktor.application.*
import org.jetbrains.exposed.sql.Database

fun Application.initDatabase() {
    val url = System.getenv("DATABASE_URL") ?: throw Exception("DATABASE_URL not found")
    val user = System.getenv("DATABASE_USER") ?: throw Exception("DATABASE_USER not found")
    val password = System.getenv("DATABASE_PASSWORD") ?: throw Exception("DATABASE_PASSWORD not found")

    Database.connect(
        "jdbc:$url",
        driver = "com.impossibl.postgres.jdbc.PGDriver",
        user = user,
        password = password
    )
}
