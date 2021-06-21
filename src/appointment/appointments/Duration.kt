package appointment.appointments

import java.util.*
import kotlin.math.abs

class Duration {
    public fun isIntersect(source: Date, target: Date): Boolean {
        val diff = abs(source.time - target.time)
        val seconds = diff / 1000
        val minutes = seconds / 60

        return minutes <= durationInMinutes()
    }

    private fun durationInMinutes(): Int = 20
}