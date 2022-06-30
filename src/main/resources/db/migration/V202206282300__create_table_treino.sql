CREATE TABLE If NOT EXISTS t_treino (
    id_treino int8 NOT NULL,
    data_treino timestamp NOT NULL,   
    id_ficha_pk int8,
    FOREIGN KEY (id_ficha_pk) REFERENCES t_ficha (id_ficha),
    PRIMARY KEY (id_treino)
)
