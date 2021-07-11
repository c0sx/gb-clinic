package reception.appointments

import reception.RegisterDate
import java.time.ZoneId
import java.util.*
import kotlin.math.abs

class Duration {
    public fun isIntersect(source: RegisterDate, target: RegisterDate): Boolean {
        val sourceDate = Date.from(source.date.atZone(ZoneId.systemDefault()).toInstant()).time
        val targetDate = Date.from(target.date.atZone(ZoneId.systemDefault()).toInstant()).time
        val diff = abs(sourceDate - targetDate)
        val seconds = diff / 1000
        val minutes = seconds / 60

        return minutes <= durationInMinutes()
    }

    private fun durationInMinutes(): Int = 20
}