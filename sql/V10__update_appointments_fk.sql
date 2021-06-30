alter table appointments
	add constraint appointments_doctors_id_fk
		foreign key (doctor_id) references doctors
			on update restrict on delete restrict;

alter table appointments
	add constraint appointments_patients_id_fk
		foreign key (patient_id) references patients
			on update restrict on delete restrict;

