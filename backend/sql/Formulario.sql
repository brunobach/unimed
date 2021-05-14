CREATE TABLE formulario (
    id        serial            NOT NULL,
    protocolo VARCHAR    (50)   NOT NULL,
    nome      VARCHAR    (250)  NOT NULL,
    email     VARCHAR 	 (250)  NOT NULL,
    estado    VARCHAR 	 (50)   NOT NULL,
    cidade    VARCHAR 	 (50)   NOT NULL,
    telefone  VARCHAR 	 (50)   NOT NULL,
    mensagem  VARCHAR 	 (1000) NOT NULL,
    PRIMARY KEY (id)
);