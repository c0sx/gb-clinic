package id

class Id (private val id: String) {
    private fun value(): String = id

    public fun isEqual(id: Id): Boolean {
        return id.value() === value()
    }
}