package patient

import id.Id

import java.time.LocalDate
import java.time.Period
import java.util.*

class Patient(
    public val id: Id,
    public val surname: String,
    public val name: String,
    public val sex: Sex,
    private val dateOfBirth: Date,
) {
    public fun age(): Int {
        val calendar = Calendar.getInstance()
        calendar.time = dateOfBirth

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val date = calendar.get(Calendar.DAY_OF_MONTH)

        val period = Period.between(LocalDate.of(year, month, date), LocalDate.now())
        return period.years
    }
}