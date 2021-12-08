create table if not exists city(
	id serial primary key,
	name varchar(255),
	founded numeric,
	population int
);
insert into city(name, founded, population) values('Moscow', 1147, 12655050);
update city set name = 'St.Peterburg', founded = 1703, population = 5384342;
delete from city;