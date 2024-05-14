CREATE SEQUENCE CONTATOS_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;


CREATE TABLE TBL_CONTATOS (
ID INTEGER DEFAULT CONTATOS_SEQ.NEXTVAL NOT NULL,
NOME VARCHAR2(100) NOT NULL,
EMAIL VARCHAR(100) NOT NULL,
DATA_NASCIMENTO DATE NOT NULL
);