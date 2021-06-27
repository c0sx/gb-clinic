package reception

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
}