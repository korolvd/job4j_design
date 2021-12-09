create table type(
	id serial primary key,
	name varchar(255)
);

create table product(
	id serial primary key,
	name varchar(255),
	type_id int references type(id),
	expired_date date,
	price float
);

insert into type(name) values ('СЫР');
insert into type(name) values ('МОЛОКО');
insert into type(name) values ('МОРОЖЕНОЕ');
insert into type(name) values ('ТВОРОГ');
insert into type(name) values ('ЙОГУРТ');
insert into type(name) values ('КЕФИР');

insert into product(name, type_id, expired_date, price) values ('Сыр моцарелла', 1, '15.12.2021', 465.9);
insert into product(name, type_id, expired_date, price) values ('Сыр моцарелла', 1, '15.01.2022', 465.9);
insert into product(name, type_id, expired_date, price) values ('Сыр моцарелла', 1, '15.01.2022', 465.9);
insert into product(name, type_id, expired_date, price) values ('Сыр моцарелла', 1, '15.01.2022', 465.9);
insert into product(name, type_id, expired_date, price) values ('Сыр моцарелла', 1, '15.11.2021', 465.9);
insert into product(name, type_id, expired_date, price) values ('Сыр плавленный', 1, '11.12.2021', 75.9);
insert into product(name, type_id, expired_date, price) values ('Сыр плавленный', 1, '11.12.2021', 75.9);
insert into product(name, type_id, expired_date, price) values ('Сыр плавленный', 1, '11.11.2021', 75.9);
insert into product(name, type_id, expired_date, price) values ('Сыр российский', 1, '19.02.2022', 121.9);
insert into product(name, type_id, expired_date, price) values ('Молоко домашнее 3.2%', 2, '17.12.2021', 46.9);
insert into product(name, type_id, expired_date, price) values ('Молоко домашнее 3.2%', 2, '17.12.2021', 46.9);
insert into product(name, type_id, expired_date, price) values ('Молоко домашнее 3.2%', 2, '08.12.2021', 46.9);
insert into product(name, type_id, expired_date, price) values ('Молоко домашнее 3.2%', 2, '08.12.2021', 46.9);
insert into product(name, type_id, expired_date, price) values ('Молоко домашнее 3.2%', 2, '11.12.2021', 46.9);
insert into product(name, type_id, expired_date, price) values ('Молоко домашнее 3.2%', 2, '11.12.2021', 46.9);
insert into product(name, type_id, expired_date, price) values ('Молоко домашнее 2%', 2, '07.12.2021', 43.9);
insert into product(name, type_id, expired_date, price) values ('Молоко домашнее 2%', 2, '07.12.2021', 43.9);
insert into product(name, type_id, expired_date, price) values ('Молоко домашнее 2%', 2, '15.12.2021', 43.9);
insert into product(name, type_id, expired_date, price) values ('Молоко домашнее 2%', 2, '15.12.2021', 43.9);
insert into product(name, type_id, expired_date, price) values ('Молоко домашнее 2%', 2, '15.12.2021', 43.9);
insert into product(name, type_id, expired_date, price) values ('Молоко домашнее 2%', 2, '22.12.2021', 43.9);
insert into product(name, type_id, expired_date, price) values ('Молоко домашнее 2%', 2, '22.12.2021', 43.9);
insert into product(name, type_id, expired_date, price) values ('Молоко домашнее 2%', 2, '22.12.2021', 43.9);
insert into product(name, type_id, expired_date, price) values ('Молоко концентрированное', 2, '15.12.2021', 45.9);
insert into product(name, type_id, expired_date, price) values ('Мороженое сливочное', 3, '15.03.2022', 31.9);
insert into product(name, type_id, expired_date, price) values ('Мороженое сливочное', 3, '15.03.2022', 31.9);
insert into product(name, type_id, expired_date, price) values ('Мороженое сливочное', 3, '15.03.2022', 31.9);
insert into product(name, type_id, expired_date, price) values ('Мороженое шоколадное', 3, '02.10.2021', 35.9);
insert into product(name, type_id, expired_date, price) values ('Мороженое шоколадное', 3, '02.10.2021', 35.9);
insert into product(name, type_id, expired_date, price) values ('Мороженое шоколадное', 3, '02.10.2021', 35.9);
insert into product(name, type_id, expired_date, price) values ('Мороженое шоколадное', 3, '02.10.2021', 35.9);
insert into product(name, type_id, expired_date, price) values ('Творог деревенский', 4, '13.12.2021', 37.9);
insert into product(name, type_id, expired_date, price) values ('Творог деревенский', 4, '13.12.2021', 37.9);
insert into product(name, type_id, expired_date, price) values ('Творог деревенский', 4, '08.12.2021', 37.9);
insert into product(name, type_id, expired_date, price) values ('Йогурт классический', 5, '10.12.2021', 61.9);
insert into product(name, type_id, expired_date, price) values ('Йогурт классический', 5, '10.12.2021', 61.9);
insert into product(name, type_id, expired_date, price) values ('Йогурт классический', 5, '10.12.2021', 61.9);
insert into product(name, type_id, expired_date, price) values ('Йогурт классический', 5, '10.12.2021', 61.9);
insert into product(name, type_id, expired_date, price) values ('Йогурт классический', 5, '08.12.2021', 61.9);
insert into product(name, type_id, expired_date, price) values ('Йогурт Любимый', 5, '11.12.2021', 69.9);
insert into product(name, type_id, expired_date, price) values ('Йогурт Любимый', 5, '11.12.2021', 69.9);
insert into product(name, type_id, expired_date, price) values ('Йогурт Любимый', 5, '11.12.2021', 69.9);
insert into product(name, type_id, expired_date, price) values ('Йогурт Любимый', 5, '11.12.2021', 69.9);
insert into product(name, type_id, expired_date, price) values ('Кефир Простоквашено', 6, '17.12.2021', 59.9);
insert into product(name, type_id, expired_date, price) values ('Кефир Простоквашено', 6, '17.12.2021', 59.9);
insert into product(name, type_id, expired_date, price) values ('Кефир Простоквашено', 6, '15.12.2021', 59.9);
insert into product(name, type_id, expired_date, price) values ('Кефир Простоквашено', 6, '15.12.2021', 59.9);
insert into product(name, type_id, expired_date, price) values ('Кефир Простоквашено', 6, '13.12.2021', 59.9);
insert into product(name, type_id, expired_date, price) values ('Кефир Простоквашено', 6, '13.12.2021', 59.9);
insert into product(name, type_id, expired_date, price) values ('Кефир Простоквашено', 6, '10.12.2021', 59.9);
insert into product(name, type_id, expired_date, price) values ('Кефир Простоквашено', 6, '10.12.2021', 59.9);
insert into product(name, type_id, expired_date, price) values ('Кефир Простоквашено', 6, '08.12.2021', 59.9);
insert into product(name, type_id, expired_date, price) values ('Кефир Простоквашено', 6, '08.12.2021', 59.9);
insert into product(name, type_id, expired_date, price) values ('Кефир Простоквашено', 6, '06.12.2021', 59.9);

--1
select * from product as p
join type as t on p.type_id = t.id
where t.name = 'СЫР';

--2
select * from product where name like '%Мороженое%';

--3
select * from product where expired_date < current_date;

--4
select name, max(price) from product
where price = (select max(price) from product)
group by name, price;

--5
select t.name, count(p.type_id) from product as p
join type as t on p.type_id = t.id
group by t.name;

--6
select * from product as p
join type as t on p.type_id = t.id
where t.name = 'СЫР' or t.name = 'МОЛОКО';

--7
select t.name, count(p.type_id) from product as p
join type as t on p.type_id = t.id
group by t.name
having count(p.type_id) < 10;

--8
select p.name, t.name from product as p
join type as t on p.type_id = t.id;
