package app.endpoint.reception.doctors.newDoctor

import doctor.NewDoctor
import doctor.RegisterNewDoctor
import doctor.repository.Doctors
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.newDoctor() {
    post("/api/reception/doctors") {
        val data = call.receive<NewDoctorData>()

        val service = RegisterNewDoctor(
            Doctors()
        )

        service.register(NewDoctor(
            data.surname,
            data.name,
            data.middlename
        ))
        
        call.respond(HttpStatusCode.OK)
    }
}