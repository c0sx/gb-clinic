package appointment;

import doctor.Doctor
import id.Id;
import medicalcard.MedicalCard
import medicalcard.MedicalRecord

import java.util.*

class Appointment(
    private val id: Id,
    private val medicalCard: MedicalCard,
    private val doctor: Doctor,
    private val date: Date
) {
    public fun addMedicalRecord(record: MedicalRecord) {
        if (!record.doctorId.isEqual(doctor.id)) {
            throw IllegalArgumentException("Приём назначен на другого доктора")
        }

        medicalCard.addMedicalRecord(record);
    }

    public fun isSame(appointment: Appointment): Boolean {
        val isSamePatient = medicalCard.isEqual(appointment.medicalCard);
        val isDateBusy = isSameDate(appointment.date);
        val isDoctorBusy = doctor.isEqual(appointment.doctor);

        return isSamePatient && isDateBusy && isDoctorBusy;
    }

    public fun isEqual(appointment: Appointment): Boolean {
        return id.isEqual(appointment.id);
    }

    private fun isSameDate(target: Date): Boolean {
        val diff = date.time - target.time;
        val seconds = diff / 1000;
        val minutes = seconds / 60;

        return minutes <= durationInMinutes();
    }

    private fun durationInMinutes(): Int = 20;
}