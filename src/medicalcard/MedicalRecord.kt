package ru.gbclinic.medicalcard

import ru.gbclinic.id.Id

import java.util.*

data class MedicalRecord(
    public val id: Id,
    public val record: String,
    public val date: Date,
    public val doctorId: Id
)