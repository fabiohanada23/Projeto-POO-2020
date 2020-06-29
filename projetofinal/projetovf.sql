create table tb_morador(
	id_morador int auto_increment not null primary key,
    nome varchar(255),
    cpf varchar(255),
    email varchar(255),
    celular varchar(255)
);

create table tb_corretor(
	id_corretor int auto_increment not null primary key,
    nome varchar(255),
    cpf varchar(255),
    ap_visita varchar(255),
    num_registro varchar(255)
);

create table tb_entregador(
	id_entregador int auto_increment not null primary key,
    nome varchar(255),
    cpf varchar(255),
    ap_visita varchar(255),
    tipo_entrega varchar(255)
);

create table tb_prestador(
	id_prestador int auto_increment not null primary key,
    nome varchar(255),
    cpf varchar(255),
    ap_visita varchar(255),
    tipo_servico varchar(255)
);

create table tb_visitante(
	id_visitante int auto_increment not null primary key,
    nome varchar(255),
    cpf varchar(255),
    ap_visita varchar(255)
);