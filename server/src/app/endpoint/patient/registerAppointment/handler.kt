package app.endpoint.patient.registerAppointment

import app.endpoint.doctor.DoctorSession
import reception.repository.Appointments
import reception.repository.Doctors
import reception.repository.Patients

import id.Id

import reception.RegisterAppointment
import reception.RegisterDate

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.sessions.*
import java.time.LocalDateTime
import java.time.ZoneId

fun Route.registerAppointment() {
    post("/api/patients/appointments") {
        val id = call.sessions.get<DoctorSession>()?.id ?: return@post call.respond(HttpStatusCode.BadRequest)
        val data = call.receive<RegisterAppointmentData>()

        val registry = RegisterAppointment(
            Doctors(),
            Patients(),
            Appointments()
        )

        val local = LocalDateTime.ofInstant(data.date.toInstant(), ZoneId.systemDefault())
        registry.register(Id(id), Id(data.doctorId), RegisterDate(local))

        call.respond(HttpStatusCode.OK)
    }
}