package app.reception

import id.Id
import reception.doctor.Doctor
import reception.Doctors as ReceptionDoctors

class Doctors: ReceptionDoctors {
    public override fun byId(doctorId: Id): Doctor {
        return Doctor(
            doctorId,
            emptyList()
        )
    }
}