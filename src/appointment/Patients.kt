package appointment

import appointment.patient.Patient
import id.Id

interface Patients {
    public fun byId(id: Id): Patient
}