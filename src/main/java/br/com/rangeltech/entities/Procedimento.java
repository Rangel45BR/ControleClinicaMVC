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
public class Procedimento {

	private Integer id_procedimento;	
	private String proc_codigo;			
	private String proc_descricao;		
	private String prec_CH;	
	private String ref_tblamb;
	private Amb ref_amb;
}
