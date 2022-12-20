package controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.BancoProxy;
import dao.ConexaoSingleton;
import dao.UsuarioDAO;
import model.Usuario;
import view.CadastroView;
import view.LoginView;
import view.MenuView;

public class LoginController {
	private LoginView view;
	
	public LoginController (LoginView view) {
		this.view = view;
	}
	
	@SuppressWarnings("deprecation")
	public void validarUsuario() {
		String nomeUsuario = view.getUser().getText();
		String senha = view.getSenha().getText();
		Usuario validarUsuario = new Usuario(nomeUsuario, senha);
		
		try {
			ConexaoSingleton conSing = ConexaoSingleton.getInstancy();
			Connection conexao = conSing.getConnection();
			UsuarioDAO userDAO = new BancoProxy(conexao);
			boolean existe = userDAO.existeUsuario(validarUsuario);
		
			if (existe) {
				telaMenu();
			} else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void telaUserCadastro() {	
		CadastroView telaCadastro = new CadastroView();
		view.dispose();
		telaCadastro.setVisible(true);
	}
	
	public void telaMenu () {
		MenuView telaMenu = new MenuView();
		view.dispose();
		telaMenu.setVisible(true);
	}
}
