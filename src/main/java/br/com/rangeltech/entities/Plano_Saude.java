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

public class Plano_Saude {

	private Integer id_plano_saude;		
	private String plano_saude;			
	private String produto_ps;			
	private String tabelaAMB;			
	private String descrição_ps;		
	private Cliente cliente;

}
