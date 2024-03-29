INSERT INTO bibliotecario (nome, email, senha)
VALUES ('João Silva', 'joao@example.com', 'senha123');

INSERT INTO livro (titulo, ano_publicacao)
VALUES ('Dom Casmurro', 1899);

INSERT INTO membro (nome, endereco, telefone)
VALUES ('Maria Oliveira', 'Rua das Flores, 123', '(11) 1234-5678');

INSERT INTO visitante (nome, telefone)
VALUES ('Pedro Souza', '(11) 9876-5432');

INSERT INTO emprestimo (livro_id, membro_id, data_emprestimo, data_devolucao)
VALUES (1, 1, '2024-03-29', '2024-04-29');

