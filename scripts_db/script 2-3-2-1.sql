create table country(
	id serial primary key,
	name varchar(255)
);

create table city(
	id serial primary key,
	name varchar(255),
	country_id int references country(id)
);

insert into country (name) values ('Russia');
insert into country (name) values ('United States');
insert into country (name) values ('France');
insert into country (name) values ('China');

insert into city (name) values ('Buy');
insert into city (name, country_id) values ('Quận Tân Phú', 4);
insert into city (name) values ('Dambořice');
insert into city (name, country_id) values ('Gândara', 3);
insert into city (name, country_id) values ('Karangora', 4);
insert into city (name, country_id) values ('San Andres', 1);
insert into city (name) values ('Gaopeng');
insert into city (name, country_id) values ('Douz', 1);
insert into city (name) values ('Palaiseau');
insert into city (name, country_id) values ('Moses', 3);

select * from city join country as c on city.country_id = c.id;
select ct.name, cnt.name from city as ct join country as cnt on ct.country_id = cnt.id;
select ct.name as City, cnt.name as Country from city as ct join country as cnt on ct.country_id = cnt.id;