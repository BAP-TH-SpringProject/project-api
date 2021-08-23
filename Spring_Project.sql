drop database if exists Spring_Project;
create database if not exists Spring_Project;
USE Spring_Project;

---------------------------------------------------------
create table PRODUCTS (
    id_product int primary key auto_increment UNIQUE,
    product_name varchar (50),
    product_type varchar(50),
    image varchar (200),
    sale double,
    quantity int,
    price decimal(10,2),
    descriptions varchar(250)
    );

insert into PRODUCTS (id_product,product_name,product_type,image,sale,quantity,price,descriptions)
 values(1, 'STRIPED BUFFALO SHIRT','Trâu Bông','https://bitsofco.de/content/images/2018/12/broken-1.png',10,100,200000,'Chất liệu an toàn không gấy kích ứng da');
 insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('STRIPED BUFFALO SHIRT','Trâu Bông','https://bitsofco.de/content/images/2018/12/broken-1.png',10,100,200000,'Chất liệu an toàn không gấy kích ứng da');
  insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('STRIPED BUFFALO SHIRT','Trâu Bông','https://bitsofco.de/content/images/2018/12/broken-1.png',10,100,200000,'Chất liệu an toàn không gấy kích ứng da');
  insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('STRIPED BUFFALO SHIRT','Trâu Bông','https://bitsofco.de/content/images/2018/12/broken-1.png',10,100,200000,'Chất liệu an toàn không gấy kích ứng da');
  insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('STRIPED BUFFALO SHIRT','Trâu Bông','https://bitsofco.de/content/images/2018/12/broken-1.png',10,100,200000,'Chất liệu an toàn không gấy kích ứng da');
  insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('STRIPED BUFFALO SHIRT','Trâu Bông','https://bitsofco.de/content/images/2018/12/broken-1.png',10,100,200000,'Chất liệu an toàn không gấy kích ứng da');
  insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('STRIPED BUFFALO SHIRT','Trâu Bông','https://bitsofco.de/content/images/2018/12/broken-1.png',10,100,200000,'Chất liệu an toàn không gấy kích ứng da');
  insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('STRIPED BUFFALO SHIRT','Trâu Bông','https://bitsofco.de/content/images/2018/12/broken-1.png',10,100,200000,'Chất liệu an toàn không gấy kích ứng da');
  insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('STRIPED BUFFALO SHIRT','Trâu Bông','https://bitsofco.de/content/images/2018/12/broken-1.png',10,100,200000,'Chất liệu an toàn không gấy kích ứng da');
  insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('STRIPED BUFFALO SHIRT','Trâu Bông','https://bitsofco.de/content/images/2018/12/broken-1.png',10,100,200000,'Chất liệu an toàn không gấy kích ứng da');
---------------------------------------------------------
create table USERS (
    id_user int primary key auto_increment UNIQUE,
    user_name varchar(20) NOT NULL UNIQUE,
    full_name varchar (40) NOT NULL,
    password varchar(500) NOT NULL,
    email varchar (200) NOT NULL UNIQUE,
    phone varchar (50) NOT NULL, 
    address varchar (50),
    roles integer,
    balance double
    );
insert into USERS (id_user,user_name,full_name,password,email,phone, address, balance, roles) values
 (1, 'admin','admin','$2a$10$sopEWnd9jx6nKZNowe5TpukYE62CGhKBnIkU20AneNesoFbAQpIpu','tuan.pham22@student.passerellesnumeriques.org',0799101759,'DANANG',200000, 0);
insert into USERS (user_name,full_name,password,email,phone, address, balance, roles) values
 ('Kha','Nguyen Dinh kha','$2a$10$sopEWnd9jx6nKZNowe5TpukYE62CGhKBnIkU20AneNesoFbAQpIpu','kha.nguyen22@student.passerellesnumeriques.org',0915810375,'DANANG',200000, 1);
insert into USERS (user_name,full_name,password,email,phone, address, balance, roles) values
 ('Hoa','Nguyen Thi Hoa','$2a$10$sopEWnd9jx6nKZNowe5TpukYE62CGhKBnIkU20AneNesoFbAQpIpu','hoa.nguyen22@student.passerellesnumeriques.org',0915810375,'DANANG',200000, 1);
insert into USERS (user_name,full_name,password,email,phone, address, balance, roles) values
 ('Dieu','Ho Thi Dieu','$2a$10$sopEWnd9jx6nKZNowe5TpukYE62CGhKBnIkU20AneNesoFbAQpIpu','dieu.ho22@student.passerellesnumeriques.org',0915810375,'DANANG',200000, 1);
insert into USERS (user_name,full_name,password,email,phone, address, balance, roles) values
 ('Bang','Gia Cao Bang','$2a$10$sopEWnd9jx6nKZNowe5TpukYE62CGhKBnIkU20AneNesoFbAQpIpu','bang.gia22@student.passerellesnumeriques.org',0915810375,'DANANG',200000, 1);
 
---------------------------------------------------------
create table PAYMENTS (
    id_paid INT primary key auto_increment UNIQUE,
    id_user int,
    id_product int,
    quantity int ,
    total double,
    payment_method varchar(5),
    status varchar(20),
    foreign key (id_user) references USERS (id_user),
    foreign key(id_product) references PRODUCTS (id_product)
);
create table NOTIFICATIONS (
    id INT primary key auto_increment,
    status varchar(15),
    content varchar(100)
);
 select * from USERS;
