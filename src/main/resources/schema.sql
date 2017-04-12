create table Employee(
	id identity,
	name varchar(20) unique not null ,
	jobTitle varchar(20) not null,
	department varchar(30) not null,
	email varchar(30) unique not null,
	dataofBirth date not null,
	salary long not null
);

create table Department (
	id identity,
	name varchar(20) unique not null
);