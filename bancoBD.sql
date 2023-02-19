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

create table transferencias(
	id_transferencia int not null primary key auto_increment,
    monto_a_transferir float(10,2) not null default 0,
    cuenta_transfer int not null,
    cuenta_recibo int not null,
    foreign key (cuenta_transfer) references cuentas(no_cuenta),
    foreign key (cuenta_recibo) references cuentas(no_cuenta)
);

create table retiros(
	id_retiro int not null primary key auto_increment,
    monto_retirado float(10,2) not null default 0,
    folio int not null,
    contraseña int not null,
    cuenta_retiro int not null,
    foreign key (cuenta_retiro) references cuentas(no_cuenta)
);