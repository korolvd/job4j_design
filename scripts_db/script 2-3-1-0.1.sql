create table languages(
	id serial primary key, 
	name varchar(255)
);

create table capital(
	id serial primary key,
	name varchar(255)
);

create table country(
	id serial primary key,
	name varchar(255),
	capital_id int references capital(id) unique
);

create table city(
	id serial primary key,
	name varchar(255)
	country_id int references country(id)
);

create table language_countries(
	id serial primary key,
	country_id int references country(id),
	language_id int references languages(id)
);