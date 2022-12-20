package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField LtxtUsuario;
	private JPasswordField LpassSenha;
	private LoginController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		controller = new LoginController(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LtxtUsuario = new JTextField();
		LtxtUsuario.setBounds(146, 64, 142, 20);
		contentPane.add(LtxtUsuario);
		LtxtUsuario.setColumns(10);
		
		LpassSenha = new JPasswordField();
		LpassSenha.setBounds(146, 120, 142, 20);
		contentPane.add(LpassSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.validarUsuario();
			}
		});
		btnEntrar.setBounds(169, 165, 95, 23);
		contentPane.add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setBounds(146, 95, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setBounds(146, 39, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.telaUserCadastro();
			}
		});
		btnCadastrar.setBounds(169, 199, 95, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(41, 11, 63, 31);
		contentPane.add(lblNewLabel_2);
	}
	
	public JPasswordField getSenha() {
		return LpassSenha;
	}	
	
	public void setSenha(JPasswordField passSenha) {
		this.LpassSenha = passSenha;
	}
	
	public JTextField getUser() {
		return LtxtUsuario;
	}	
	
	public void setUser(JTextField txtUsuario) {
		this.LtxtUsuario = txtUsuario;
	}
}
