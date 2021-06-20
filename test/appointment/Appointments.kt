package appointment

import id.Id

import org.junit.Test
import java.util.*
import kotlin.test.BeforeTest
import kotlin.test.assertFails

internal class AppointmentsTest {
    private val doctorId = Id("doctor1");
    private val medicalCardId = Id("medicalcard1");
    private lateinit var appointments: Appointments;

    @BeforeTest
    fun beforeTest() {
        appointments = Appointments(medicalCardId, doctorId, emptyList());
    }

    @Test
    fun throwWithOtherMedicalCard() {
        val appointment = Appointment(Id("mediacard2"), doctorId, Date());

        assertFails {
            appointments.register(appointment)
        }
    }

    @Test
    fun throwWithOtherDoctor() {
        val appointment = Appointment(medicalCardId, Id("doctor2"), Date());

        assertFails {
            appointments.register(appointment)
        }
    }

    @Test
    fun throwWithDatesIntersect() {
        val calendar = Calendar.getInstance();
        calendar.set(2021, 10, 15);

        val appointment = Appointment(medicalCardId, doctorId, calendar.time);

        appointments.register(appointment);

        assertFails {
            appointments.register(appointment)
        }
    }
}