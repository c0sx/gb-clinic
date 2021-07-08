truncate table users restart identity cascade;
alter table users
   	add username varchar(100) not null;
