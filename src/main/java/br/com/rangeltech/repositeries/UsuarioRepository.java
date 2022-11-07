package br.com.rangeltech.repositeries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.rangeltech.entities.Usuario;
import br.com.rangeltech.factories.ConnectionFactory;

public class UsuarioRepository {

	public void create(Usuario usuario)throws Exception {
		Connection connection = ConnectionFactory.openConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into usuario(nome,email,senha) values(?,?,md5(?))");  
		preparedStatement.setString(1,usuario.getNome());
		preparedStatement.setString(2,usuario.getEmail());
		preparedStatement.setString(3,usuario.getSenha());
		preparedStatement.execute();
		
		connection.close();
			
	}
	
	public void update(Integer idUsuario, String novaSenha) throws Exception {
		Connection connection = ConnectionFactory.openConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("update usuario set senha = md5(?) where idUsuario = ?");
		preparedStatement.setString(1, novaSenha);
		preparedStatement.setInt(2, idUsuario);
		preparedStatement.execute();
		
		// fechando a conexão com o banco de dados
		connection.close();
		
	}
	
	//
	public Usuario findByEmail(String email)throws Exception {
		Connection connection = ConnectionFactory.openConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from usuario where email = ?");
		preparedStatement.setString(1, email);
		//quando for pesquisa utiliza se resultSet
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Usuario usuario = null;
		if(resultSet.next()) {
			usuario = new Usuario();
			
			usuario.setIdUsuario(resultSet.getInt("idUsuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));
						
		}
		connection.close();
		return usuario;
	}
	
	//
	public Usuario findByEmailAndSenha(String email, String senha)throws Exception {
		Connection connection = ConnectionFactory.openConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from usuario where email = ? and senha = md5(?)");
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, senha);
		//quando for pesquisa utiliza se resultSet
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Usuario usuario = null;
		if(resultSet.next()) {
			usuario = new Usuario();
			
			usuario.setIdUsuario(resultSet.getInt("idUsuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));
						
		}
		connection.close();
		return usuario;
		
	}
}
