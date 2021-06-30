package reception.doctor

import id.Id
import org.junit.Test
import reception.RegisterDate
import reception.appointments.Appointment
import java.time.LocalDateTime
import kotlin.test.BeforeTest
import kotlin.test.assertFails

internal class DoctorTest {
    private lateinit var doctorId: Id
    private lateinit var patientId: Id

    @BeforeTest
    fun beforeTest() {
        doctorId = Id("doctorId1")
        patientId = Id("patientId1")
    }

    @Test
    fun throwOnInvalidDoctorRegister() {
        val doctor = Doctor(
            doctorId,
            emptyList()
        )

        assertFails {
            val wrongDoctorId = Id("doctorId2")
            doctor.register(Appointment(patientId, wrongDoctorId, RegisterDate(
                LocalDateTime.of(2021, 10, 10, 15, 30, 10)
            )))
        }
    }

    @Test
    fun throwOnDoctorIsBusyForAppointmentDate() {
        val firstAppointment = LocalDateTime.of(2021, 10, 10, 15, 30, 20)
        val secondAppointment = LocalDateTime.of(2021, 10, 10, 16, 0, 10)

        val doctor = Doctor(
            doctorId,
            listOf(
                Appointment(patientId, doctorId, RegisterDate(firstAppointment)),
                Appointment(patientId, doctorId, RegisterDate(secondAppointment))
            )
        )

        assertFails {
            doctor.register(Appointment(patientId, doctorId, RegisterDate(secondAppointment)))
        }
    }
}