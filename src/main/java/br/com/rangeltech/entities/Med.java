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
public class Med {

	private Integer id_med;		
	private String cod_med;			
	private String medicacao;		
	private String med_descricao;
	
}
