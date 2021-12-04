--create database IF NOT EXISTS pizza;
--use pizza;

create table IF NOT EXISTS product(
	id int NOT NULL primary key,
    ProductName varchar(255),
    Description varchar(255),
    BasePrice double,
    ImgURL varchar(255),
    CateId int,
    foreign key (CateId) references Category(id)
    
);

create table IF NOT EXISTS sizePrice(
	id int NOT NULL primary key,
    SizePriceName varchar(255),
    ExtraPrice double
);

create table IF NOT EXISTS topping(
	id int NOT NULL primary key,
    ToppingName varchar(255),
    Price double ,
    ImgURL varchar(255)
);

create table IF NOT EXISTS category(
	id int NOT NULL primary key,
    CateName varchar(255)
);

create table IF NOT EXISTS customer(
	id int NOT NULL primary key,
    UserName varchar(255),
    PassWord varchar(255),
    PhoneNumber varchar(255),
    Address varchar(255),
    user_role int
);

INSERT INTO category VALUES
(1,'pizza'),
(2,'burger'),
(3,'drink')

INSERT INTO product VALUES
(3,'pizza 01','This is pizza 01',20,'abc.jpg',1)

INSERT INTO customer(id,UserName,PassWord,PhoneNumber,Address,user_role)
VALUES
(1, 'adam', '1234', '01233456789','',1),
(2, 'eva', '1234', '01233456789','',0);


