package app

import app.database.dao.doctors.DoctorEntity
import app.database.dao.patients.PatientEntity
import app.endpoint.doctor.DoctorSession
import app.database.initDatabase
import app.endpoint.doctor.doctorRouter
import app.endpoint.patient.PatientSession
import app.endpoint.patient.patientRouter
import app.endpoint.reception.receptionRouter
import app.serialize.deserialize
import app.serialize.serialize

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.routing.*
import io.ktor.gson.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.sessions.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(ContentNegotiation) {
        gson {
            registerTypeAdapter(Date::class.java, serialize)
            registerTypeAdapter(Date::class.java, deserialize)
        }
    }

    initDatabase()

    install(Sessions) {
        cookie<DoctorSession>("doctor-cookie", storage = SessionStorageMemory())
        cookie<PatientSession>("patient-cookie", storage = SessionStorageMemory())
    }

    install(Authentication) {
        session<DoctorSession>("doctor-session") {
            validate {
                val doctor = transaction {
                    DoctorEntity.findById(UUID.fromString(it.id))
                }

                if (doctor != null) {
                    it
                } else {
                    null
                }
            }

            challenge {
                call.respond(UnauthorizedResponse())
            }
        }

        session<PatientSession>("patient-session") {
            validate {
                val patient = transaction {
                    PatientEntity.findById(UUID.fromString(it.id))
                }

                if (patient != null) {
                    it
                } else {
                    null
                }
            }

            challenge {
                call.respond(UnauthorizedResponse())
            }
        }
    }


    routing {
        patientRouter()
        receptionRouter()
        doctorRouter()
    }
}

