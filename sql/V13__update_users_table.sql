truncate table users restart identity cascade;
alter table users alter column password_hash set not null;
