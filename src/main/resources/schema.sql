CREATE TABLE bibliotecario
(
    id    SERIAL PRIMARY KEY,
    nome  VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(255)
);

CREATE TABLE livro
(
    id             SERIAL PRIMARY KEY,
    titulo         VARCHAR(255),
    ano_publicacao BIGINT
);

CREATE TABLE membro
(
    id       SERIAL PRIMARY KEY,
    nome     VARCHAR(255),
    endereco VARCHAR(255),
    telefone VARCHAR(20)
);

CREATE TABLE visitante
(
    id       SERIAL PRIMARY KEY,
    nome     VARCHAR(255),
    telefone VARCHAR(255)
);

CREATE TABLE emprestimo
(
    id              SERIAL PRIMARY KEY,
    livro_id        BIGINT,
    membro_id       BIGINT,
    data_emprestimo DATE,
    data_devolucao  DATE,
    FOREIGN KEY (livro_id) REFERENCES livro (id),
    FOREIGN KEY (membro_id) REFERENCES membro (id)
);