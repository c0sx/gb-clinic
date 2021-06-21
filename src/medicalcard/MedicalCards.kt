package medicalcard

import id.Id

interface MedicalCards {
    fun getByPatientId(patientId: Id): MedicalCard
    fun save(card: MedicalCard)
}