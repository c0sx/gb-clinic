package medicalcard

import id.Id
import medicalcard.MedicalHistory
import medicalcard.MedicalRecord

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
        val record = MedicalRecord(Id("id"), "Record", Date(), Id("doctorId"));

        assertEquals(0, history.size())
        history.add(record);
        assertEquals(1, history.size())
    }
}