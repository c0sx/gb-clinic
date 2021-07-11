package app.endpoint.doctor

import app.endpoint.doctor.getAppointments.getAppointments
import app.endpoint.doctor.getInfo.getDoctorInfo
import app.endpoint.doctor.signout.signout
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.auth.*

import app.endpoint.doctor.singin.signin;

fun Application.doctorRouter() {
    routing {
        signin()

        authenticate("doctor-session") {
            getDoctorInfo()
            getAppointments()

            signout()
        }
    }
}