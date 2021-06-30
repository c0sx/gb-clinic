create table users
(
	id uuid not null
		constraint users_pk
			primary key,
	surname varchar(300) not null,
	name varchar(300) not null,
	middlename varchar(300)
);