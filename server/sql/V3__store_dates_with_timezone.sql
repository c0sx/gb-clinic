alter table appointments
    alter column registered_at type timestamp with time zone using registered_at::timestamp with time zone;

