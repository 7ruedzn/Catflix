package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;

import com.google.gson.JsonSyntaxException;

import Dados.Filme;
import Dados.ListaFilmes;
import Dados.Tmdb;
import Dados.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaPesquisa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void pesquisa(ListaFilmes movieList, Usuario user, Tmdb tmdb) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPesquisa frame = new TelaPesquisa(movieList, user, tmdb);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TelaPesquisa(ListaFilmes movieList, Usuario user, Tmdb tmdb) throws JsonSyntaxException, IOException, JSONException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pesquisar Filme");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(377, 140, 239, 75);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(321, 225, 375, 51);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tmdb.searchMovie(textField.getText(), movieList) == true) {
					Filme filme = new Filme();
					for(int i = 0; i < movieList.getMovieList().size(); i++) {
						if(movieList.getMovieList().get(i).getTitle().equals(textField.getText())) {
							filme = movieList.getMovieList().get(i);
						}
					}
					try {
						new TelaDadosFilme(filme, movieList, user, tmdb).setVisible(true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Falha ao encontrar o filme" ,"Filme não encontrado!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(427, 302, 152, 39);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaPrincipal(movieList, user, tmdb).setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(37, 479, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
