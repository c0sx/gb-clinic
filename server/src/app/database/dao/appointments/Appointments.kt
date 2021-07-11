package app.database.dao.appointments

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.`java-time`.datetime

object Appointments: UUIDTable("appointments") {
    val patientId = uuid("patient_id")
    val doctorId = uuid("doctor_id")
    val appointmentAt = datetime("registered_at")
}


