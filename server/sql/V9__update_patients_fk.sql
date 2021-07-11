truncate patients restart identity cascade;

alter table patients
	add constraint patients_users_id_fk
		foreign key (user_id) references users
			on update restrict on delete restrict;

