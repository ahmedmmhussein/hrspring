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
	departmentId int not null,
	email varchar(255) unique not null,
	dataofBirth date not null,
	salary long not null,
	FOREIGN KEY (departmentId) REFERENCES  Department(departmentId )
);


create table products(
	productId identity,
	productName varchar(255) not null ,
	productCode varchar(255) not null,
	releaseDate date not null,
	description varchar(255) not null,
	price long not null,
	starRating long not null,
	imageUrl varchar(255) not null);


INSERT INTO products (productName ,productCode ,releaseDate ,description ,price ,starRating ,imageUrl ) VALUES ('Leaf Rake','GDN-0011','2016-03-19','Leaf rake with 48-inch wooden handle.',19.95,3.2,'http://openclipart.org/image/300px/svg_to_png/26215/Anonymous_Leaf_Rake.png');


INSERT INTO products (productName ,productCode ,releaseDate ,description ,price ,starRating ,imageUrl ) VALUES ('Garden Cart','GDN-0023','2016-03-18','15 gallon capacity rolling garden cart',32.99,4.2,'http://openclipart.org/image/300px/svg_to_png/58471/garden_cart.png');


