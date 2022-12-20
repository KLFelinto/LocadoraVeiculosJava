package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CadastroController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CadastroView extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passSenha;
	private CadastroController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroView frame = new CadastroView();
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
	public CadastroView() {
		controller = new CadastroController(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setBounds(146, 39, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(146, 64, 142, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(146, 95, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		passSenha = new JPasswordField();
		passSenha.setBounds(146, 120, 142, 20);
		contentPane.add(passSenha);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastrarUsuario();
			}
		});
		btnSalvar.setBounds(169, 165, 95, 23);
		contentPane.add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.voltar();
			}
		});
		btnVoltar.setBounds(169, 198, 95, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_2 = new JLabel("CADASTRO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(26, 11, 95, 31);
		contentPane.add(lblNewLabel_2);
	}
	
	public JPasswordField getSenha() {
		return passSenha;
	}	
	
	public void setSenha(JPasswordField passSenha) {
		this.passSenha = passSenha;
	}
	
	public JTextField getUser() {
		return txtUsuario;
	}	
	
	public void setUser(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}
	
}
