create database productdb owner root; 


CREATE TABLE products(
   oid BIGINT PRIMARY KEY     NOT NULL,
   name VARCHAR(30),
   price Integer,
   quantity Integer
);

CREATE TABLE products(
   oid SERIAL  PRIMARY KEY     NOT NULL,
   name VARCHAR(30),
   price Integer,
   quantity Integer
);
CREATE TABLE employees(
   oid BIGINT PRIMARY KEY     NOT NULL,
   ename VARCHAR(20),
   phno Integer
);

INSERT INTO products VALUES(1,'tv',3000,'10');
INSERT INTO products VALUES(2,'tv',3000,'10');

INSERT INTO products(name,price,quantity) VALUES('tv',3000,'10');
INSERT INTO products(name,price,quantity) VALUES('laptop',5000,'14');