package reception

import id.Id
import reception.doctor.Doctor

interface Doctors {
    public fun byId(doctorId: Id): Doctor
}