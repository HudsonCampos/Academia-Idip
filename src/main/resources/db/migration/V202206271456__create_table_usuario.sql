CREATE TABLE If NOT EXISTS t_usuario (
    id_usuario int8 NOT NULL,
    nome VARCHAR (255) NOT NULL,
    email VARCHAR (255) NOT NULL,
    data_nascimento DATE,
    telefone VARCHAR (255) NOT NULL,
    username VARCHAR (255) NOT NULL,
    senha VARCHAR (255) NOT NULL,
    id_perfil int8,
    FOREIGN KEY (id_perfil) REFERENCES t_perfil (id_perfil),
    PRIMARY KEY (id_usuario)
)
