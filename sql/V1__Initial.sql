create table appointments
(
    id            uuid      not null
        constraint appointments_pkey
            primary key,
    patient_id    uuid      not null,
    doctor_id     uuid      not null,
    registered_at timestamp not null
);

create table doctors
(
    id uuid not null
        constraint doctors_pkey
            primary key
);

create table patients
(
    id         uuid         not null
        constraint patients_pkey
            primary key,
    user_id    uuid         not null,
    surname    varchar(100) not null,
    name       varchar(100) not null,
    birth_date date         not null
);
