package reception

import java.time.LocalDateTime

class RegisterDate(date: LocalDateTime) {
    public val date: LocalDateTime = LocalDateTime.of(
        date.year,
        date.month,
        date.dayOfMonth,
        date.hour,
        date.minute
    )
}