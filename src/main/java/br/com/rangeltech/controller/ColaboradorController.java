package br.com.rangeltech.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.rangeltech.entities.Colaborador;
import br.com.rangeltech.repositeries.ColaboradorRepository;

@Controller
public class ColaboradorController {

	@RequestMapping(value = "/admin/cadcolaborador")
	public ModelAndView colaborador() {
		
		ModelAndView modelAndView = new ModelAndView("/admin/colaborador");
		
		return modelAndView;
	}
	@RequestMapping(value ="/admin/cadcolaborador", method = RequestMethod.POST)
	public ModelAndView realizarCadColaborador(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("/admin/colaborador");
		
		try {
			Colaborador colaborador = new Colaborador();
			colaborador.setColaborador(request.getParameter("colaborador"));
			colaborador.setCpf_colaborador(request.getParameter("cpf_colaborador"));
			colaborador.setEmail_colaborador(request.getParameter("email_colaborador"));
			colaborador.setDt_nas_colaborador(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dt_nas_colaborador")));
			colaborador.setId_profissional(request.getParameter("id_profissional"));
			colaborador.setProfissao(request.getParameter("profissao"));
			colaborador.setEspecialidade(request.getParameter("especialidade"));
			colaborador.setDisponibilidade(request.getParameter("disponibilidade"));
			colaborador.setEscolaridade(request.getParameter("escolaridade"));
			colaborador.setTel_colaborador(request.getParameter("tel_colaborador"));
			colaborador.setEnd_colaborador(request.getParameter("end_colaborador"));
			colaborador.setCidade_colaborador(request.getParameter("cidade_colaborador"));
			colaborador.setCep_colaborador(request.getParameter("cep_colaborador"));
			colaborador.setDtcadcolab(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dtcadcolab")));
			colaborador.setNotacolaborador(request.getParameter("notacolaborador"));
			
			ColaboradorRepository colaboradorRepository = new ColaboradorRepository();
			if( colaboradorRepository.findByColaborador(colaborador.getColaborador()) != null) {
				modelAndView.addObject("mensagem_erro", " O colaborador informado já foi cadastrado! ");
				
			}
			else {
				colaboradorRepository.create(colaborador);
				modelAndView.addObject("mensagem_sucesso", "Parabéns! Cadastro realizado ");
				}
			}
			catch(Exception e) {
				modelAndView.addObject("mensagem_erro", " Falha ao cadastrar.");
				e.printStackTrace();
				
		}
		return modelAndView;
		
	}
}
