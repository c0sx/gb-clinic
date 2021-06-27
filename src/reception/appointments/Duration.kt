package reception.appointments

import reception.RegisterDate
import kotlin.math.abs

class Duration {
    public fun isIntersect(source: RegisterDate, target: RegisterDate): Boolean {
        val diff = abs(source.date.time - target.date.time)
        val seconds = diff / 1000
        val minutes = seconds / 60

        return minutes <= durationInMinutes()
    }

    private fun durationInMinutes(): Int = 20
}