package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dados.Filme;
import Dados.ListaFilmes;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDadosFilme extends JFrame {

	private JPanel container;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void NewScreen(Filme filme, ArrayList<Filme> movieList) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDadosFilme frame = new TelaDadosFilme(filme, movieList);
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
	public TelaDadosFilme(Filme filme, ArrayList<Filme> movieList) throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 649);
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(container);
		container.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(309, 13, 98, 34);
		container.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("overview:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(309, 71, 148, 34);
		container.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("release date:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(309, 122, 199, 43);
		container.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(filme.getTitle());
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(378, 1, 434, 59);
		container.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(filme.getOverview());
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(402, 26, 516, 129);
		container.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel(filme.getRelease_date());
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(439, 126, 257, 34);
		container.add(lblNewLabel_7);
		
		URL url = new URL(filme.getImage());
		Image image = ImageIO.read(url).getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon(image));
		lblNewLabel_2.setBounds(34, 26, 248, 270);
		container.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("Reviews");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_6.setBounds(383, 242, 125, 67);
		container.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(10, 414, 970, 122);
		container.add(textField);
		textField.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(973, 1, 17, 586);
		container.add(scrollBar);
		
		JButton btnNewButton = new JButton("Enviar Review");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filme.addReview(textField.getText());
				System.out.println("Dados do filme +"+filme.toString());
			}
		});
		btnNewButton.setBounds(378, 547, 164, 23);
		container.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel(filme.getReviews().toString());
		lblNewLabel_8.setBounds(10, 307, 970, 102);
		container.add(lblNewLabel_8);
	}
}
