package medicalcard;

import id.Id;
import patient.Patient;

class MedicalCard(
    private val id: Id,
    private val patient: Patient,
    private val history: MedicalHistory
) {
    public fun isAssignedForPatient(target: Patient): Boolean {
        return patient.id.isEqual(target.id);
    }

    public fun addMedicalRecord(record: MedicalRecord) {
        history.add(record);
    }

    public fun isEqual(medicalCard: MedicalCard): Boolean {
        return id.isEqual(medicalCard.id);
    }
}