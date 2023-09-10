create table usuario (
	id_usuario int unique auto_increment,
    nome varchar(60) not null,
    cpf varchar(11)not null unique,
    cargo enum ('Paciente','Profissional da Saúde','Recepcionista','Administrador','Técnico de Manutenção') not null,
    email varchar(40) not null,
    senha varchar(90) not null,
    telefone varchar(14),
    primary key (id_usuario)
	
) default charset = UTF8MB4;


SELECT * FROM usuario WHERE cpf = 51028851898;