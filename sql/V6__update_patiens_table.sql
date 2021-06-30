alter table patients drop column surname;

alter table patients
	add created_at timestamp with time zone default now() not null;

alter table patients drop column name;

alter table patients
	add deleted_at timestamp with time zone;

