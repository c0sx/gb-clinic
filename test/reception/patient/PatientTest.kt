package reception.patient

import id.Id
import reception.appointments.Appointment

import java.util.*

import kotlin.test.BeforeTest
import kotlin.test.assertFails

import org.junit.Test
import reception.RegisterDate

internal class PatientTest {
    private lateinit var patientId: Id
    private lateinit var doctorId: Id

    @BeforeTest
    fun beforeTest() {
        patientId = Id("patientId1")
        doctorId = Id("doctorId1")
    }

    @Test
    fun throwOnInvalidPatientRegister() {
        val patient = Patient(
            patientId,
            emptyList()
        )

        assertFails {
            val wrongPatientId = Id("patientId2")
            patient.register(Appointment(wrongPatientId, doctorId, RegisterDate(Date())))
        }
    }

    @Test
    fun throwOnPatientAlreadyRegisteredOnDate() {
        val date = Calendar
            .getInstance()
            .apply {
                set(2021, 10, 10, 15, 30)
            }
            .time

        val patient = Patient(
            patientId,
            listOf(Appointment(patientId, doctorId, RegisterDate(date)))
        )

        assertFails {
            patient.register(Appointment(patientId, doctorId, RegisterDate(date)))
        }
    }
}