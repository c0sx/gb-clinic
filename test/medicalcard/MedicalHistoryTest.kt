package ru.gbclinic.medicalcard

import ru.gbclinic.doctor.Doctor
import ru.gbclinic.id.Id

import java.util.*
import org.junit.Test

import kotlin.test.BeforeTest
import kotlin.test.assertEquals

internal class MedicalHistoryTest {

    private lateinit var history: MedicalHistory;

    @BeforeTest
    fun beforeTest() {
        history = MedicalHistory(emptyList());
    }

    @Test
    fun addMedicalRecord() {
        val office = 200;
        val doctor = Doctor(Id("id"), "Surname", "Name", office);
        val record = MedicalRecord(Id("id"), "Record", Date(), doctor);

        assertEquals(0, history.size())
        history.add(record);
        assertEquals(1, history.size())
    }
}