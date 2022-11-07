package br.com.rangeltech.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.rangeltech.entities.Cliente;
import br.com.rangeltech.repositeries.ClienteRepository;

@Controller
public class EdicaoClienteController {
	@RequestMapping(value = "/admin/editar-cliente")
	public ModelAndView clienteEdicao(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("admin/edicao_cliente");
		
		try {
			Integer id_cliente = Integer.parseInt(request.getParameter("id"));
			ClienteRepository clienteRepository = new ClienteRepository();
			
			Cliente cliente = clienteRepository.findById(id_cliente);
			
			if(cliente != null) {
				
			modelAndView.addObject("id_cliente", cliente.getId_cliente());
			modelAndView.addObject("cliente", cliente.getCliente());	
			modelAndView.addObject("convenio", cliente.getConvenio());
			modelAndView.addObject("n_carteira", cliente.getN_carteira());
			modelAndView.addObject("dtcadcliente", new SimpleDateFormat("dd-MM-yyyy").format(cliente.getDtcadcliente()));
			modelAndView.addObject("tel_cliente", cliente.getTel_cliente());	
			modelAndView.addObject("cpf_cliente", cliente.getCpf_cliente());
			modelAndView.addObject("dt_nas_cliente", new SimpleDateFormat("dd-MM-yyyy").format(cliente.getDt_nas_cliente()));
			modelAndView.addObject("email_cliente", cliente.getEmail_cliente());
			modelAndView.addObject("resp_cliente", cliente.getResp_cliente());
			modelAndView.addObject("tel_resp_cliente", cliente.getTel_resp_cliente());
			modelAndView.addObject("end_cliente", cliente.getEnd_cliente());
			modelAndView.addObject("cidade_cliente", cliente.getCidade_cliente());
			modelAndView.addObject("cep_cliente", cliente.getCep_cliente());	
			modelAndView.addObject("notacliente", cliente.getNotacliente());
			modelAndView.addObject("idadecliente", cliente.getIdadecliente());
			
			}
			else{
				modelAndView.setViewName("redirect:/admin/consultar-clientes");
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao obter cliente.");
			e.printStackTrace();
		}
		
		
		return modelAndView;
				
	}
	
	@RequestMapping(value="/admin/editar-cliente", method = RequestMethod.POST)
	public ModelAndView atualizarCliente(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("admin/edicao_cliente");
		try {
			Cliente cliente = new Cliente();
			cliente.setId_cliente(Integer.parseInt(request.getParameter("id_cliente")));
			cliente.setCliente(request.getParameter("cliente"));
			cliente.setConvenio(request.getParameter("convenio"));
			cliente.setN_carteira(request.getParameter("n_carteira"));
			cliente.setDtcadcliente(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dtcadcliente")));
			cliente.setTel_cliente(request.getParameter("tel_cliente"));
			cliente.setCpf_cliente(request.getParameter("cpf_cliente"));
			cliente.setDt_nas_cliente(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dt_nas_cliente")));
			cliente.setEmail_cliente(request.getParameter("email_cliente"));
			cliente.setResp_cliente(request.getParameter("resp_cliente"));
			cliente.setTel_resp_cliente(request.getParameter("tel_resp_cliente"));
			cliente.setEnd_cliente(request.getParameter("end_cliente"));
			cliente.setCidade_cliente(request.getParameter("cidade_cliente"));
			cliente.setCep_cliente(request.getParameter("cep_cliente"));			
			cliente.setNotacliente(request.getParameter("notacliente"));
			cliente.setIdadecliente(request.getParameter("idadecliente"));
			
			ClienteRepository clienteRepository = new ClienteRepository();
			clienteRepository.update(cliente);
			
			modelAndView.addObject("mensagem_sucesso", "Cliente atualizado com SUCESSO!");
			
			modelAndView.addObject("id_cliente", cliente.getId_cliente());
			modelAndView.addObject("cliente", cliente.getCliente());	
			modelAndView.addObject("convenio", cliente.getConvenio());
			modelAndView.addObject("n_carteira", cliente.getN_carteira());
			modelAndView.addObject("dtcadcliente", new SimpleDateFormat("dd-MM-yyyy").format(cliente.getDtcadcliente()));
			modelAndView.addObject("tel_cliente", cliente.getTel_cliente());	
			modelAndView.addObject("cpf_cliente", cliente.getCpf_cliente());
			modelAndView.addObject("dt_nas_cliente", new SimpleDateFormat("dd-MM-yyyy").format(cliente.getDt_nas_cliente()));
			modelAndView.addObject("email_cliente", cliente.getEmail_cliente());
			modelAndView.addObject("resp_cliente", cliente.getResp_cliente());
			modelAndView.addObject("tel_resp_cliente", cliente.getTel_resp_cliente());
			modelAndView.addObject("end_cliente", cliente.getEnd_cliente());
			modelAndView.addObject("cidade_cliente", cliente.getCidade_cliente());
			modelAndView.addObject("cep_cliente", cliente.getCep_cliente());	
			modelAndView.addObject("notacliente", cliente.getNotacliente());
			modelAndView.addObject("idadecliente", cliente.getIdadecliente());
			
			
		}
		catch(Exception e) {
			modelAndView.addObject("mesagem_erro", " Falha ao editar Cliente.");
			e.printStackTrace();
		}
		return modelAndView;
	}
}
