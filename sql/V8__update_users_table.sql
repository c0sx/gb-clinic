alter table users
	add created_at timestamp with time zone default now() not null;

alter table users
	add deleted_at timestamp with time zone;

