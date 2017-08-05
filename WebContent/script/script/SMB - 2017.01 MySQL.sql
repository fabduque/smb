CREATE TABLE SMB_USUARIO (
	id_user		smallint(5) AUTO_INCREMENT PRIMARY KEY,
	nome		varchar(100),
	nick		varchar(30),
	email		varchar(100),
	senha		varchar(300),
	status		char(1),
	cpf			char(14),
	telefone	char(12),
	dtNasc		date,
	dtUltimo	date,
	imagem		blob,
	tp_user		char(5));

CREATE TABLE smbLancamento( 
	idLancamento	smallint(5) AUTO_INCREMENT PRIMARY KEY,
	idConta			smallint(5),
	idCategoria		smallint(5),
	idSubCategoria	smallint(5),
	idForma			smallint(1),
	idUser			smallint(5),
	tpConta			smallint(1), -- (1)Conta (2)Cartao
	dtLancamento	date, 
	dsLancamento	varchar(50),
	sgStatus		char(1), -- (R)ealizado, (P)revisto
	sgMovimento		char(1), -- (D)ebito, (R)eceita, (T)ransferencia
	vlLancamento	float,
	icContaFixa		char(1), -- (S)im, (N)ao
	dsFaturaCartao	varchar(15));

CREATE TABLE smbCartao( 
	idCartao		smallint(5) AUTO_INCREMENT PRIMARY KEY,
	dscartao		varchar(30),
	imgCartao		blob,
	diaFechamento	char(2),
	diaVencimento	char(2),
	vlLimite		float,
	idContaPagto	smallint(5), -- Conta que sai o dinheiro para pagar a conta
	id_user			smallint(5));

CREATE TABLE smbCategoria( 
	idCategoria		smallint(5) AUTO_INCREMENT PRIMARY KEY,
	dsCategoria		varchar(20),
	icDebCred		char(1),
	dsColor			char(10),
	idUser			smallint(5));

CREATE TABLE smbSub( 
	idSub		smallint(5) AUTO_INCREMENT PRIMARY KEY,
	idCategoria	smallint(5),
	dsSub		varchar(20),
	idUser		smallint(5));

CREATE TABLE smbConta( 
	idConta			smallint(5)	AUTO_INCREMENT PRIMARY KEY,
	dsConta			varchar(20),
	tpConta			varchar(14), -- Conta Corrente, Conta Poupanca, Investimentos, Outros
	vlSaldoinicial	float,
	dsObs			varchar(50),
	idUser			smallint(5));

CREATE TABLE smbFormaPagto( 
	idForma		smallint(1)	AUTO_INCREMENT PRIMARY KEY,
	idUser		smallint(5),
	dsForma		varchar(15)); -- (T)ransf, (D)espesa, (R)eceita, (C)arteira

CREATE TABLE smbSaldo( 
	idSaldo		smallint(5)	AUTO_INCREMENT PRIMARY KEY,
	dtSaldo		date,
	vlSaldo		float,
	idConta		smallint(5),
	idUser		smallint(5));

INSERT INTO smbformapagto (idUser, dsForma) VALUES(1, 'Carteira');
INSERT INTO smbformapagto (idUser, dsForma) VALUES(1, 'Despesa');
INSERT INTO smbformapagto (idUser, dsForma) VALUES(1, 'Receita');
INSERT INTO smbformapagto (idUser, dsForma) VALUES(1, 'Transfer�ncia');

	