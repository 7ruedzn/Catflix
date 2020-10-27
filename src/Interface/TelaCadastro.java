package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dados.ListaFilmes;
import Dados.Tmdb;
import Dados.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(ListaFilmes movieList, Tmdb tmdb) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro(movieList, tmdb);
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
	public TelaCadastro(ListaFilmes movieList, Tmdb tmdb) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 714);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(426, 11, 288, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Informe seu login:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(357, 113, 288, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Informe sua senha:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(350, 261, 303, 51);
		contentPane.add(lblNewLabel_2);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(357, 183, 288, 34);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(357, 323, 288, 33);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		//Button Cadastrar
		
		JButton btnNewButton = new JButton("Cadastrar-se");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario user = new Usuario(txtLogin.getText(), txtSenha.getText());
				user.cadastrar();
				new TelaLogin(movieList, tmdb).setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(387, 406, 217, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ja sou cadastrado");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaLogin(movieList, tmdb).setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(426, 451, 144, 23);
		contentPane.add(btnNewButton_1);
	}
}
