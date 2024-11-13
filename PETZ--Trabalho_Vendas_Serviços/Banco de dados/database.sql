--Camila Espindola Fernandes
--Ana Clara Santana Cruz


--Tabela para armazenar informações de cliente
CREATE TABLE tbcliente (
  Codigo int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(100) NOT NULL,
  CPF varchar(14) NOT NULL,
  DataNascimento date NOT NULL,
  PRIMARY KEY (Codigo)
);
--Tabela para armazenar informações de fornecedor 
CREATE TABLE tbfornecedor (
  Codigo int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(100) NOT NULL,
  CNPJ varchar(18) NOT NULL,
  PRIMARY KEY (Codigo)
);
--Tabela para armazenar informações de produto
CREATE TABLE tbproduto (
  Codigo int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(100) NOT NULL,
  PrecoCompra decimal(10,2) NOT NULL,
  PrecoVenda decimal(10,2) NOT NULL,
  QuantidadeEstoque int NOT NULL,
  PRIMARY KEY (Codigo)
);
--Tabela para armazenar informações de vbenda
CREATE TABLE tbvenda (
  Codigo int(11) NOT NULL AUTO_INCREMENT,
  CodigoCliente int(11) NOT NULL,
  DataVenda date NOT NULL,
  ValorTotal decimal(10,2) NOT NULL,
  Situacao int(11) NOT NULL,
  PRIMARY KEY (Codigo),
  KEY FK_CodigoCliente_idx (CodigoCliente),
  CONSTRAINT FK_CodigoCliente FOREIGN KEY (CodigoCliente) REFERENCES tbcliente (Codigo)
);
--Tabela para armazenar informações de compra
CREATE TABLE tbcompra (
  Codigo int(11) NOT NULL AUTO_INCREMENT,
  CodigoFornecedor int(11) NOT NULL,
  DataCompra date NOT NULL,
  ValorTotal decimal(10,2) NOT NULL,
  Situacao int(11) NOT NULL,
  PRIMARY KEY (Codigo),
  KEY FK_CodigoFornecedor_idx (CodigoFornecedor),
  CONSTRAINT FK_CodigoFornecedor FOREIGN KEY (CodigoFornecedor) REFERENCES tbfornecedor (Codigo)
);
--Tabela para armazenar informações de item de venda
CREATE TABLE tbitemvenda (
  Codigo int(11) NOT NULL AUTO_INCREMENT,
  CodigoProduto int(11) NOT NULL,
  CodigoVenda int(11) NOT NULL,
  Quantidade int(11) NOT NULL,
  ValorUnitario decimal(10,2) NOT NULL,
  PRIMARY KEY (Codigo),
  KEY FK_CodigoVenda_idx (CodigoVenda),
  KEY FK_CodigoProduto_idx (CodigoProduto),
  CONSTRAINT FK_CodigoProduto FOREIGN KEY (CodigoProduto) REFERENCES tbproduto (Codigo) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT FK_CodigoVenda FOREIGN KEY (CodigoVenda) REFERENCES tbvenda (Codigo) ON DELETE NO ACTION ON UPDATE NO ACTION
);
--Tabela para armazenar informações de item de compra
CREATE TABLE tbitemcompra (
  Codigo int(11) NOT NULL AUTO_INCREMENT,
  CodigoProduto int(11) NOT NULL,
  CodigoCompra int(11) NOT NULL,
  Quantidade int(11) NOT NULL,
  ValorUnitario decimal(10,2) NOT NULL,
  PRIMARY KEY (Codigo),
  KEY FK_CodigoCompra_idx2 (CodigoCompra),
  KEY FK_CodigoProduto_idx2 (CodigoProduto),
  CONSTRAINT FK_CodigoProduto2 FOREIGN KEY (CodigoProduto) REFERENCES tbproduto (Codigo) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT FK_CodigoCompra2 FOREIGN KEY (CodigoCompra) REFERENCES tbcompra (Codigo) ON DELETE NO ACTION ON UPDATE NO ACTION
);


--Consultas com Parâmetros:

--a. Imprimir todas as vendas realizadas entre janeiro de 2020 e outubro de 2022:

SELECT *
FROM tbvenda
WHERE DataVenda BETWEEN '2020-01-01' AND '2022-10-31';
--b. Imprimir todas as compras realizadas entre janeiro de 2020 e outubro de 2022:

SELECT *
FROM tbcompra
WHERE DataCompra BETWEEN '2020-01-01' AND '2022-10-31';

--Consulta sem Parâmetros:

--a. Imprimir todos os clientes cadastrados no sistema:

SELECT *
FROM tbcliente;

/*Uma empresa deseja gerenciar dados sobre suas operações comerciais, incluindo fornecedores, produtos, vendas, compras e clientes. Para cada fornecedor, é necessário armazenar o ID (chamado "CNPJ") e o nome. Cada produto, que pode ser fornecido por diversos fornecedores, terá um ID, nome, preço de compra, preço de venda e a quantidade em estoque registrada.

Quando uma venda é realizada, é essencial registrar o ID da venda, a data ("DataVenda"), o valor total e a situação da venda. Cada venda consistirá em diversos itens, com cada "ItemVenda" tendo seu próprio ID e o valor unitário dos produtos vendidos.

De forma similar, as compras feitas pela empresa também são registradas com um ID, data ("DataCompra"), valor total e situação. Cada "ItemCompra" associado a uma compra terá um ID, a quantidade comprada e o valor do item.

Clientes são uma parte vital do sistema, e para cada um, a empresa armazena um ID (CPF), nome e data de nascimento. Um cliente pode realizar várias compras e também pode ter várias vendas associadas a ele, indicando um relacionamento um-para-muitos entre clientes e compras, assim como clientes e vendas.*/

/*Tabela tbcliente:

Codigo int(11) NOT NULL AUTO_INCREMENT: 
 Define um campo inteiro de 11 dígitos que é incrementado automaticamente (chave primária).

Nome varchar(100) NOT NULL:
 Define um campo de caracteres (string) de até 100 caracteres para armazenar o nome do cliente.

CPF varchar(14) NOT NULL:
 Define um campo de caracteres para armazenar o CPF do cliente.

DataNascimento date NOT NULL:
 Define um campo de data para armazenar a data de nascimento do cliente.

PRIMARY KEY (Codigo): 
Indica que o campo Codigo é a chave primária da tabela.



Tabela tbfornecedor:

Semelhante à tabela tbcliente, mas com informações relacionadas a fornecedores. Armazena um código único para cada fornecedor, seu nome e CNPJ.
Tabela tbproduto:
 Armazena informações sobre produtos que podem ser comprados ou vendidos.

PrecoCompra decimal(10,2) NOT NULL:
 Define um campo decimal para armazenar o preço de compra do produto.

PrecoVenda decimal(10,2) NOT NULL:
 Define um campo decimal para armazenar o preço de venda do produto.

QuantidadeEstoque int NOT NULL:
 Define um campo inteiro para armazenar a quantidade disponível em estoque.




Tabela tbvenda:
Registra informações sobre vendas.

KEY FK_CodigoCliente_idx (CodigoCliente): 
Cria um índice na coluna CodigoCliente para otimizar consultas.

CONSTRAINT FK_CodigoCliente FOREIGN KEY (CodigoCliente) REFERENCES tbcliente (Codigo): 
Cria uma chave estrangeira para garantir que CodigoCliente na tabela tbvenda esteja vinculado a um Codigo válido na tabela tbcliente.



Tabela tbcompra:
Similar à tabela tbvenda, mas para compras.



Tabela tbitemvenda:
Registra os itens individuais em uma venda.

KEY FK_CodigoVenda_idx (CodigoVenda):
 Cria um índice na coluna CodigoVenda para otimizar consultas.

KEY FK_CodigoProduto_idx (CodigoProduto):
 Cria um índice na coluna CodigoProduto para otimizar consultas.

CONSTRAINT FK_CodigoProduto FOREIGN KEY (CodigoProduto) REFERENCES tbproduto (Codigo) ON DELETE NO ACTION ON UPDATE NO ACTION: 
 Cria uma chave estrangeira para garantir que CodigoProduto na tabela tbitemvenda esteja vinculado a um Codigo válido na tabela tbproduto. As cláusulas ON DELETE NO ACTION ON UPDATE NO ACTION indicam que nenhuma ação deve ser realizada se o produto referenciado for excluído ou atualizado.



Tabela tbitemcompra:
 Similar à tabela tbitemvenda, mas para itens de compra.*/


/*Relacionamento:

As tabelas de item (tbitemvenda e tbitemcompra) estão relacionadas às tabelas de venda e compra, respectivamente, por meio de chaves estrangeiras que apontam para a tabela de produto. Isso indica quais produtos estão associados a cada transação.

As tabelas de venda e compra têm chaves estrangeiras que se relacionam com as tabelas de cliente e fornecedor, respectivamente. Isso permite identificar o cliente associado a uma venda e o fornecedor associado a uma compra.*/


/*Sistema de Venda:

O banco de dados faz parte de um sistema de gerenciamento de vendas de tecnologia voltada pra gamers de  onde as transações de compra e venda são registradas, e os detalhes dos clientes, fornecedores e produtos são armazenados para facilitar o acompanhamento e a análise.

Com esse sistema, seria possível realizar consultas para obter relatórios de vendas, verificar o histórico de compras de um cliente ou fornecedor específico, controlar o estoque de produtos, entre outras funcionalidades típicas de um sistema de vendas.

O uso de chaves estrangeiras ajuda a manter a integridade referencial entre as tabelas, garantindo que as relações entre os dados sejam mantidas corretamente.*/