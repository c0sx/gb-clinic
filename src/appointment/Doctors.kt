package appointment

import appointment.doctor.Doctor
import id.Id

interface Doctors {
    public fun byId(doctorId: Id): Doctor
}