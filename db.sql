spring.datasource.url=jdbc:mysql://localhost/productdb
spring.datasource.url=jdbc:postgresql://localhost/productdb
create database productdb owner root; 


CREATE TABLE products(
   oid BIGINT PRIMARY KEY     NOT NULL AUTO_INCREMENT,
   name VARCHAR(30),
   price Integer,
   quantity Integer,
   categories_oid BIGINT,
   FOREIGN KEY (categories_oid) REFERENCES categories(oid)

);

CREATE TABLE products(
   oid SERIAL  PRIMARY KEY     NOT NULL,
   name VARCHAR(30),
   price Integer,
   quantity Integer
);
CREATE TABLE categories(
   oid BIGINT  PRIMARY KEY     NOT NULL AUTO_INCREMENT,
   name VARCHAR(30)
);
INSERT INTO categories(name) VALUES ("food");
INSERT INTO categories(name) VALUES ("electronic");
INSERT INTO categories(name) VALUES ("cloth");

INSERT INTO products VALUES(1,'tv',3000,'10');
INSERT INTO products VALUES(2,'laptop',3000,'10');

INSERT INTO products(name,price,quantity) VALUES('tv',3000,'10');
INSERT INTO products(name,price,quantity) VALUES('laptop',5000,'14');

drop table products;
drop table categories;