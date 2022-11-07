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
public class ClienteController {
	
		@RequestMapping(value ="/admin/cadcliente")
		public ModelAndView cliente() {
		
			ModelAndView modelAndView = new ModelAndView("/admin/cliente");
			
			return modelAndView;
		}	
		@RequestMapping(value ="/admin/cadcliente", method = RequestMethod.POST)
		public ModelAndView realizarCadastro(HttpServletRequest request) {
			
			ModelAndView modelAndView = new ModelAndView("/admin/cliente");
			
			try {
				Cliente cliente = new Cliente();
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
				if(clienteRepository.findByCliente(cliente.getCliente()) != null) {
					modelAndView.addObject("mensagem_erro", " O Cliente informado já foi cadastrado! ");
				}
				else {
					clienteRepository.create(cliente);
					
					modelAndView.addObject("mensagem_sucesso", "Parabéns! Cadastro realizado com sucesso.");
				}
			}
			catch(Exception e ) {
				
				modelAndView.addObject("mensagem_erro", " Falha ao cadastrar.");
				e.printStackTrace();
				
			}
			return modelAndView;
		}
	}

