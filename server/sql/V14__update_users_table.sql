alter table users alter column password_hash type varchar(256) using password_hash::varchar(256);
