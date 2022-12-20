package controller;

import view.CadastroView;
import view.LoginView;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.ConexaoSingleton;
import dao.UsuarioDAO;
import model.Usuario;

public class CadastroController {
	private CadastroView view;
	
	public CadastroController(CadastroView view) {
		this.view = view;
	}
	
	@SuppressWarnings("deprecation")
	public void cadastrarUsuario() {
		String nomeUsuario = view.getUser().getText();
		String senha = view.getSenha().getText();
		Usuario novoUsuario = new Usuario(nomeUsuario, senha);
		
		try {
			ConexaoSingleton conSing = ConexaoSingleton.getInstancy();
			Connection conexao = conSing.getConnection();
			UsuarioDAO userDAO = new UsuarioDAO(conexao);
			userDAO.cadastrarUsuario(novoUsuario);
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
			voltar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void voltar() {
		LoginView voltar = new LoginView();
		view.dispose();
		voltar.setVisible(true);
	}
}
