CREATE TABLE if NOT EXISTS t_ficha (
	id_ficha int8 NOT NULL,
	descricao varchar(255) NOT NULL,
	id_usuario_pk int8 NOT NULL,	
	PRIMARY KEY (id_ficha),
	FOREIGN KEY (id_usuario_pk) REFERENCES t_usuario (id_usuario)	
)