package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;
import model.Usuario;
import model.Veiculo;

public class UsuarioDAO {
	private final Connection conexao;
	
	public UsuarioDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	protected PreparedStatement comandoSQL(String sql) throws SQLException {
		PreparedStatement statement = conexao.prepareStatement(sql);
		return statement;
	}
	
	public void cadastrarUsuario(Usuario usuario) throws SQLException {
		String sql = "insert into usuario (nome, senha) values (?, ?)";
		
		PreparedStatement statement = comandoSQL(sql);
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getSenha());
		statement.execute();
	};
	
	public void cadastrarCliente(Cliente cliente) throws SQLException {
		String sql = "insert into cliente (nome, sexo, telefone) values (?, ?, ?)";
		
		PreparedStatement statement = comandoSQL(sql);
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getSexo());
		statement.setInt(3, cliente.getTelefone());
		statement.execute();
	} 
	
	public void atualizarCliente(Cliente cliente) throws SQLException {
		String sql = "update usuario set nome = ?, sexo = ?, telefone = ?";
		
		PreparedStatement statement = comandoSQL(sql);
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getSexo());
		statement.setInt(3, cliente.getTelefone());
		statement.execute();
	}
	
	public void deletarCliente(Cliente cliente) throws SQLException {
		String sql = "delete from cliente where id = ?";
		
		PreparedStatement statement = comandoSQL(sql);
		statement.setInt(1, cliente.getId());
		statement.execute();
	}
	
	public void cadastrarVeiculo(Cliente cliente, Veiculo veiculo) throws SQLException {
		String sql = "insert into veiculo (modelo, cor, placa, id_proprietario) values (?, ?, ?, ?)";
		PreparedStatement statement = comandoSQL(sql);
		
		statement.setString(1, veiculo.getModelo());
		statement.setString(2, veiculo.getCor());
		statement.setString(3, veiculo.getPlaca());
		statement.setInt(4, cliente.getId());
		statement.execute();
	}
	
	public void atualizarVeiculo(Veiculo veiculo) throws SQLException {
		String sql = "update veiculo set modelo = ?, cor = ?, placa = ?";
		
		PreparedStatement statement = comandoSQL(sql);
		statement.setString(1, veiculo.getModelo());
		statement.setString(2, veiculo.getCor());
		statement.setString(3, veiculo.getPlaca());
		statement.execute();
	}
	
	public void deletarVeiculo (Veiculo veiculo) throws SQLException {
		String sql = "delete from veiculo where id = ?";
		
		PreparedStatement statement = comandoSQL(sql);
		statement.setInt(1, veiculo.getId());
		statement.execute();
	}

	public boolean existeUsuario(Usuario usuario) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
