package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dados.Usuario;

import javax.swing.JLabel;
import java.awt.Font;

public class TelaAssistidosInteresses extends JFrame {

	private JPanel contentPane;

	public static void assistidosInteresses(Usuario user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAssistidosInteresses frame = new TelaAssistidosInteresses(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaAssistidosInteresses(Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de filmes assistidos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(21, 40, 280, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lista de filmes de interesse:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(21, 229, 308, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel listaAssistidos = new JLabel(user.getLista_assistidos().toString());
		listaAssistidos.setFont(new Font("Tahoma", Font.PLAIN, 23));
		listaAssistidos.setBounds(335, 45, 577, 34);
		contentPane.add(listaAssistidos);
		
		JLabel listaInteresse = new JLabel(user.getLista_interesses().toString());
		listaInteresse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		listaInteresse.setBounds(335, 233, 573, 34);
		contentPane.add(listaInteresse);
		
		//System.out.println(user.toString());
	}
}
