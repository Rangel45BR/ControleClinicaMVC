package br.com.rangeltech.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.rangeltech.entities.Cliente;
import br.com.rangeltech.repositeries.ClienteRepository;

@Controller
public class ConsultaClienteController {
	@RequestMapping(value = "/admin/consultar-clientes")
	public ModelAndView consultacliente(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("/admin/consulta_cliente");
		
		try {
			ClienteRepository clienteRepository = new ClienteRepository();
			List<Cliente>lista = clienteRepository.findAll();
			
					
			modelAndView.addObject("lista_cliente", lista);
			
						
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
			
		}
		return modelAndView;
				
	}
	@RequestMapping(value = "/admin/excluir-cliente")
	public ModelAndView excluirCliente(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("/admin/consulta_cliente");
		
		try {
			Integer id_cliente = Integer.parseInt(request.getParameter("id"));
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(id_cliente);
			
			if(cliente != null) {
				clienteRepository.delete(cliente);
				modelAndView.addObject("mensagem_sucesso", "Cliente " + cliente.getCliente()+ ",excluído com SUCESSO.");
				
				List<Cliente>lista = clienteRepository.findAll();
								
				modelAndView.addObject("lista_cliente", lista);
			}
			
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", " Falha ao excluir o cliente");
			e.printStackTrace();
			
		}	
		return modelAndView;
	}
	
	
	
}
