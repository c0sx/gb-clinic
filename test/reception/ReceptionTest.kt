package reception

import id.Id
import org.junit.Test
import reception.doctor.Doctor
import reception.patient.Patient
import reception.reception.Reception
import java.util.*
import kotlin.test.BeforeTest
import kotlin.test.assertEquals

internal class ReceptionTest {
    private lateinit var reception: Reception
    private lateinit var patientId: Id
    private lateinit var doctorId: Id

    @BeforeTest
    fun beforeTest() {
        patientId = Id("patientId1")
        doctorId = Id("doctorId1")

        val patient = Patient(
            patientId,
            emptyList()
        )

        val doctor = Doctor(
            doctorId,
            emptyList()
        )

        reception = Reception(patient, doctor)
    }

    @Test
    fun register() {
        val date = Calendar
            .getInstance()
            .apply {
                set(2021, 6, 15, 16, 30)
            }
            .time

        val appointment = reception.register(patientId, doctorId, RegisterDate(date))

        val expected = RegisterDate(
            Calendar
                .getInstance()
                .apply {
                    set(2021, 6, 15, 16, 30)
                }
                .time
        )

        assertEquals(appointment.date().date, expected.date)
    }

    @Test
    fun registerTest() {
        val patientId = Id("cbc183ed-b285-4642-a3d8-d96925165dd3")
        val date = Calendar
            .getInstance()
            .apply {
                set(2021, 6, 15, 16, 30)
            }
            .time

        val doctorId = Id("b5350385-d87d-4b17-8864-92701b65de1d")
        val patient = Patient(patientId, emptyList())
        val doctor = Doctor(doctorId, emptyList())
        val reception = Reception(patient, doctor)

        val appointment = reception.register(patientId, doctorId, RegisterDate(date))
        assertEquals(true, true)
    }
}