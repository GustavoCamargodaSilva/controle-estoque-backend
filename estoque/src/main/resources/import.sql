INSERT INTO tb_users(id,nome,birthdate,email,password,role) VALUES (1,'Gustavo','1997-08-02','gugusilvababolim@gmail.com','123456',0);

INSERT INTO tb_cliente(birthdate,status_cliente,id,cpf,email,nome) VALUES ('1997-08-02',0,1,'08446872943','gugusilvababolim@gmail.com','Gustavo Camargo');

INSERT INTO tb_fornecedor(id,cnpj,nome) VALUES (1,'123456789','teste deu certo');

INSERT INTO tb_filial(id) VALUES (1);
INSERT INTO tb_filial(id) VALUES (2);

INSERT INTO tb_produto(preco,cod_produto,fornecedor_id,descricao,nome) VALUES (20.00,1,1,'teste','teste');

INSERT INTO tb_produto_unidade(saldo,filial_id,produto_id) VALUES (100,1,1);
INSERT INTO tb_produto_unidade(saldo,filial_id,produto_id) VALUES (20,2,1);
