CREATE DATABASE mundoAlem;
USE mundoAlem;

CREATE TABLE Usuario (
    cpf decimal(11,0) PRIMARY KEY NOT NULL,
    nome VARCHAR(50),
    dataNasc date NOT NULL 
);

CREATE TABLE Destino (
    idDestino int(3) PRIMARY KEY AUTO_INCREMENT,
    nomeDestino VARCHAR(50) NOT NULL,
    valorDestino double(10,2) NOT NULL
);

CREATE TABLE Pagamento (
	idPag int(3) PRIMARY KEY AUTO_INCREMENT,
    valor double(10,2) NOT NULL,
    parcelas int(2) NOT NULL,
    dataVenc date,
    valorParcela double(10,2) NOT NULL,
    fk_Usuario_cpf decimal(11,0),
    fk_tipoPagamento_idTipo int(3)
);

CREATE TABLE tipoPagamento (
    idTipo int(3) PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(50)
);

/* tabela da classe DestinoEscolhido*/
CREATE TABLE escolhe (
    numViagem int(3) PRIMARY KEY AUTO_INCREMENT,
    dataIda date NOT NULL,
    dataVolta date,
    fk_Usuario_cpf decimal(11,0),
    fk_Destino_idDestino int(3)
);
 
ALTER TABLE Pagamento ADD CONSTRAINT FK_Pagamento_2
    FOREIGN KEY (fk_Usuario_cpf)
    REFERENCES Usuario (cpf)
    ON DELETE RESTRICT;
 
ALTER TABLE Pagamento ADD CONSTRAINT FK_Pagamento_3
    FOREIGN KEY (fk_tipoPagamento_idTipo)
    REFERENCES tipoPagamento (idTipo)
    ON DELETE RESTRICT;
 
ALTER TABLE escolhe ADD CONSTRAINT FK_escolhe_2
    FOREIGN KEY (fk_Destino_idDestino)
    REFERENCES Destino (idDestino)
    ON DELETE RESTRICT;
 
ALTER TABLE escolhe ADD CONSTRAINT FK_escolhe_3
    FOREIGN KEY (fk_Usuario_cpf)
    REFERENCES Usuario (cpf)
    ON DELETE SET NULL;
    
ALTER TABLE Usuario ADD COLUMN email VARCHAR(50) NOT NULL;
ALTER TABLE Usuario ADD COLUMN senha VARCHAR(100) NOT NULL;