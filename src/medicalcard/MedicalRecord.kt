package medicalcard

import id.Id

import java.util.*

data class MedicalRecord(
    public val id: Id,
    public val record: String,
    public val date: Date,
    public val doctorId: Id
)