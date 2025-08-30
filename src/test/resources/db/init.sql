DROP TABLE IF EXISTS persons;

CREATE SEQUENCE IF NOT EXISTS persons_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE persons
(
    id           BIGINT       NOT NULL,
    name         VARCHAR(100) NOT NULL,
    surname      VARCHAR(150)  NOT NULL,
    gender      VARCHAR(25),
    CONSTRAINT pk_persons PRIMARY KEY (id)
);
insert into persons(id, name, surname, gender) values(1, 'anna', 'anina', 'female');
insert into persons(id, name, surname, gender) values(2, 'maria', 'mashina', 'female');
insert into persons(id, name, surname, gender) values(3, 'ekaterina', 'katina', 'female');
