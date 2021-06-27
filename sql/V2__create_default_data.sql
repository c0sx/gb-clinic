CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;

insert into doctors (id) values (uuid_generate_v4());
insert into patients (id, user_id, surname, name, birth_date) values
    (uuid_generate_v4(), uuid_generate_v4(), 'Иванов', 'Иван', '1990-06-10');