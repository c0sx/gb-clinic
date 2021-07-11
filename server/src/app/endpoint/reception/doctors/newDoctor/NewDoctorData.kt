package app.endpoint.reception.doctors.newDoctor

data class NewDoctorData(
    public val surname: String,
    public val name: String,
    public val middlename: String?
)