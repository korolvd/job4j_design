create table body(
	id serial primary key,
	name varchar(255)
);

create table engine(
	id serial primary key,
	name varchar(255)
);

create table gearbox(
	id serial primary key,
	name varchar(255)
);

create table car(
	id serial primary key,
	name varchar(255) not null,
	body_id int references body(id) not null,
	engine_id int references engine(id) not null,
	gearbox_id int references gearbox(id) not null
);

insert into body(name) values ('Sedan');
insert into body(name) values ('Hatchback');
insert into body(name) values ('SUV');
insert into body(name) values ('Wagon');
insert into body(name) values ('Coupe');
insert into body(name) values ('Sedan');
insert into body(name) values ('Hatchback');
insert into body(name) values ('SUV');
insert into body(name) values ('Wagon');
insert into body(name) values ('Coupe');
insert into body(name) values ('Sedan');
insert into body(name) values ('Hatchback');
insert into body(name) values ('SUV');
insert into body(name) values ('Wagon');
insert into body(name) values ('Coupe');

insert into engine(name) values ('ICE');
insert into engine(name) values ('Electro');
insert into engine(name) values ('Hybrid');
insert into engine(name) values ('ICE');
insert into engine(name) values ('Electro');
insert into engine(name) values ('Hybrid');
insert into engine(name) values ('ICE');
insert into engine(name) values ('Electro');
insert into engine(name) values ('Hybrid');
insert into engine(name) values ('ICE');
insert into engine(name) values ('Electro');
insert into engine(name) values ('Hybrid');

insert into gearbox(name) values ('MT');
insert into gearbox(name) values ('AT');
insert into gearbox(name) values ('MT');
insert into gearbox(name) values ('AT');
insert into gearbox(name) values ('MT');
insert into gearbox(name) values ('AT');
insert into gearbox(name) values ('MT');
insert into gearbox(name) values ('AT');
insert into gearbox(name) values ('MT');
insert into gearbox(name) values ('AT');
insert into gearbox(name) values ('MT');
insert into gearbox(name) values ('AT');
insert into gearbox(name) values ('MT');
insert into gearbox(name) values ('AT');
insert into gearbox(name) values ('MT');
insert into gearbox(name) values ('AT');

insert into car(name, body_id, engine_id, gearbox_id) values ('model1', 1, 1, 2);
insert into car(name, body_id, engine_id, gearbox_id) values ('model2', 2, 2, 1);
insert into car(name, body_id, engine_id, gearbox_id) values ('model3', 3, 3, 3);
insert into car(name, body_id, engine_id, gearbox_id) values ('model4', 4, 4, 5);
insert into car(name, body_id, engine_id, gearbox_id) values ('model1', 5, 5, 4);
insert into car(name, body_id, engine_id, gearbox_id) values ('model2', 6, 7, 9);
insert into car(name, body_id, engine_id, gearbox_id) values ('model3', 7, 6, 8);
insert into car(name, body_id, engine_id, gearbox_id) values ('model4', 8, 9, 7);
insert into car(name, body_id, engine_id, gearbox_id) values ('model1', 9, 8, 6);
insert into car(name, body_id, engine_id, gearbox_id) values ('model2', 10, 10, 11);
insert into car(name, body_id, engine_id, gearbox_id) values ('model3', 11, 12, 10);

select c.name as Model, b.name as Type, e.name as Engine, g.name as Gear from car c
join body b on c.body_id = b.id join engine e on c.engine_id = e.id join gearbox g on c.gearbox_id = g.id;

select b.id, b.name from body b left join car c on c.body_id = b.id where c.id is null;
select e.id, e.name from engine e left join car c on c.engine_id = e.id where c.id is null;
select g.id, g.name from gearbox g left join car c on c.gearbox_id = g.id where c.id is null;