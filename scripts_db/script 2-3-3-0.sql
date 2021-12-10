--1
create table departmens(
	id serial primary key,
	name varchar(255)
);

create table emploers(
	id serial primary key,
	name varchar(255),
	departmen_id int references departmens(id)
);

insert into departmens (name) values ('Services');
insert into departmens (name) values ('Training');
insert into departmens (name) values ('Marketing');
insert into departmens (name) values ('Services');
insert into departmens (name) values ('Support');

insert into emploers (name, departmen_id) values ('GIS Technical Architect', 1);
insert into emploers (name, departmen_id) values ('Nurse', 5);
insert into emploers (name, departmen_id) values ('Teacher', 1);
insert into emploers (name, departmen_id) values ('Civil Engineer', 4);
insert into emploers (name, departmen_id) values ('Technical Writer', null);
insert into emploers (name, departmen_id) values ('Structural Engineer', null);
insert into emploers (name, departmen_id) values ('Food Chemist', 2);
insert into emploers (name, departmen_id) values ('Computer Systems Analyst I', 5);
insert into emploers (name, departmen_id) values ('Media Manager II', null);
insert into emploers (name, departmen_id) values ('Accounting Assistant I', 2);

--2
select * from emploers e left join departmens d on e.departmen_id = d.id;
select * from emploers e right join departmens d on e.departmen_id = d.id;
select * from departmens cross join emploers;

--3
select * from departmens d left join emploers e on d.id = e.departmen_id 
where e.departmen_id is null;

--4
select e.name as Employee, d.name as Departmen from departmens d right join emploers e on d.id = e.departmen_id;
select e.name as Employee, d.name as Departmen from emploers e left join departmens d on d.id = e.departmen_id;

--5
create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens (name, gender) values ('Almérinda', 'Male');
insert into teens (name, gender) values ('Uò', 'Female');
insert into teens (name, gender) values ('Eléonore', 'Female');
insert into teens (name, gender) values ('Josée', 'Female');
insert into teens (name, gender) values ('André', 'Female');
insert into teens (name, gender) values ('Garçon', 'Male');
insert into teens (name, gender) values ('Cécile', 'Male');
insert into teens (name, gender) values ('Amélie', 'Female');
insert into teens (name, gender) values ('Björn', 'Male');
insert into teens (name, gender) values ('Félicie', 'Male');

select t.name as Teen1, t.gender as Gender1, tt.name as Teen2, tt.gender from teens t cross join teens tt 
where t.gender != tt.gender;