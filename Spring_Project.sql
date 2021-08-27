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
insert into PRODUCTS (product_name,product_type,image,price,quantity,sale,descriptions)
 values( 'Gấu bông HEO CUTE mền mịn siêu ngộ nghĩnh','1','https://i.ibb.co/1fkYDj4/heoVang.jpg',20000,0,10,'Sản phẩm được làm từ chất liệu vải mềm mịn, không xù lông đặc biệt không bay màu');
  insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('Gối Gấu Bông Trái Cây Thú Bông Ngộ Nghĩnh Bơ Gấu','2','https://i.ibb.co/17ws9hB/bo.jpg',33,100,10000,'Gấu bông độc đáo với thiết kế đơn giản dễ thương cùng chất lông nhung mềm mịn.');
 insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('Gấu Bông Heo Hình Thú Cao Cấp Cute Dễ Thương','1','https://i.ibb.co/Twcp5WC/bongthu.jpg',150000,0,140000 ,'Gấu bông được làm từ vải cotton co dãn 4 chiều, không đổ lông khi giặt nhiều lần');
  insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('Gấu bông heo hồng bụng bự biến thái','1','https://i.ibb.co/12cT5MH/heohong.jpg',31,0,299000,'Anh người yêu không thể bên cạnh 24/24 được nhưng bé Hêu thì có thể nha');
 insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('Gấu Bông Trái Cây Thú Bông Ngộ Nghĩnh Thơm','2','https://i.ibb.co/C6q8Q6C/thom.jpg',33,100,275000,'Gấu bông siêu mềm mịn, không xù an toàn cho cả người lớn và trẻ em');
 insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('Gối Gấu Bông Trái Cây Thú Bông Ngộ Nghĩnh Cà rốt','2','https://i.ibb.co/qNh5RbJ/carot.jpg',28,0,260000,'Gấu bông có đường may chắc chắn, độ bền cao, an toàn cho người sử dụng.');
  insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('Gấu bông gối ôm bò sữa siêu đẹp siêu cute','1','https://i.ibb.co/q5Txqym/traubong.jpg',10,0,360000,'Gấu bông gối ôm bò sữa siêu đẹp siêu cute, Gấu bông sang trọng');
insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('Gấu bông hình chú bò sữa nhà Lalashop ','1','https://i.ibb.co/f083WFh/bosua.jpg',20,0,330000,'Gấu bông siêu mềm mịn, không xù, không rụng lông an toàn cho cả người lớn và trẻ em');
 insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('Gấu bông hình chú bò cười đáng yêu','1','https://i.ibb.co/QbNhJbB/bocuoi.jpg',10,0,150000,'Gấu bông contton siêu mềm mịn, không đổ lông an toàn cho trẻ em');
 insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('Gấu bông heo hồng đáng yêu siêu cute','1','https://i.ibb.co/2vg5jpn/heobong.jpg',10,0,200000,'Gấu bông gối hep hồng siêu đẹp siêu cute, Gấu bông sang trọng');
insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('Gấu bông hình chú heo lưởi siêu dễ thương ','1','https://i.ibb.co/NVQtKKJ/heoluoi.jpg',13,0,130000,'Gấu bông siêu mềm mịn, không xù, không rụng lông an toàn cho cả người lớn và trẻ em');
 insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('Gấu bông hình chú bò sữa đáng yêu','1','https://i.ibb.co/FsdTJws/bosua.jpg',0,0,300000,'Gấu bông contton siêu mềm mịn, không bay màu, không đổ lông ');
 insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('Gối Gấu Bông Trái Cây Thú Bông Ngộ Nghĩnh Chuối','2','https://i.ibb.co/4fKSzf6/chuoi.jpg',0,100,120000,'Gấu được làm vỏ nhung bông tuyết mềm mại, tuyệt đối không sổ lông.');
insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('Gấu Bông Trái Cây Thú Bông Ngộ Nghĩnh Sầu riêng','2','https://i.ibb.co/zZpx5TY/saurieng.jpg',0,100,275000,'Gấu bông siêu mềm mịn, không xù an toàn cho cả người lớn và trẻ em');
 insert into PRODUCTS (product_name,product_type,image,sale,quantity,price,descriptions)
 values('Gối Gấu Bông Trái Cây Thú Bông Ngộ Nghĩnh Kiwwi','2','https://i.ibb.co/D59hZTC/kiwi.jpg',0,0,260000,'Gấu bông có đường may chắc chắn, độ bền cao, an toàn cho người sử dụng.');
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
    status varchar (10),
    roles integer
    );
insert into USERS (id_user,user_name,full_name,password,email,phone, address, status, roles) values
 (1, 'admin','admin','$2a$10$sopEWnd9jx6nKZNowe5TpukYE62CGhKBnIkU20AneNesoFbAQpIpu','tuan.pham22@student.passerellesnumeriques.org',0799101759,'DANANG','active', 0);
insert into USERS (user_name,full_name,password,email,phone, address, status, roles) values
 ('Kha','Nguyen Dinh kha','$2a$10$sopEWnd9jx6nKZNowe5TpukYE62CGhKBnIkU20AneNesoFbAQpIpu','kha.nguyen22@student.passerellesnumeriques.org',0915810375,'DANANG','active', 1);
insert into USERS (user_name,full_name,password,email,phone, address, status, roles) values
 ('Hoa','Nguyen Thi Hoa','$2a$10$sopEWnd9jx6nKZNowe5TpukYE62CGhKBnIkU20AneNesoFbAQpIpu','hoa.nguyen22@student.passerellesnumeriques.org',0915810375,  'DANANG','active', 1);
insert into USERS (user_name,full_name,password,email,phone, address, status, roles) values
 ('Dieu','Ho Thi Dieu','$2a$10$sopEWnd9jx6nKZNowe5TpukYE62CGhKBnIkU20AneNesoFbAQpIpu','dieu.ho22@student.passerellesnumeriques.org',0915810375,  'DANANG','active', 1);
insert into USERS (user_name,full_name,password,email,phone, address, status, roles) values
 ('Bang','Gia Cao Bang','$2a$10$sopEWnd9jx6nKZNowe5TpukYE62CGhKBnIkU20AneNesoFbAQpIpu','bang.gia22@student.passerellesnumeriques.org',0915810375, 'DANANG','active', 1);
 
---------------------------------------------------------
create table PAYMENTS (
    id_paid INT primary key auto_increment UNIQUE,
    id_user int,
    id_product int,
    quantity int ,
    total double,
    payment_method varchar(10),
    status varchar(20),
    foreign key (id_user) references USERS (id_user),
    foreign key(id_product) references PRODUCTS (id_product)
);
insert into PAYMENTS (id_paid,id_user,id_product,quantity, total, payment_method, status) values
 (1,2,2,3,100000,'VNPAY','pending');
 insert into PAYMENTS (id_user,id_product,quantity, total, payment_method, status) values
 (2,2,3,100000,'VNPAY','pending');
  insert into PAYMENTS (id_user,id_product,quantity, total, payment_method, status) values
 (2,2,3,100000,'VNPAY','pending');
  insert into PAYMENTS (id_user,id_product,quantity, total, payment_method, status) values
 (2,2,3,100000,'VNPAY','pending');
  insert into PAYMENTS (id_user,id_product,quantity, total, payment_method, status) values
 (2,2,3,100000,'VNPAY','pending');
  insert into PAYMENTS (id_user,id_product,quantity, total, payment_method, status) values
 (2,2,3,100000,'VNPAY','pending');
  insert into PAYMENTS (id_user,id_product,quantity, total, payment_method, status) values
 (2,2,3,100000,'VNPAY','pending');
  insert into PAYMENTS (id_user,id_product,quantity, total, payment_method, status) values
 (2,2,3,100000,'VNPAY','pending');
create table NOTIFICATIONS (
    id INT primary key auto_increment,
    status varchar(15),
    content varchar(100)
);
insert into NOTIFICATIONS (id,status,content) values
 (1,'success','Demo notifications');
 insert into NOTIFICATIONS (status,content) values
 ('error','Demo notifications');
  insert into NOTIFICATIONS (status,content) values
 ('error','Demo notifications');
  insert into NOTIFICATIONS (status,content) values
 ('success','Demo notifications');
 select * from USERS;
