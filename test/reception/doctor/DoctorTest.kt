package reception.doctor

import id.Id
import org.junit.Test
import reception.RegisterDate
import reception.appointments.Appointment
import java.util.*
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
            doctor.register(Appointment(patientId, wrongDoctorId, RegisterDate(Date())))
        }
    }

    @Test
    fun throwOnDoctorIsBusyForAppointmentDate() {
        val firstAppointment = Calendar
            .getInstance()
            .apply {
                set(2021, 10, 10, 15, 30)
            }
            .time

        val secondAppointment = Calendar
            .getInstance()
            .apply {
                set(2021, 10, 10, 16, 0)
            }
            .time

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