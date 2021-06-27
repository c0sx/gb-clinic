package app.reception

import id.Id
import reception.patient.Patient
import reception.Patients as ReceptionPatients

class Patients: ReceptionPatients {
    public override fun byId(id: Id): Patient {
        return Patient(
            id,
            emptyList()
        )
    }
}