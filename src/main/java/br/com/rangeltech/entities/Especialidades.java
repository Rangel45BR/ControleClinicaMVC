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
public class Especialidades {

	private Integer id_especialidade;	
	private String especialidade;			
	private String espc_descricao;
	
}
