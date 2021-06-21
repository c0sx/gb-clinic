package medicalcard

import id.Id

class MedicalCard(
    private val id: Id,
    private val patientId: Id,
    private val history: MedicalHistory
) {
    public fun addMedicalRecord(record: MedicalRecord) {
        history.add(record)
    }

    public fun isEqual(medicalCard: MedicalCard): Boolean {
        return id.isEqual(medicalCard.id)
    }
}