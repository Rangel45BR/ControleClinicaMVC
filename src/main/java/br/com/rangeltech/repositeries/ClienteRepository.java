package br.com.rangeltech.repositeries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.rangeltech.entities.Cliente;
import br.com.rangeltech.factories.ConnectionFactory;




public class ClienteRepository {

	public void create(Cliente cliente) throws Exception {
		Connection connection = ConnectionFactory.openConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"insert into cliente(cliente,convenio,n_carteira,dtcadcliente,tel_cliente,cpf_cliente,dt_nas_cliente,email_cliente,resp_cliente,end_cliente,tel_resp_cliente,cidade_cliente,cep_cliente,notacliente,idadecliente) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setString(1, cliente.getCliente());
		preparedStatement.setString(2, cliente.getConvenio());
		preparedStatement.setString(3, cliente.getN_carteira());
		preparedStatement.setDate(4, java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(cliente.getDtcadcliente())));
		preparedStatement.setString(5, cliente.getTel_cliente());
		preparedStatement.setString(6, cliente.getCpf_cliente());
		preparedStatement.setDate(7, java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(cliente.getDt_nas_cliente())));
		preparedStatement.setString(8, cliente.getEmail_cliente());
		preparedStatement.setString(9, cliente.getResp_cliente());
		preparedStatement.setString(10, cliente.getTel_resp_cliente());
		preparedStatement.setString(11, cliente.getEnd_cliente());
		preparedStatement.setString(12, cliente.getCidade_cliente());
		preparedStatement.setString(13, cliente.getCep_cliente());		
		preparedStatement.setString(14, cliente.getNotacliente());
		preparedStatement.setString(15, cliente.getIdadecliente());

		preparedStatement.execute();

		connection.close();
	}

	//
	public void update(Cliente cliente) throws Exception {

		Connection connection = ConnectionFactory.openConnection();

		PreparedStatement preparedStatement = connection.prepareStatement(
				"update cliente set cliente=?, convenio=?, n_carteira=?, dtcadcliente=?, tel_cliente=?, cpf_cliente=?, dt_nas_cliente=?, email_cliente=?, resp_cliente=?, end_cliente=?, tel_resp_cliente=?, cidade_cliente=?, cep_cliente=?, notacliente=?, idadecliente=? where id_cliente=?");
		preparedStatement.setString(1, cliente.getCliente());
		preparedStatement.setString(2, cliente.getConvenio());
		preparedStatement.setString(3, cliente.getN_carteira());
		preparedStatement.setDate(4, java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(cliente.getDtcadcliente())));
		preparedStatement.setString(5, cliente.getTel_cliente());
		preparedStatement.setString(6, cliente.getCpf_cliente());
		preparedStatement.setDate(7, java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(cliente.getDt_nas_cliente())));
		preparedStatement.setString(8, cliente.getEmail_cliente());
		preparedStatement.setString(9, cliente.getResp_cliente());
		preparedStatement.setString(10, cliente.getTel_resp_cliente());
		preparedStatement.setString(11, cliente.getEnd_cliente());
		preparedStatement.setString(12, cliente.getCidade_cliente());
		preparedStatement.setString(13, cliente.getCep_cliente());		
		preparedStatement.setString(14, cliente.getNotacliente());
		preparedStatement.setString(15, cliente.getIdadecliente());
		preparedStatement.setInt(16, cliente.getId_cliente());

		preparedStatement.execute();

		connection.close();
	}
	//
	public void delete(Cliente cliente) throws Exception {

		Connection connection = ConnectionFactory.openConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("delete from cliente where id_cliente=?");
		preparedStatement.setInt(1, cliente.getId_cliente());
		preparedStatement.execute();

		connection.close();
	}
	//
	
	public Cliente findByCliente(String string) throws Exception {
		Connection connection = ConnectionFactory.openConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from cliente where cliente = ?");
		preparedStatement.setString(1, string);
		// quando for pesquisa utiliza se resultSet
		ResultSet resultSet = preparedStatement.executeQuery();

		Cliente cliente = null;
		if (resultSet.next()) {
			cliente = new Cliente();

			cliente.setId_cliente(resultSet.getInt("id_cliente"));
			cliente.setCliente(resultSet.getString("cliente"));
			cliente.setConvenio(resultSet.getString("convenio"));
			cliente.setN_carteira(resultSet.getString("n_carteira"));
			cliente.setDtcadcliente(resultSet.getDate("dtcadcliente"));
			cliente.setTel_cliente(resultSet.getString("tel_cliente"));
			cliente.setCpf_cliente(resultSet.getString("cpf_cliente"));
			cliente.setDt_nas_cliente(resultSet.getDate("dt_nas_cliente"));
			cliente.setIdadecliente(resultSet.getString("idadecliente"));
			cliente.setEmail_cliente(resultSet.getString("email_cliente"));
			cliente.setResp_cliente(resultSet.getString("resp_cliente"));
			cliente.setTel_resp_cliente(resultSet.getString("tel_resp_cliente"));
			cliente.setEnd_cliente(resultSet.getString("end_cliente"));
			cliente.setCidade_cliente(resultSet.getString("cidade_cliente"));
			cliente.setCep_cliente(resultSet.getString("cep_cliente"));
			cliente.setNotacliente(resultSet.getString("notacliente"));

		}
		connection.close();
		return cliente;
	}
	// método para consultar e retornar todas as pessoas cadastradas
		public List<Cliente> findAll() throws Exception {

			Connection connection = ConnectionFactory.openConnection();

			PreparedStatement preparedStatement = connection.prepareStatement("select * from cliente order by cliente");
			ResultSet resultSet = preparedStatement.executeQuery();

			
			List<Cliente> lista = new ArrayList<Cliente>();

			
			while (resultSet.next()) { 

				Cliente cliente = new Cliente();

				cliente.setId_cliente(resultSet.getInt("id_cliente"));
				cliente.setCliente(resultSet.getString("cliente"));
				cliente.setConvenio(resultSet.getString("convenio"));
				cliente.setN_carteira(resultSet.getString("n_carteira"));
				cliente.setDtcadcliente(resultSet.getDate("dtcadcliente"));
				cliente.setTel_cliente(resultSet.getString("tel_cliente"));
				cliente.setCpf_cliente(resultSet.getString("cpf_cliente"));
				cliente.setDt_nas_cliente(resultSet.getDate("dt_nas_cliente"));
				cliente.setIdadecliente(resultSet.getString("idadecliente"));
				cliente.setEmail_cliente(resultSet.getString("email_cliente"));
				cliente.setResp_cliente(resultSet.getString("resp_cliente"));
				cliente.setTel_resp_cliente(resultSet.getString("tel_resp_cliente"));
				cliente.setEnd_cliente(resultSet.getString("end_cliente"));
				cliente.setCidade_cliente(resultSet.getString("cidade_cliente"));
				cliente.setCep_cliente(resultSet.getString("cep_cliente"));
				cliente.setNotacliente(resultSet.getString("notacliente"));

				lista.add(cliente); 
			}

			connection.close();
			return lista;
		}

		public List<Cliente> findByUsuario(Integer idUsuario) throws Exception {
		
			Connection connection = ConnectionFactory.openConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from cliente where idusuario = ? order by nome");
			
			preparedStatement.setInt(1, idUsuario);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			List<Cliente> lista = new ArrayList<Cliente>();
			
			while(resultSet.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId_cliente(resultSet.getInt("id_cliente"));
				cliente.setCliente(resultSet.getString("cliente"));
				cliente.setConvenio(resultSet.getString("convenio"));
				cliente.setN_carteira(resultSet.getString("n_carteira"));
				cliente.setDtcadcliente(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("dtcadcliente")));
				cliente.setTel_cliente(resultSet.getString("tel_cliente"));
				cliente.setCpf_cliente(resultSet.getString("cpf_cliente"));
				cliente.setIdadecliente(resultSet.getString("idadecliente"));			
				cliente.setResp_cliente(resultSet.getString("resp_cliente"));
				
				lista.add(cliente);
				
				
			}
			connection.close();
			return lista;
			
		}
		
		public Cliente findById(Integer id_cliente) throws Exception {
			Connection connection = ConnectionFactory.openConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from cliente where id_cliente = ?");
			preparedStatement.setInt(1, id_cliente);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			Cliente cliente = null;
			
			if (resultSet.next()) {
				
				cliente = new Cliente();
				
				cliente.setId_cliente(resultSet.getInt("id_cliente"));
				cliente.setCliente(resultSet.getString("cliente"));
				cliente.setConvenio(resultSet.getString("convenio"));
				cliente.setN_carteira(resultSet.getString("n_carteira"));
				cliente.setDtcadcliente(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("dtcadcliente")));
				cliente.setTel_cliente(resultSet.getString("tel_cliente"));
				cliente.setCpf_cliente(resultSet.getString("cpf_cliente"));
				cliente.setDt_nas_cliente(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("dt_nas_cliente")));
				cliente.setIdadecliente(resultSet.getString("idadecliente"));
				cliente.setEmail_cliente(resultSet.getString("email_cliente"));
				cliente.setResp_cliente(resultSet.getString("resp_cliente"));
				cliente.setTel_resp_cliente(resultSet.getString("tel_resp_cliente"));
				cliente.setEnd_cliente(resultSet.getString("end_cliente"));
				cliente.setCidade_cliente(resultSet.getString("cidade_cliente"));
				cliente.setCep_cliente(resultSet.getString("cep_cliente"));
				cliente.setNotacliente(resultSet.getString("notacliente"));
				
			}
			connection.close();
			return cliente;
		}
}
