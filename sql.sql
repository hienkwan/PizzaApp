create database pizza;
use pizza;

create table Product(
	id int NOT NULL primary key,
    ProductName varchar(255),
    Description varchar(255),
    BasePrice double,
    ImgURL varchar(255),
    CateId int,
    foreign key (CateId) references Category(id)
    
);

create table SizePrice(
	id int NOT NULL primary key,
    SizePriceName varchar(255),
    ExtraPrice double
);

create table Topping(
	id int NOT NULL primary key,
    ToppingName varchar(255),
    Price double ,
    ImgURL varchar(255)
);

create table Category(
	id int NOT NULL primary key,
    CateName varchar(255)
);

create table Customer(
	id int NOT NULL primary key,
    UserName varchar(255),
    PassWord varchar(255),
    PhoneNumber varchar(255),
    Address varchar(255)
);
