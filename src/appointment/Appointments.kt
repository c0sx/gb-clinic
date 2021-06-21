package appointment

import appointment.appointments.Active
import appointment.appointments.NewPlanned
import appointment.appointments.Planned

import id.Id

interface Appointments {
    public fun plannedById(id: Id): Planned
    public fun add(appointment: NewPlanned)
    public fun add(appointment: Active)
}