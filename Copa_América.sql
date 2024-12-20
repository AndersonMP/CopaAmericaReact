
drop table if exists country;
create table country (
	country_name varchar (100) not null,
	country_code int primary key not null,
	country_iso3 varchar(5) not null
);

drop table if exists football_match;
create table football_match (
	match_id serial primary key,
	country_code_t1 int not null,
	country_code_t2 int not null,
	match_date timestamp not null,
	constraint team1_fk
	foreign key (country_code_t1)
	references country (country_code),
	constraint team2_fk
	foreign key (country_code_t2)
	references country (country_code),
	constraint chk_diff_team check (country_code_t1 <> country_code_t2)
);

drop table if exists users;
create table users (
	user_id serial primary key,
	cedula varchar(10) not null,
	user_name varchar(100) not null,
	user_last_name varchar(100) not null
);

drop table if exists forecast;
create table forecast (
    fcast_id serial primary key,
    user_id int not null,
    match_id int not null,
    country_code_t1 int not null,
    score_t1 int not null,
    country_code_t2 int not null,
    score_t2 int not null,
    constraint fk_forecast_user foreign key (user_id) references users (user_id),
    constraint fk_forecast_match foreign key (match_id) references football_match (match_id),
    constraint fk_forecast_team1_country foreign key (country_code_t1) references country (country_code),
    constraint fk_forecast_team2_country foreign key (country_code_t2) references country (country_code)
);

-- Registro Equipos
insert into country (country_name, country_code, country_iso3) values
('Argentina', 032, 'ARG'),
('Bolivia', 068, 'BOL'),
('Brasil', 076, 'BRA'),
('Chile', 152, 'CHL'),
('Canadá', 124, 'CAN'),
('Colombia', 170, 'COL'),
('Costa Rica', 188, 'CRI'),
('Ecuador', 218, 'ECU'),
('Estados Unidos', 840, 'USA'),
('Jamaica', 388, 'JAM'),
('México', 484, 'MEX'),
('Panamá', 591, 'PAN'),
('Paraguay', 600, 'PRY'),
('Perú', 604, 'PER'),
('Uruguay', 858, 'URY'),
('Venezuela', 862, 'VEN');

-- Registro 10 primeros encuentros
insert into football_match (country_code_t1, country_code_t2, match_date) values
(032, 124, '2024-06-20 00:00:00'), -- Argentina vs Canada
(604, 152, '2024-06-21 00:00:00'), -- Perú vs Chile
(484, 388, '2024-06-22 00:00:00'), -- Mexico vs Jamaica
(218, 862, '2024-06-22 00:00:00'), -- Ecuador vs Venezuela
(840, 068, '2024-06-23 00:00:00'), -- Estados Unidos vs Bolivia
(858, 591, '2024-06-23 00:00:00'), -- Uruguay vs Panama
(076, 188, '2024-06-24 00:00:00'), -- Brasil vs Costa Rica
(170, 600, '2024-06-24 00:00:00'), -- Colombia vs Paraguay
(152, 032, '2024-06-25 00:00:00'), -- Chile vs Argentina
(604, 124, '2024-06-25 00:00:00'); -- Perú vs Canada

-- Registro Usuarios
insert into users (cedula, user_name, user_last_name) values
('0102030405', 'María', 'Nuñez'),
('0203040506', 'José', 'Cacuango'),
('0304050607', 'Pedro', 'Ramirez');

-- Pronósticos de María Nuñez:
insert into forecast (user_id, match_id, country_code_t1, score_t1, country_code_t2, score_t2) values
(1, 4, 218, 2, 862, 1), -- Ecuador vs Venezuela
(1, 1, 32, 2, 124, 0), -- Argentina vs Canada
(1, 2, 604, 1, 152, 1); -- Perú vs Chile

-- Pronóstico José Cacuango
insert into forecast (user_id, match_id, country_code_t1, score_t1, country_code_t2, score_t2) values
(2, 4, 218, 1, 862, 2), -- Ecuador vs Venezuela
(2, 5, 840, 2, 68, 0), -- Estados Unidos vs Bolivia
(2, 6, 858, 3, 591, 1); -- Uruguay vs Panama

-- Pronósticos de Pedro Ramírez:
insert into forecast (user_id, match_id, country_code_t1, score_t1, country_code_t2, score_t2) values
(2, 4, 218, 1, 862, 2), -- Ecuador vs Venezuela
(2, 5, 840, 2, 68, 0), -- Estados Unidos vs Bolivia
(2, 6, 858, 3, 591, 1); -- Uruguay vs Panama


SELECT 
    fm.match_id,
    c1.country_name AS team1,
    c2.country_name AS team2,
    fm.match_date
FROM 
    football_match fm
JOIN 
    country c1 ON fm.country_code_t1 = c1.country_code
JOIN 
    country c2 ON fm.country_code_t2 = c2.country_code
WHERE 
    DATE(fm.match_date) = '2024-06-22';


SELECT 
    u.cedula,
    u.user_name,
    u.user_last_name,
    c1.country_name AS team1,
    f.score_t1,
    c2.country_name AS team2,
    f.score_t2,
	fm.match_date
FROM 
    forecast f
JOIN 
    users u ON f.user_id = u.user_id
JOIN 
    country c1 ON f.country_code_t1 = c1.country_code
JOIN 
    country c2 ON f.country_code_t2 = c2.country_code
JOIN 
    football_match fm ON f.match_id = fm.match_id	
WHERE 
    u.cedula = '0102030405';


SELECT 
    f.match_id,
    u.user_id,
    u.user_name,
    u.user_last_name,
    c1.country_name AS team1,
    f.score_t1,
    c2.country_name AS team2,
    f.score_t2
FROM 
    forecast f
JOIN 
    users u ON f.user_id = u.user_id
JOIN 
    country c1 ON f.country_code_t1 = c1.country_code
JOIN 
    country c2 ON f.country_code_t2 = c2.country_code
WHERE 
    f.match_id = 4; 

select current_database();
select * from users;
select * from country;
select * from football_match;
select * from forecast;

