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
public class EdicaoColaboradorController {
	@RequestMapping(value = "/admin/editar-colaborador")
	public ModelAndView colaboradorEdicao(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("admin/edicao_colaborador");
		
		try {
			Integer idcolaborador = Integer.parseInt(request.getParameter("id"));
			ColaboradorRepository colaboradorRepository = new ColaboradorRepository();
			
			Colaborador colaborador = colaboradorRepository.findById(idcolaborador);
			
			if(colaborador != null) {
				
			modelAndView.addObject("idcolaborador", colaborador.getIdcolaborador());
			modelAndView.addObject("colaborador", colaborador.getColaborador());	
			modelAndView.addObject("cpf_colaborador", colaborador.getCpf_colaborador());
			modelAndView.addObject("email_colaborador", colaborador.getEmail_colaborador());
			modelAndView.addObject("dt_nas_colaborador", new SimpleDateFormat("dd-MM-yyyy").format(colaborador.getDt_nas_colaborador()));
			modelAndView.addObject("id_profissional", colaborador.getId_profissional());	
			modelAndView.addObject("profissao", colaborador.getProfissao());
			modelAndView.addObject("especialidade", colaborador.getEspecialidade());
			modelAndView.addObject("disponibilidade", colaborador.getDisponibilidade());
			modelAndView.addObject("escolaridade", colaborador.getEscolaridade());
			modelAndView.addObject("tel_colaborador", colaborador.getTel_colaborador());
			modelAndView.addObject("end_colaborador", colaborador.getEnd_colaborador());
			modelAndView.addObject("cidade_colaborador", colaborador.getCidade_colaborador());	
			modelAndView.addObject("cep_colaborador", colaborador.getCep_colaborador());
			modelAndView.addObject("notacolaborador", colaborador.getNotacolaborador());				
			modelAndView.addObject("dtcadcolab", new SimpleDateFormat("dd-MM-yyyy").format(colaborador.getDtcadcolab()));
			
								
			}
			else{
				modelAndView.setViewName("redirect:/admin/consultar-colaborador");
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao obter colaborador.");
			e.printStackTrace();
		}
		
		
		return modelAndView;
				
	}
	
	@RequestMapping(value="/admin/editar-colaborador", method = RequestMethod.POST)
	public ModelAndView atualizarColaborador(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("admin/edicao_colaborador");
		try {
			Colaborador colaborador = new Colaborador();
			colaborador.setIdcolaborador(Integer.parseInt(request.getParameter("idcolaborador")));
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
			colaborador.setNotacolaborador(request.getParameter("notacolaborador"));
			colaborador.setDtcadcolab(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dtcadcolab")));
			
			ColaboradorRepository colaboradorRepository = new ColaboradorRepository();
			colaboradorRepository.update(colaborador);
			
			modelAndView.addObject("mensagem_sucesso", "Colaborador atualizado com SUCESSO!");
			
			modelAndView.addObject("idcolaborador", colaborador.getIdcolaborador());
			modelAndView.addObject("colaborador", colaborador.getColaborador());	
			modelAndView.addObject("cpf_colaborador", colaborador.getCpf_colaborador());
			modelAndView.addObject("email_colaborador", colaborador.getEmail_colaborador());
			modelAndView.addObject("dt_nas_colaborador", new SimpleDateFormat("dd-MM-yyyy").format(colaborador.getDt_nas_colaborador()));
			modelAndView.addObject("id_profissional", colaborador.getId_profissional());	
			modelAndView.addObject("profissao", colaborador.getProfissao());
			modelAndView.addObject("especialidade", colaborador.getEspecialidade());
			modelAndView.addObject("disponibilidade", colaborador.getDisponibilidade());
			modelAndView.addObject("escolaridade", colaborador.getEscolaridade());
			modelAndView.addObject("tel_colaborador", colaborador.getTel_colaborador());
			modelAndView.addObject("end_colaborador", colaborador.getEnd_colaborador());
			modelAndView.addObject("cidade_colaborador", colaborador.getCidade_colaborador());	
			modelAndView.addObject("cep_colaborador", colaborador.getCep_colaborador());
			modelAndView.addObject("notacolaborador", colaborador.getNotacolaborador());				
			modelAndView.addObject("dtcadcolab", new SimpleDateFormat("dd-MM-yyyy").format(colaborador.getDtcadcolab()));
			
			
			
		}
		catch(Exception e) {
			modelAndView.addObject("mesagem_erro", " Falha ao editar Colaborador.");
			e.printStackTrace();
		}
		return modelAndView;
	}
}
