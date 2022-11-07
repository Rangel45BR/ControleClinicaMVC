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

public class Colaborador {

	private Integer idcolaborador;
	private String colaborador;
	private String cpf_colaborador;
	private String email_colaborador;
	private Date dt_nas_colaborador;
	private String id_profissional;
	private String profissao;
	private String especialidade;
	private String disponibilidade;
	private String escolaridade;
	private String tel_colaborador;
	private String end_colaborador;
	private String cidade_colaborador;
	private String cep_colaborador;
	private String notacolaborador;
	private Date dtcadcolab;
	private Cliente cliente;
	 

}
