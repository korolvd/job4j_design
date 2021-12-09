create table if not exists fauna(
	id serial primary key,
	name text,
	avg_age int,
	discovery_date date
);

insert into fauna (name, avg_age, discovery_date) values ('Red kangaroo', 7375, '1988-11-10 09:38:49');
insert into fauna (name, avg_age, discovery_date) values ('Vine snake (unidentified)', 14495, null);
insert into fauna (name, avg_age, discovery_date) values ('Jungle cat', 16366, '1967-03-04 11:32:48');
insert into fauna (name, avg_age, discovery_date) values ('Peccary, collared', 47037, '1928-03-18 21:07:21');
insert into fauna (name, avg_age, discovery_date) values ('Ibis, puna', 3353, '2008-10-14 10:21:16');
insert into fauna (name, avg_age, discovery_date) values ('Common rhea', 11565, null);
insert into fauna (name, avg_age, discovery_date) values ('Hoffman''s sloth', 6928, '1921-11-04 08:23:14');
insert into fauna (name, avg_age, discovery_date) values ('Lapwing, southern', 19837, '1964-05-10 15:00:40');
insert into fauna (name, avg_age, discovery_date) values ('Ringtail cat', 18504, '1931-03-03 05:00:14');
insert into fauna (name, avg_age, discovery_date) values ('Turaco, violet-crested', 6057, '2017-05-14 03:02:23');
insert into fauna (name, avg_age, discovery_date) values ('Snowy egret', 19964, '1904-12-28 09:08:16');
insert into fauna (name, avg_age, discovery_date) values ('Stork, greater adjutant', 47681, null);
insert into fauna (name, avg_age, discovery_date) values ('Eastern grey kangaroo', 27288, '1966-05-22 23:59:12');
insert into fauna (name, avg_age, discovery_date) values ('Booby, blue-footed', 31930, '1928-02-09 12:44:38');
insert into fauna (name, avg_age, discovery_date) values ('Pheasant, ring-necked', 38147, '1983-07-15 15:15:34');
insert into fauna (name, avg_age, discovery_date) values ('Sheep, stone', 17867, '1930-08-28 13:57:21');
insert into fauna (name, avg_age, discovery_date) values ('Sage hen', 7341, null);
insert into fauna (name, avg_age, discovery_date) values ('Indian mynah', 22739, null);
insert into fauna (name, avg_age, discovery_date) values ('Francolin, swainson''s', 32728, '1933-06-06 18:27:17');
insert into fauna (name, avg_age, discovery_date) values ('Potoroo', 13449, '1944-03-13 10:19:49');
insert into fauna (name, avg_age, discovery_date) values ('Woodpecker, red-headed', 44, '1922-12-10 15:14:24');
insert into fauna (name, avg_age, discovery_date) values ('Yellow-billed stork', 20005, null);
insert into fauna (name, avg_age, discovery_date) values ('Alligator, mississippi', 22047, null);
insert into fauna (name, avg_age, discovery_date) values ('Greater adjutant stork', 21748, '1935-03-27 14:45:31');
insert into fauna (name, avg_age, discovery_date) values ('Cat, civet', 15576, '2008-01-22 13:04:04');
insert into fauna (name, avg_age, discovery_date) values ('Plover, blacksmith', 46153, '1943-06-07 11:57:48');
insert into fauna (name, avg_age, discovery_date) values ('Tern, royal', 249, '2014-03-04 07:50:11');
insert into fauna (name, avg_age, discovery_date) values ('Eurasian hoopoe', 39639, '1948-02-27 02:05:44');
insert into fauna (name, avg_age, discovery_date) values ('Blue and yellow macaw', 2683, '1932-05-27 17:37:48');
insert into fauna (name, avg_age, discovery_date) values ('Laughing dove', 26541, '1937-04-22 03:45:18');
insert into fauna (name, avg_age, discovery_date) values ('Cockatoo, sulfur-crested', 25125, '2011-12-09 16:35:21');
insert into fauna (name, avg_age, discovery_date) values ('Australian magpie', 17225, '1953-05-26 05:27:48');
insert into fauna (name, avg_age, discovery_date) values ('Goat, mountain', 34107, '1928-06-25 14:01:38');
insert into fauna (name, avg_age, discovery_date) values ('Francolin, coqui', 45539, '1986-04-13 14:22:48');
insert into fauna (name, avg_age, discovery_date) values ('Dove, laughing', 22050, '1932-05-24 20:11:31');
insert into fauna (name, avg_age, discovery_date) values ('Eastern indigo snake', 43393, '1996-12-03 20:40:03');
insert into fauna (name, avg_age, discovery_date) values ('Crake, african black', 25308, null);
insert into fauna (name, avg_age, discovery_date) values ('Wallaroo, common', 25966, '1967-11-05 04:39:04');
insert into fauna (name, avg_age, discovery_date) values ('Blue-footed booby', 42070, '1961-05-21 21:15:40');
insert into fauna (name, avg_age, discovery_date) values ('Monkey, bleeding heart', 41299, '1960-10-15 16:06:58');
insert into fauna (name, avg_age, discovery_date) values ('Civet, small-toothed palm', 5534, '1947-02-07 01:12:28');
insert into fauna (name, avg_age, discovery_date) values ('Deer, mule', 11925, '1903-01-07 22:33:43');
insert into fauna (name, avg_age, discovery_date) values ('Deer, black-tailed', 43902, '1938-01-26 19:56:35');
insert into fauna (name, avg_age, discovery_date) values ('European shelduck', 17618, '1904-08-05 22:30:37');
insert into fauna (name, avg_age, discovery_date) values ('Cat, kaffir', 25581, '1910-09-23 03:31:21');
insert into fauna (name, avg_age, discovery_date) values ('African fish eagle', 38166, null);
insert into fauna (name, avg_age, discovery_date) values ('Stork, marabou', 47118, '1986-02-07 23:02:03');
insert into fauna (name, avg_age, discovery_date) values ('Deer, red', 26267, '1912-11-12 19:14:04');
insert into fauna (name, avg_age, discovery_date) values ('Iguana, marine', 12669, null);
insert into fauna (name, avg_age, discovery_date) values ('Sally lightfoot crab', 38887, '2004-10-15 11:58:39');

select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '01.01.1950';