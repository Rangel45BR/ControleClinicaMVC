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
public class Diaria {

	private Integer id_diaria;		
	private String dia_codigo;			
	private String dia_descricao;	
	
}
