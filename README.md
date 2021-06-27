### запуск
`./gradlew installDist`

`docker-compose up -d --build`

`http://localhost:8000`

### описание

Приложение для автоматизации процесса приёма в поликлинике.

Приложение должно выполнять следующий минимальный функционал
- пациент может записаться к выбранному врачу на примерное время
- пациент может отменить запись
- пациент может видеть текущие записи
- пациент может видеть историю своих посещений
- врач может видеть очередь записанных пациентов на сегодняшний день
- врач может проводить прием пациента

Сущности предметной области: 
- медицинская карта пациента
- запись
- очередь 
- приём

Ограничения:
- у пациента может быть одна мед карта
- пациент может записаться только к одному врачу на одно и тоже время
- у врача может быть сколько угодно записей в пределах свободного времени
- ограничим время приема 20 минутами

Структура приложения:
web, клиент-серверное
Клиент SPA
Сервер MVC
Доступ к данным Repository

Проектирование сущностей домена:
Врач (ид, фио, специальность, кабинет)
Пациент (ид, фио, пол, дата рождения)
Медицинская карта (ид, пациент, история)
Запись (ид, пациент, врач, время)
Приём (врач, медицинская карта, запись)

Модули:
- регистрации и аутентификации
- записи ко врачу
- очереди для врача
- приёма пациента

Контроллеры: 
- регистрации и аутентификации
- записи и истории записей пациента
- очереди для врача
- медицинской карты пациента

Сущности базы данных:
- Пользователи (ид, фио, логин, пароль)
- Врачи (ид, ид пользователя, ид специальности, кабинет)
- Специальности (ид, название)
- Медицинская карта (ид, ид пользователя, дата рождения, пол, дата заведения)
- Записи медицинской карты (ид, ид карты, запись)
- Записи (ид, ид пользователя, ид, врача, время)

Представление:
- SPA с подключением к API. Содержит экран регистрации и аутентфикации. 
Для пациентов:
- экран с выбором врача, и времени записи
- экран с историей записей ко врачам
Для врачей:
- экран с очередью записей на текущий день
- экран с мед картой пациента и возможность вносить новые записи
