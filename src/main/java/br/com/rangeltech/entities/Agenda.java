package br.com.rangeltech.entities;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Agenda {

	private Integer id_agenda;		
	private String tipo_consulta;       
	private String ag_id_cliente;		
	private String ag_nomecliente;		
	private String ag_plano_saude;		
	private String ag_local_consulta;	
	private String ag_endereco_cliente; 
	private String ag_tel_cliente;	
	private Date ag_data;	
	private String ag_hora;				
	private String ag_especialidade;	
	private String ag_id_colaborador;	
	private String ag_colaborador;		
	private String ag_nota;				
	
	
}
