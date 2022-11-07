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
public class Amb {

	private Integer id_amb;			
	private String ref_amb;				
	private String amb_CH;				
	private String amb_descricao;	
	
}
