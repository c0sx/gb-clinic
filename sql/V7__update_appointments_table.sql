alter table appointments
	add created_at timestamp with time zone default now() not null;

alter table appointments
	add deleted_at timestamp with time zone;

