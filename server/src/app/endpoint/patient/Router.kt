package app.endpoint.patient

import app.endpoint.patient.signout.signout
import app.endpoint.patient.getAppointments.getAppointments
import app.endpoint.patient.getDoctors.getDoctors
import app.endpoint.patient.getInfo.getPatientInfo
import app.endpoint.patient.signin.singin
import app.endpoint.patient.registerAppointment.registerAppointment
import app.endpoint.patient.signup.signup

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.auth.*

fun Application.patientRouter() {
    routing {
        singin()
        signup()

        authenticate("patient-session") {
            getPatientInfo()
            getDoctors()
            getAppointments()
            registerAppointment()

            signout()
        }
    }
}