create database banco;

use banco;

create table domicilios(
	id int not null primary key auto_increment,
    calle varchar(30) not null,
    numero int not null,
    colonia varchar(30) not null
);

create table clientes(
	id int not null primary key auto_increment,
    nombres varchar(60) not null,
	apellido_paterno varchar(30) not null,
    apellido_materno varchar(30) not null,
	fecha_nacimiento date not null,
    id_domicilio int not null,
    foreign key (id_domicilio) references domicilios(id)
);


create table cuentas(
	no_cuenta int not null primary key auto_increment,
    fecha_apertura date not null,
    saldo float(10, 2) not null,
    id_clientes int not null,
    foreign key (id_clientes) references clientes(id)
);