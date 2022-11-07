package br.com.rangeltech.entities;

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
public class Taxas_alugueis {
 
	private Integer id_taxas_alugueis;	  
	private String tx_alg_codigo;			
	private String tx_alg_descricao;
	
}
