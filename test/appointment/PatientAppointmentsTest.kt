package appointment

import id.Id

import org.junit.Test
import java.util.*
import kotlin.test.assertFails

internal class PatientAppointmentsTest {
    private val id = Id("medicalcard1");

    @Test
    fun throwWithOtherMedicalCard() {
        val patient = PatientAppointments(id, emptyList());
        assertFails {
            val appointment = Appointment(Id("medicalcard2"), Id("doctor"), Date());
            patient.register(appointment)
        }
    }

    @Test
    fun throwWithDatesIntersection() {
        val calendar = Calendar.getInstance();
        calendar.set(2021, 10, 15);

        val appointment = Appointment(id, Id("doctor"), calendar.time);
        val patient = PatientAppointments(id, listOf(appointment))

        assertFails {
            patient.register(appointment)
        }
    }
}