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
public class Centro_Custo {

	private Integer id_cc;					
	private String cc_codigo;			
	private String cc_descrição;		
	private String cc_nota;			
}
