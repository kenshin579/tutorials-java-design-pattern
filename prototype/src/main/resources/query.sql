drop table address;
create table address
(
	ssn char(6) primary key,
	name char(10) not null,
	tel char(12) not null,
	address char(10) not null,
	gender int not null
);

insert into address values ("701212","kimch", "12345645","seoul",1);
insert into address values ("741218","parkch","55442165","texas",1);
insert into address values ("780506","parksl","68435483","daejun",2);
insert into address values ("851213","parkmh","35486455","kwangju",2);
insert into address values ("660904","songnr","65832154","inchon",2);
insert into address values ("690603","kimbk", "55478554","pusan",1);
insert into address values ("001018","kimsw", "97313245","daegoo",1);
insert into address values ("950630","seojw", "31578556","woolsan",1);
insert into address values ("650402","choihs","60467591","pyungyang",1);
insert into address values ("451125","leesw", "66693408","masan",1);
insert into address values ("500625","jojh",  "26854565","youngin",1);
insert into address values ("530714","icho",  "34875354","puchon",1);


