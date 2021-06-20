package appointment

import id.Id

data class Doctor(
    public val id: Id,
    public val surname: String,
    public val name: String,
    public val office: Int
) {
    public fun isEqual(doctor: Doctor): Boolean {
        return id.isEqual(doctor.id);
    }
}