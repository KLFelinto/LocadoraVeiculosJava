package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class BancoProxy extends UsuarioDAO {
	protected Connection conexao;
	
	public BancoProxy(Connection conexao) {
		super(conexao);
		this.conexao = conexao;
	}
	
	@Override
	public boolean existeUsuario(Usuario usuario) throws SQLException {
		String sql = "select * from usuario where nome = ? and senha = ?";
		
		PreparedStatement statement = comandoSQL(sql);
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getSenha());
		statement.execute();
		
		ResultSet resultSet = statement.getResultSet();
		return resultSet.next();
	}
}
