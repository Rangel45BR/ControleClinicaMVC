package br.com.rangeltech.entities;


import java.util.Date;

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

public class Cliente {
	
	private Integer id_cliente;		  	   		
	private String cliente;			  	  		
	private String convenio;		  		
	private String n_carteira;		  
	private Date dtcadcliente; 	  				
	private String tel_cliente;   	  
	private String cpf_cliente;	  			
	private Date dt_nas_cliente;	  				
	private String idadecliente;	  
	private String email_cliente;	  
	private String resp_cliente;	 
	private String tel_resp_cliente;  
	private String end_cliente;		  
	private String cidade_cliente;
	private String cep_cliente;
	private String notacliente;		 
	
}
