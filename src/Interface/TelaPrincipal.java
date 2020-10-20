package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;

import com.google.gson.JsonSyntaxException;

import Dados.Filme;
import Dados.Tmdb;

import javax.swing.JLabel;
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

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws JSONException 
	 * @throws IOException 
	 * @throws JsonSyntaxException 
	 */
	public TelaPrincipal() throws JsonSyntaxException, IOException, JSONException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pesquisar Filme");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(377, 140, 239, 75);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(321, 225, 375, 51);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//Cria a lista de filmes;
		ArrayList<Filme> listaFilmes = Tmdb.getMovieList();
		//Cria o arquivo que vai armazenar os estados da classe filme;
		Tmdb.saveMovieStateFile("MoviesState.txt", listaFilmes);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Tmdb.searchMovie(textField.getText(), listaFilmes) == true) {
					Filme filme = new Filme();
					for(int i = 0; i < listaFilmes.size(); i++) {
						if(listaFilmes.get(i).getTitle().equals(textField.getText())) {
							filme = listaFilmes.get(i);
						}
					}
					try {
						new TelaDadosFilme(filme, listaFilmes).setVisible(true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					dispose();
				}
				
			}
		});
		btnNewButton.setBounds(427, 302, 152, 39);
		contentPane.add(btnNewButton);
	}
}
