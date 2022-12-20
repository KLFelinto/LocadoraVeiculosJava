package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.DriverManager;

public class ConexaoSingleton {
	
	private String url = "jdbc:mysql://localhost:3306/locaveiculos?serverTimezone=UTC"; //Caminho do DB
	private String user = "root"; //Usuario
	private String password = ""; //Senha
	private static Connection conexao;
	private static ConexaoSingleton instancy;
	
	private ConexaoSingleton() {
		try {
			conexao = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public static ConexaoSingleton getInstancy() {
		if (instancy == null) {
			instancy = new ConexaoSingleton();
		}
		return instancy;
	}
	
	public Connection getConnection() {
		return conexao;
	}
}
