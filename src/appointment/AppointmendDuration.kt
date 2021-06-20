package appointment

import kotlin.math.abs

class Duration(private val appointment: Appointment) {
    public fun isIntersect(target: Appointment): Boolean {
        val diff = abs(target.date.time - appointment.date.time);
        val seconds = diff / 1000;
        val minutes = seconds / 60;

        return minutes <= durationInMinutes();
    }

    private fun durationInMinutes(): Int = 20;
}