package doctor.repository

import app.database.dao.doctors.DoctorEntity
import app.database.dao.users.UserEntity
import doctor.NewDoctor
import doctor.Doctors as Repository

import org.jetbrains.exposed.sql.transactions.transaction

class Doctors: Repository {
    public override fun add(doctor: NewDoctor): Unit = transaction {
        val user = UserEntity.new {
            surname = doctor.surname
            name = doctor.name
            middlename = doctor.middlename
        }

        DoctorEntity.new {
            userId = user.id.value
        }
    }
}