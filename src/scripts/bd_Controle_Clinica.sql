--script 23/09
create table usuario(
	id_usuario          serial          	primary key,
	usuario				varchar(150)		not null,
	email_usuario  		varchar(100)		not null unique,
	senha				varchar(40)			not null,
	permissao			varchar(20)			not null);

create table cliente(
	id_cliente		  serial		   		primary key,
	cliente			  varchar(150)	  		not null,
	convenio		  varchar(50)			not null,
	n_carteira		  varchar(20),
	dtcadcliente 	  date					not null,
	tel_cliente   	  varchar(20),
	cpf_cliente		  varchar(20)			not null,
	dt_nas_cliente	  date					not null,
	idadecliente	  varchar(3),
	email_cliente	  varchar(100),
	resp_cliente	  varchar(100),
	tel_resp_cliente  varchar(20),
	end_cliente		  varchar(100)			not null,
	cidade_cliente	  varchar(30),
	cep_cliente		  varchar(15),
	ativo_cliente     boolean,
	notacliente		  varchar(500));
	
create table colaborador(
	id_colaborador			serial          primary key,
	colaborador			varchar(150) 		not null,
	cpf_colaborador		varchar(20)			not null,
	email_colaborador	varchar(100)     	not null,
	dt_nas_colaborador	date,
	id_profissional		varchar(20),
	profissao			varchar(20) 		not null,
	especialidade	  	varchar(20),
	disponibilidade 	varchar(20),
	escolaridade		varchar(20),
	tel_colaborador		varchar(15),
	end_colaborador		varchar(100),
	cidade_colaborador	varchar(30),
	cep_colaborador		varchar(10),
	notacolaborador		varchar(500),
	dtcadcolab			date
	);
		
create table plano_saude(
	id_plano_saude		serial				primary key,
	plano_saude			varchar(20),
	produto_ps			varchar(20),
	tabelaAMB			varchar(10),
	descrição_ps		varchar(150),
	foreign key(id_cliente)
		references cliente(id_cliente));

create table agenda(
	id_agenda			serial				primary key,
	tipo_consulta       varchar(15)			not null,
	ag_id_cliente		varchar(10)			not null,
	ag_nomecliente		varchar(100)    	not null,
	ag_plano_saude		varchar(20)			not null,
	ag_local_consulta	varchar(20),
	ag_endereco_cliente varchar(100),
	ag_tel_cliente		varchar(20),
	ag_data				date,
	ag_hora				varchar(10),
	ag_especialidade	varchar(20),
	ag_id_colaborador	varchar(10),
	ag_colaborador		varchar(100),
	ag_nota				varchar(500));

create table centro custo(
	id_cc				serial,				
	cc_codigo			varchar(10)			primary key,
	cc_descrição		varchar(100)		not null,
	cc_nota				varchar(200));
	
create table procedimento(
	id_procedimento		serial,
	proc_codigo			varchar(20)			not null,
	proc_descricao		varchar(150)		not null,
	prec_CH				varchar(10)			not null,
	ref_tblamb			varchar(10)			not null,
	foreign key(ref_amb)
		references amb(ref_amb));


create table amb(
	id_amb				serial,
	ref_amb				varchar(10)			primary key,
	amb_CH				varchar(10)			not null,
	amb_descricao		varchar(100));

create table diarias(
	id_diaria			serial,
	dia_codigo			varchar(20)			not null,
	dia_descricao		varchar(100)		not null);

create table taxas_alugueis(
	id_taxas_alugueis	    serial,
	tx_alg_codigo			varchar(20)			not null,
	tx_alg_descricao		varchar(100)		not null);

create table especialidade(
	id_especialidade		serial,
	especialidade			varchar(20),
	espc_descricao			varchar(50));

create table med(
	id_med			serial,
	cod_med			varchar				primary key,
	medicacao		varchar(50)				not null,
	med_descricao	varchar(100));

create table mat(
	id_mat			serial,
	cod_mat			varchar				primary key,
	material		varchar(50)				not null,
	mat_descricao	varchar(100));

create table estoque_farmacia(
	cod_matmed		varchar(10)				not null,
	est_descricao	varchar(100)		 	not null,
	data_entrada	date					not null,
	qnt_entrada		varchar(10),
	data_saida		date					not null,
	qnt_saida		varchar(10),
	tt_estoque		varchar(10));









	

	
	

