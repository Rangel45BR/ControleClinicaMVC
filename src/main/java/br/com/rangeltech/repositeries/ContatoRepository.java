package br.com.rangeltech.repositeries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import br.com.rangeltech.entities.Contato;
import br.com.rangeltech.factories.ConnectionFactory;

public class ContatoRepository {

	// método para cadastrar contato
		public void create(Contato contato) throws Exception {

			// abrindo conexão com o banco de dados
			Connection connection = ConnectionFactory.openConnection();

			// executando o comando SQL no banco de dados
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into contato(nome, telefone, email, datanasc, idusuario) values(?,?,?,?,?)");

			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getTelefone());
			preparedStatement.setString(3, contato.getEmail());
			preparedStatement.setDate(4, java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(contato.getDataNasc())));
			preparedStatement.setInt(5, contato.getUsuario().getIdUsuario());
			preparedStatement.execute();
			
			//fechando a conexão
			connection.close();
		}
	
	
	
	
	
}
