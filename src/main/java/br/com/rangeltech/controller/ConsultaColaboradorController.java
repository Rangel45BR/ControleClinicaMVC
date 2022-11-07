package br.com.rangeltech.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.rangeltech.entities.Colaborador;
import br.com.rangeltech.repositeries.ColaboradorRepository;

@Controller
public class ConsultaColaboradorController {
	@RequestMapping(value = "/admin/consultar-colaborador")
	public ModelAndView consultacolaborador(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("/admin/consulta_colaborador");
		
		try {
			ColaboradorRepository colaboradorRepository = new ColaboradorRepository();
			List<Colaborador>lista = colaboradorRepository.findAll();
			
					
			modelAndView.addObject("lista_colaborador", lista);
			
						
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
			
		}
		return modelAndView;
				
	}
	@RequestMapping(value = "/admin/excluir-colaborador")
	public ModelAndView excluirColaborador(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("/admin/consulta_colaborador");
		
		try {
			Integer idcolaborador = Integer.parseInt(request.getParameter("id"));
			ColaboradorRepository colaboradorRepository = new ColaboradorRepository();
			Colaborador colaborador = colaboradorRepository.findById(idcolaborador);
			
			if(colaborador != null) {
				colaboradorRepository.delete(colaborador);
				modelAndView.addObject("mensagem_sucesso", "Colaborador " + colaborador.getColaborador()+ ",excluído com SUCESSO.");
				
				List<Colaborador>lista = colaboradorRepository.findAll();
								
				modelAndView.addObject("lista_colaborador", lista);
			}
			
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", " Falha ao excluir o cliente");
			e.printStackTrace();
			
		}	
		return modelAndView;
	}
}
