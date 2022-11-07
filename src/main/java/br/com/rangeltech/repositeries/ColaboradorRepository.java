package br.com.rangeltech.repositeries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import br.com.rangeltech.entities.Colaborador;
import br.com.rangeltech.factories.ConnectionFactory;

public class ColaboradorRepository {

	public void create(Colaborador colaborador) throws Exception {
		Connection connection = ConnectionFactory.openConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"insert into colaborador (colaborador,cpf_colaborador,email_colaborador,dt_nas_colaborador,id_profissional,profissao, especialidade,disponibilidade,escolaridade,tel_colaborador,end_colaborador,cidade_colaborador,cep_colaborador,notacolaborador,dtcadcolab) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setString(1, colaborador.getColaborador());
		preparedStatement.setString(2, colaborador.getCpf_colaborador());
		preparedStatement.setString(3, colaborador.getEmail_colaborador());
		preparedStatement.setDate(4,
				java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(colaborador.getDt_nas_colaborador())));
		preparedStatement.setString(5, colaborador.getId_profissional());
		preparedStatement.setString(6, colaborador.getProfissao());
		preparedStatement.setString(7, colaborador.getEspecialidade());
		preparedStatement.setString(8, colaborador.getDisponibilidade());
		preparedStatement.setString(9, colaborador.getEscolaridade());
		preparedStatement.setString(10, colaborador.getTel_colaborador());
		preparedStatement.setString(11, colaborador.getEnd_colaborador());
		preparedStatement.setString(12, colaborador.getCidade_colaborador());
		preparedStatement.setString(13, colaborador.getCep_colaborador());
		preparedStatement.setString(14, colaborador.getNotacolaborador());
		preparedStatement.setDate(15,
				java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(colaborador.getDtcadcolab())));

		preparedStatement.execute();

		connection.close();

	}

	public void update(Colaborador colaborador) throws Exception {

		Connection connection = ConnectionFactory.openConnection();

		PreparedStatement preparedStatement = connection.prepareStatement(
				"update colaborador set colaborador=?,cpf_colaborador=?,email_colaborador=?,dt_nas_colaborador=?,id_profissional=?,profissao=?, especialidade=?,disponibilidade=?,escolaridade=?,tel_colaborador=?,end_colaborador=?,cidade_colaborador=?,cep_colaborador=?,notacolaborador=?,dtcadcolab=? where idcolaborador=?");
		preparedStatement.setString(1, colaborador.getColaborador());
		preparedStatement.setString(2, colaborador.getCpf_colaborador());
		preparedStatement.setString(3, colaborador.getEmail_colaborador());
		preparedStatement.setDate(4,
				java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(colaborador.getDt_nas_colaborador())));
		preparedStatement.setString(5, colaborador.getId_profissional());
		preparedStatement.setString(6, colaborador.getProfissao());
		preparedStatement.setString(7, colaborador.getEspecialidade());
		preparedStatement.setString(8, colaborador.getDisponibilidade());
		preparedStatement.setString(9, colaborador.getEscolaridade());
		preparedStatement.setString(10, colaborador.getTel_colaborador());
		preparedStatement.setString(11, colaborador.getEnd_colaborador());
		preparedStatement.setString(12, colaborador.getCidade_colaborador());
		preparedStatement.setString(13, colaborador.getCep_colaborador());
		preparedStatement.setString(14, colaborador.getNotacolaborador());
		preparedStatement.setDate(15,
				java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(colaborador.getDtcadcolab())));
		preparedStatement.setInt(16, colaborador.getIdcolaborador());
		
		preparedStatement.execute();

		connection.close();
	}

	public void delete(Colaborador colaborador) throws Exception {
		
		Connection connection = ConnectionFactory.openConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("delete from colaborador where idcolaborador=?");
		preparedStatement.setInt(1, colaborador.getIdcolaborador());
		preparedStatement.execute();
		
		connection.close();
		
	}
	
	public Colaborador findById (Integer idcolaborador) throws Exception {
		Connection connection = ConnectionFactory.openConnection();
		
		PreparedStatement preparedStatement= connection.prepareStatement("select * from colaborador where idcolaborador = ?");
		preparedStatement.setInt(1, idcolaborador);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Colaborador colaborador = null;
		
		if (resultSet.next()) {
			colaborador = new Colaborador();
			
			colaborador.setIdcolaborador(resultSet.getInt("idcolaborador"));
			colaborador.setColaborador(resultSet.getString("colaborador"));
			colaborador.setCpf_colaborador(resultSet.getString("cpf_colaborador"));
			colaborador.setEmail_colaborador(resultSet.getString("email_colaborador"));
			colaborador.setDt_nas_colaborador(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("dt_nas_colaborador")));
			colaborador.setId_profissional(resultSet.getString("id_profissional"));
			colaborador.setProfissao(resultSet.getString("profissao"));
			colaborador.setEspecialidade(resultSet.getString("especialidade"));
			colaborador.setDisponibilidade(resultSet.getString("disponibilidade"));
			colaborador.setEscolaridade(resultSet.getString("escolaridade"));
			colaborador.setTel_colaborador(resultSet.getString("tel_colaborador"));
			colaborador.setEnd_colaborador(resultSet.getString("end_colaborador"));
			colaborador.setCidade_colaborador(resultSet.getString("cidade_colaborador"));
			colaborador.setCep_colaborador(resultSet.getString("cep_colaborador"));
			colaborador.setNotacolaborador(resultSet.getString("notacolaborador"));
			colaborador.setDtcadcolab(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("dtcadcolab")));
			
			
		}
		connection.close();
		return colaborador;
	}
	
	public List<Colaborador> findAll() throws Exception {
		
		Connection connection = ConnectionFactory.openConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("select * from colaborador order by colaborador");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		List<Colaborador> lista = new ArrayList<Colaborador>();
		
		while (resultSet.next()) { 
			Colaborador colaborador = new Colaborador();
			
			colaborador.setIdcolaborador(resultSet.getInt("idcolaborador"));
			colaborador.setColaborador(resultSet.getString("colaborador"));
			colaborador.setCpf_colaborador(resultSet.getString("cpf_colaborador"));
			colaborador.setEmail_colaborador(resultSet.getString("email_colaborador"));
			colaborador.setDt_nas_colaborador(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("dt_nas_colaborador")));
			colaborador.setId_profissional(resultSet.getString("id_profissional"));
			colaborador.setProfissao(resultSet.getString("profissao"));
			colaborador.setEspecialidade(resultSet.getString("especialidade"));
			colaborador.setDisponibilidade(resultSet.getString("disponibilidade"));
			colaborador.setEscolaridade(resultSet.getString("escolaridade"));
			colaborador.setTel_colaborador(resultSet.getString("tel_colaborador"));
			colaborador.setEnd_colaborador(resultSet.getString("end_colaborador"));
			colaborador.setCidade_colaborador(resultSet.getString("cidade_colaborador"));
			colaborador.setCep_colaborador(resultSet.getString("cep_colaborador"));
			colaborador.setNotacolaborador(resultSet.getString("notacolaborador"));
			colaborador.setDtcadcolab(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("dtcadcolab")));
			
			lista.add(colaborador);
			
		}
		connection.close();
		return lista;
	}
	
	public Colaborador findByColaborador(String string) throws Exception{
		Connection connection = ConnectionFactory.openConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from colaborador where colaborador = ?");
		preparedStatement.setString(1, string);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Colaborador colaborador = null;
		if (resultSet.next()) {
			colaborador = new Colaborador();
			
			colaborador.setIdcolaborador(resultSet.getInt("idcolaborador"));
			colaborador.setColaborador(resultSet.getString("colaborador"));
			colaborador.setCpf_colaborador(resultSet.getString("cpf_colaborador"));
			colaborador.setEmail_colaborador(resultSet.getString("email_colaborador"));
			colaborador.setDt_nas_colaborador(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("dt_nas_colaborador")));
			colaborador.setId_profissional(resultSet.getString("id_profissional"));
			colaborador.setProfissao(resultSet.getString("profissao"));
			colaborador.setEspecialidade(resultSet.getString("especialidade"));
			colaborador.setDisponibilidade(resultSet.getString("disponibilidade"));
			colaborador.setEscolaridade(resultSet.getString("escolaridade"));
			colaborador.setTel_colaborador(resultSet.getString("tel_colaborador"));
			colaborador.setEnd_colaborador(resultSet.getString("end_colaborador"));
			colaborador.setCidade_colaborador(resultSet.getString("cidade_colaborador"));
			colaborador.setCep_colaborador(resultSet.getString("cep_colaborador"));
			colaborador.setNotacolaborador(resultSet.getString("notacolaborador"));
			colaborador.setDtcadcolab(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("dtcadcolab")));
						
		}
		connection.close();
		return colaborador;
		
	}
	
}
