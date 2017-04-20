create table Department (
	departmentId identity,
	departmentName varchar(255) unique not null
);
INSERT INTO Department (departmentName) VALUES ('Production');
INSERT INTO Department (departmentName) VALUES ('Research and Development');
INSERT INTO Department (departmentName) VALUES ('Marketing');
INSERT INTO Department (departmentName) VALUES ('Human Resource Management');
INSERT INTO Department (departmentName) VALUES ('Accounting and Finance');
create table Employee(
	id identity,
	name varchar(255) unique not null ,
	jobTitle varchar(255) not null,
	department int not null,
	email varchar(255) unique not null,
	dataofBirth date not null,
	salary long not null,
	FOREIGN KEY (department) REFERENCES  Department(departmentId )
);