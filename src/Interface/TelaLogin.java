package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dados.Filme;
import Dados.ListaFilmes;
import Dados.Tmdb;
import Dados.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.HeadlessException;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txt2;
	private JTextField txt1;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(ListaFilmes movieList, Tmdb tmdb) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin(movieList, tmdb);
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
	public TelaLogin(ListaFilmes movieList, Tmdb tmdb) {
		getContentPane().setLayout(null);
		
		txt2 = new JTextField();
		txt2.setBounds(109, 143, 209, 20);
		getContentPane().add(txt2);
		txt2.setColumns(10);
		
		JButton logar = new JButton("LOGAR");
		logar.setBounds(171, 201, 89, 23);
		getContentPane().add(logar);
		
		txt1 = new JTextField();
		txt1.setBounds(109, 89, 209, 20);
		getContentPane().add(txt1);
		txt1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(109, 64, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(109, 118, 46, 14);
		getContentPane().add(lblNewLabel_1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Button LOGAR
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Realizar o cast para String quando utilizar Password;
				try {
					if(checkLogin(txtLogin.getText(), new String(txtPassword.getPassword()))) {
						Usuario user = new Usuario(txtLogin.getText(), new String(txtPassword.getPassword()));
						createUserTxts(user);
						new TelaPrincipal(movieList, user, tmdb).setVisible(true);
						JOptionPane.showMessageDialog(null, "Logado com sucesso!");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Falha ao logar", "ERRO AO LOGAR", JOptionPane.ERROR_MESSAGE);
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnLogar.setBounds(171, 210, 89, 23);
		contentPane.add(btnLogar);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(129, 103, 177, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel1 = new JLabel("Login");
		lblNewLabel1.setBounds(198, 78, 46, 14);
		contentPane.add(lblNewLabel1);
		
		JLabel lblNewLabel_11 = new JLabel("Senha");
		lblNewLabel_11.setBounds(198, 134, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(129, 166, 177, 20);
		contentPane.add(txtPassword);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(159, 14, 101, 53);
		contentPane.add(lblNewLabel_2);
	}
	
	public boolean checkLogin(String login, String senha) throws IOException {
		boolean result = false;
		String filename = "users.txt";
		FileInputStream in = new FileInputStream(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		int val = 0;
		
		while((strLine = br.readLine()) != null ){
			String[] split = strLine.split("\\s");
				if(login.equals(split[0]) && senha.equals(split[1])) {
					result = true;
				}
		}
		return result;
	}
	
	public void createUserTxts(Usuario user) {
		//txt de reviews
			try {
				String filename = user.getLogin() + " Reviews.txt";
				File file = new File(filename);
				file.createNewFile();
	    		System.out.println(filename);
	    		FileInputStream in = new FileInputStream(filename);
	    		BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    		String strLine;
	    		
	    		while((strLine = br.readLine()) != null ){
	    				user.addReview(strLine);
	    		}
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
			
			//cria o txt de interesse
			
			try {
				String filename = user.getLogin() + " ListaInteresses.txt";
				File file = new File(filename);
				file.createNewFile();
	    		System.out.println(filename);
	    		FileInputStream in = new FileInputStream(filename);
	    		BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    		String strLine;
	    		
	    		while((strLine = br.readLine()) != null ){
	    				user.addIntereses(strLine);
	    		}
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
			
			//Adicionar Lista Assistidos
			
			
			try {
				String filename = user.getLogin() + " ListaAssistidos.txt";
				File file = new File(filename);
				file.createNewFile();
	    		System.out.println(filename);
	    		FileInputStream in = new FileInputStream(filename);
	    		BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    		String strLine;
	    		
	    		while((strLine = br.readLine()) != null ){
	    				user.addAssistidos(strLine);
	    		}
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
			
			
	}
	
}
