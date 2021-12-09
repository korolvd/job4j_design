create table devices(
	id serial primary key,
	name varchar(255),
	price float
);

create table people(
	id serial primary key,
	name varchar(255)
);

create table device_people(
	id serial primary key,
	device_id int references devices(id),
	people_id int references people(id)
);

insert into devices (name, price) values ('smartphone', 4999.99);
insert into devices (name, price) values ('notepad', 2999.99);
insert into devices (name, price) values ('notebook', 8999.99);
insert into devices (name, price) values ('smartwatch', 1999.99);

insert into people (name) values ('Diann');
insert into people (name) values ('Jeremias');
insert into people (name) values ('Pryce');
insert into people (name) values ('Bertina');
insert into people (name) values ('Maje');
insert into people (name) values ('Melba');

insert into device_people (device_id, people_id) values (3, 3);
insert into device_people (device_id, people_id) values (2, 5);
insert into device_people (device_id, people_id) values (3, 4);
insert into device_people (device_id, people_id) values (3, 5);
insert into device_people (device_id, people_id) values (2, 2);
insert into device_people (device_id, people_id) values (4, 6);
insert into device_people (device_id, people_id) values (1, 1);
insert into device_people (device_id, people_id) values (2, 5);
insert into device_people (device_id, people_id) values (1, 1);
insert into device_people (device_id, people_id) values (2, 2);

select avg(price) as Средняя_цена_устройств from devices;

select p.name, avg(d.price) from device_people as dp
join people as p on dp.people_id = p.id
join devices as d on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price) from device_people as dp
join people as p on dp.people_id = p.id
join devices as d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;