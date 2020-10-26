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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaAssistidosInteresses extends JFrame {

	private JPanel contentPane;

	public static void assistidosInteresses(Usuario user, ListaFilmes movieList, Tmdb tmdb) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAssistidosInteresses frame = new TelaAssistidosInteresses(user, movieList, tmdb);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaAssistidosInteresses(Usuario user, ListaFilmes movieList, Tmdb tmdb) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 514);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de filmes assistidos:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(21, 128, 280, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lista de filmes de interesse:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(21, 309, 308, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel listaAssistidos = new JLabel(user.getLista_assistidos().toString());
		listaAssistidos.setForeground(Color.WHITE);
		listaAssistidos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listaAssistidos.setBounds(311, 87, 897, 128);
		contentPane.add(listaAssistidos);
		
		JLabel listaInteresse = new JLabel(user.getLista_interesses().toString());
		listaInteresse.setForeground(Color.WHITE);
		listaInteresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listaInteresse.setBounds(333, 315, 573, 34);
		contentPane.add(listaInteresse);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaPrincipal(movieList, user, tmdb).setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(33, 423, 89, 23);
		contentPane.add(btnNewButton);
	}
}
