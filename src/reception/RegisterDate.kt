package reception

import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class RegisterDate(date: Date) {
    public val date: Date = Calendar
        .getInstance()
        .apply {
            time = date
            clear(Calendar.SECOND)
            clear(Calendar.MILLISECOND)
        }
        .time

    public fun toLocalDateTime(): LocalDateTime {
        val calendar = Calendar
            .getInstance()
            .apply {
                time = date
            }

        return LocalDateTime.of(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH),
            calendar.get(Calendar.HOUR),
            calendar.get(Calendar.MINUTE),
        )
    }

    companion object {
        public fun fromLocalDateTime(dateTime: LocalDateTime): RegisterDate {
            return RegisterDate(
                Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant())
            )
        }
    }
}