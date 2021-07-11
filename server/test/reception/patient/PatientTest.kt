package reception.patient

import id.Id
import org.junit.Test
import org.junit.jupiter.api.BeforeEach
import reception.appointments.Appointment

import kotlin.test.BeforeTest
import kotlin.test.assertFails

import reception.RegisterDate
import java.time.LocalDateTime

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
            val date = LocalDateTime.of(2021, 6, 6, 15, 13, 10)
            patient.register(Appointment(wrongPatientId, doctorId, RegisterDate(date)))
        }
    }

    @Test
    fun throwOnPatientAlreadyRegisteredOnDate() {
        val date = LocalDateTime.of(2021, 10, 10, 15, 30, 59)

        val patient = Patient(
            patientId,
            listOf(Appointment(patientId, doctorId, RegisterDate(date)))
        )

        assertFails {
            patient.register(Appointment(patientId, doctorId, RegisterDate(date)))
        }
    }
}