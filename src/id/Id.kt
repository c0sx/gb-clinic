package id

import java.util.*

class Id (private val id: String) {
    private fun value(): String = id

    public fun isEqual(id: Id): Boolean {
        return id.value() === value()
    }

    public fun toUUID(): UUID {
        return UUID.fromString(id)
    }
}