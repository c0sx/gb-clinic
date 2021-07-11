truncate doctors restart identity cascade;

alter table doctors
	add user_uuid uuid not null;

alter table doctors
	add created_at timestamp with time zone default now() not null;

alter table doctors
	add deleted_at timestamp with time zone;

alter table doctors
	add constraint doctors_users_id_fk
		foreign key (user_uuid) references users
			on update restrict on delete restrict;
