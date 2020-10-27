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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;

public class TelaSobreDesenvolvedores extends JFrame {

	private JPanel contentPane;

	public static void main(ListaFilmes movieList, Usuario user, Tmdb tmdb) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobreDesenvolvedores frame = new TelaSobreDesenvolvedores(movieList, user, tmdb);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaSobreDesenvolvedores(ListaFilmes movieList, Usuario user, Tmdb tmdb) {
		setBackground(new Color(139, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1079, 636);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaPrincipal(movieList, user, tmdb).setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(23, 542, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("CATFLIX");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(373, -30, 602, 144);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Catflix foi um projeto desenvolvido com o <br>intúito dos usuários poderem pesquisar <br>sobre os filmes desejados e encontrar <br>reviews sobre determinado filme.</html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(53, 113, 922, 309);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html>Desenvolvido por Vinícius Queiroz e Mariana Rufino</html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(147, 433, 804, 75);
		contentPane.add(lblNewLabel_2);
	}
}
