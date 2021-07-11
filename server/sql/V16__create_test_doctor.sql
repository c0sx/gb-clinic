INSERT INTO users (id, surname, name, middlename, created_at, deleted_at, password_hash, username)
    VALUES ('49846f00-838b-48ac-b802-8f7330e92b4a', 'Докторов', 'Доктор', null, '2021-07-11 20:59:16.846000', null, '$2a$12$ziK3.bmzmzaU06GsfUpPzeLErCeZrOup4iYs/FiPc3Jx3ZUTULYLe', 'doctor');

INSERT INTO public.doctors (id, user_id, created_at, deleted_at) VALUES ('f16be36d-2ba4-4e0a-b1c5-4c17cd1af879', '49846f00-838b-48ac-b802-8f7330e92b4a', '2021-07-11 18:06:19.797650', null);