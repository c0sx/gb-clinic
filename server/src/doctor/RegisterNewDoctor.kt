package doctor

class RegisterNewDoctor(
    private val doctors: Doctors
) {
    public fun register(doctor: NewDoctor) {
        doctors.add(doctor)
    }
}