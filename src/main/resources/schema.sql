SET foreign_key_checks = 0;
drop table if exists facturacion.producto;
drop table if exists facturacion.factura;
drop table if exists facturacion.detalle;
drop table if exists facturacion.cliente;
SET foreign_key_checks = 1;
-- -----------------------------------------------------
-- table facturacion.cliente
-- -----------------------------------------------------
create table if not exists facturacion.cliente (
  id_cliente int not null auto_increment,
  dni int not null,
  nombre varchar(255) not null,
  apellido varchar(255) null default null,
  email varchar(255) null,
  primary key (id_cliente));

-- -----------------------------------------------------
-- table facturacion.producto
-- -----------------------------------------------------
create table if not exists facturacion.producto (
  id_producto int not null auto_increment,
  descripcion varchar(255) not null,
  cantidad int null default null,
  precio float(5,2) null default null,
  primary key (id_producto));

-- -----------------------------------------------------
-- table facturacion.factura
-- -----------------------------------------------------
create table if not exists facturacion.factura (
  id_factura int not null auto_increment,
  fecha datetime null default null,
  cantidad int null default null,
  total float(5,2) null default null,
  id_cliente int null default null,
  primary key (id_factura),
  index fk_cliente (id_cliente asc) visible,
  constraint fk_cliente
    foreign key (id_cliente)
    references facturacion.cliente (id_cliente));

-- -----------------------------------------------------
-- table facturacion.detalle
-- -----------------------------------------------------
create table if not exists facturacion.detalle (
  id int not null auto_increment,
  descripcion varchar(255) not null,
  cantidad int null default null,
  precio float(5,2) null default null,
  id_factura int not null,
  id_producto int not null,
  primary key (id),
  index fk_factura (id_factura asc) visible,
  index fk_producto (id_producto asc) visible,
  constraint fk_factura
    foreign key (id_factura)
    references facturacion.factura (id_factura),
  constraint fk_producto
    foreign key (id_producto)
    references facturacion.producto (id_producto));
