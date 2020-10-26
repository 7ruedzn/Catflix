package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaDadosFilme extends JFrame {

	private JPanel container;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void NewScreen(Filme filme, ListaFilmes movieList, Usuario user, Tmdb tmdb) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final TelaDadosFilme frame = new TelaDadosFilme(filme, movieList, user, tmdb);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public TelaDadosFilme(Filme filme, ListaFilmes movieList, Usuario user, Tmdb tmdb) throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 649);
		container = new JPanel();
		container.setForeground(Color.WHITE);
		container.setBackground(new Color(139, 0, 0));
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(container);
		container.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(292, 16, 98, 34);
		container.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Resumo:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(292, 71, 148, 34);
		container.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Data de Lançamento:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(292, 141, 199, 43);
		container.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(filme.getTitle());
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(354, 6, 434, 59);
		container.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(filme.getOverview());
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(378, 24, 516, 129);
		container.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel(filme.getRelease_date());
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(501, 145, 257, 34);
		container.add(lblNewLabel_7);
		
		URL url = new URL(filme.getImage());
		Image image = ImageIO.read(url).getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon(image));
		lblNewLabel_2.setBounds(34, 26, 248, 270);
		container.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("Reviews");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_6.setBounds(383, 242, 125, 67);
		container.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(10, 438, 970, 122);
		container.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar Review");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filme.addReview(textField.getText());
				filme.saveReviewsTxt(filme.getTitle()+" Reviews.txt", textField.getText());
				user.addReview(textField.getText());
				user.saveUserReviewTxt(user.getLogin()+" Reviews.txt", textField.getText());
				//System.out.println("Dados do filme +"+filme.toString());
				getContentPane().repaint();
			}
		});
		
		btnNewButton.setBounds(378, 564, 199, 23);
		container.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel(filme.getReviews().toString());
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(10, 295, 953, 102);
		container.add(lblNewLabel_8);
		
		JButton buttonAssistidos = new JButton("Adicionar Lista Assistidos");
		buttonAssistidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user.addAssistidos(filme.getTitle());
				user.saveUserAssistidosTxt(user.getLogin()+" ListaAssistidos.txt", filme.getTitle());
				//System.out.println(user.getLista_assistidos());
			}
		});
		buttonAssistidos.setBounds(498, 404, 212, 23);
		container.add(buttonAssistidos);
		
		JButton buttonInteresses = new JButton("Adicionar a Lista de Interesses");
		buttonInteresses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.addIntereses(filme.getTitle());
				user.saveUserInteressesTxt(user.getLogin()+" ListaInteresses.txt", filme.getTitle());
			}
		});
		buttonInteresses.setBounds(732, 404, 248, 23);
		container.add(buttonInteresses);
		
		JButton btnNewButton_1 = new JButton("Voltar");
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
		btnNewButton_1.setBounds(10, 564, 89, 23);
		container.add(btnNewButton_1);
	}
}
