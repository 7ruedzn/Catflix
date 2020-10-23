package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;

import com.google.gson.JsonSyntaxException;

import Dados.ListaFilmes;
import Dados.Tmdb;
import Dados.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void principal(ListaFilmes movieList, Usuario user, Tmdb tmdb) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal(movieList, user, tmdb);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TelaPrincipal(ListaFilmes movieList, Usuario user, Tmdb tmdb) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1076, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Sobre Desenvolvedores");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(111, 321, 184, 69);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pesquisar Filme");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new TelaPesquisa(movieList, user, tmdb).setVisible(true);
				} catch (JsonSyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton_1.setBounds(333, 321, 328, 69);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ver lista de Interesses, filmes assistidos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaAssistidosInteresses(user).setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(700, 321, 271, 69);
		contentPane.add(btnNewButton_2);
	}
}