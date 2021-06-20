package ru.gbclinic.medicalcard;

import ru.gbclinic.id.Id;
import ru.gbclinic.patient.Patient;

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