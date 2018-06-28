spring.datasource.url=jdbc:mysql://localhost/productdb
spring.datasource.url=jdbc:postgresql://localhost/productdb
create database productdb owner root; 


CREATE TABLE products(
   oid BIGINT PRIMARY KEY     NOT NULL AUTO_INCREMENT,
   name VARCHAR(30),
   price Integer,
   quantity Integer,
   oid_category BIGINT,
   FOREIGN KEY (oid_category) REFERENCES category(oid)

);

CREATE TABLE products(
   oid SERIAL  PRIMARY KEY     NOT NULL,
   name VARCHAR(30),
   price Integer,
   quantity Integer
);
CREATE TABLE category(
   oid BIGINT  PRIMARY KEY     NOT NULL,
   name VARCHAR(30)
);
 

INSERT INTO products VALUES(1,'tv',3000,'10');
INSERT INTO products VALUES(2,'laptop',3000,'10');

INSERT INTO products(name,price,quantity) VALUES('tv',3000,'10');
INSERT INTO products(name,price,quantity) VALUES('laptop',5000,'14');