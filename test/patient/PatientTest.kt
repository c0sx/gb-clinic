package ru.gbclinic.patient

import ru.gbclinic.id.Id
import java.time.LocalDate

import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

internal class PatientTest {
    @Test
    fun testAgeWithBirthday() {
        val calendar = Calendar.getInstance();
        val now = LocalDate.now();

        calendar.set(1995, now.month.value, now.dayOfMonth);
        calendar.add(Calendar.MONTH, -1);

        val patient = Patient(Id("id"), "Surname", "Name", Sex.Male, calendar.time);

        assertEquals(26, patient.age(), "Возраст не совпадает")
    }

    @Test
    fun testAgeWithoutBirthday() {
        val calendar = Calendar.getInstance();
        val now = LocalDate.now();

        calendar.set(1995, now.month.value, now.dayOfMonth);
        calendar.add(Calendar.MONTH, 1);

        val patient = Patient(Id("id"), "Surname", "Name", Sex.Male, calendar.time);

        assertEquals(25, patient.age(), "Возраст не совпадает")
    }
}