create database IF NOT EXISTS pizza;
use pizza;

create table IF NOT EXISTS Product(
	id int NOT NULL primary key,
    ProductName varchar(255),
    Description varchar(255),
    BasePrice double,
    ImgURL varchar(255),
    CateId int,
    foreign key (CateId) references Category(id)
    
);

create table IF NOT EXISTS SizePrice(
	id int NOT NULL primary key,
    SizePriceName varchar(255),
    ExtraPrice double
);

create table IF NOT EXISTS Topping(
	id int NOT NULL primary key,
    ToppingName varchar(255),
    Price double ,
    ImgURL varchar(255)
);

create table IF NOT EXISTS Category(
	id int NOT NULL primary key,
    CateName varchar(255)
);

create table IF NOT EXISTS Customer(
	id int NOT NULL primary key,
    UserName varchar(255),
    PassWord varchar(255),
    PhoneNumber varchar(255),
    Address varchar(255),
    user_role int
);


