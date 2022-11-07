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
public class Estoque_Farmarcia {

	private Integer cod_matmed;		
	private String est_descricao;	
	private Date data_entrada;	
	private String qnt_entrada;	
	private Date data_saida;	
	private String qnt_saida;		
	private String tt_estoque; 
	
}
