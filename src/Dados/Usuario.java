package Dados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Usuario {
    private String login;
    private String senha;
    private ArrayList<String> reviews;
    private ArrayList<String> listaInteresses;
    private ArrayList<String> listaAssistidos;

    Usuario(){
    	this.reviews = new ArrayList<String>();
    	this.listaInteresses = new ArrayList<String>();
    	this.listaAssistidos = new ArrayList<String>();
    	this.loadListaAssistidos();
    	this.loadListaInteresses();
    	this.loadReviewsByUser();
    }
    
    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
        this.reviews = new ArrayList<String>();
    	this.listaInteresses = new ArrayList<String>();
    	this.listaAssistidos = new ArrayList<String>();
    }
    public void loadReviewsByUser() {
    	try {
    		String filename = this.login + " Reviews.txt";
    		//System.out.println(filename);
    		FileInputStream in = new FileInputStream(filename);
    		BufferedReader br = new BufferedReader(new InputStreamReader(in));
    		String strLine;
    		
    		while((strLine = br.readLine()) != null ){
    				this.reviews.add(strLine);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void saveUserInteressesTxt(String txtName, String movieName) {
		File file = new File(txtName);
		String reviews = "";
		String conteudo;
		
		try {
			FileWriter fw = new FileWriter(file, true);
				reviews = movieName;
				conteudo = reviews;
				conteudo += "\r\n";
				fw.write(conteudo);
				fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void saveUserReviewTxt(String txtName, String review) {
		File file = new File(txtName);
		String reviews = "";
		String conteudo;
		
		try {
			FileWriter fw = new FileWriter(file, true);
				reviews = review;
				conteudo = reviews;
				conteudo += "\r\n";
				fw.write(conteudo);
				fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void saveUserAssistidosTxt(String txtName, String movieName) {
		File file = new File(txtName);
		String reviews = "";
		String conteudo;
		
		try {
			FileWriter fw = new FileWriter(file, true);
				reviews = movieName;
				conteudo = reviews;
				conteudo += "\r\n";
				fw.write(conteudo);
				fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void loadListaAssistidos() {
    	try {
    		String filename = this.login + " ListaAssistidos.txt";
    		//System.out.println(filename);
    		FileInputStream in = new FileInputStream(filename);
    		BufferedReader br = new BufferedReader(new InputStreamReader(in));
    		String strLine;
    		
    		while((strLine = br.readLine()) != null ){
    				this.listaAssistidos.add(strLine);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void loadListaInteresses() {
    	try {
    		String filename = this.login + " ListaInteresses.txt";
    		//System.out.println(filename);
    		FileInputStream in = new FileInputStream(filename);
    		BufferedReader br = new BufferedReader(new InputStreamReader(in));
    		String strLine;
    		
    		while((strLine = br.readLine()) != null ){
    				this.listaInteresses.add(strLine);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }

    public void addReview(String Review){
    	this.reviews.add(Review);
    }

    public void addIntereses(String nome){
    	this.listaInteresses.add(nome);
    }

    public void addAssistidos(String nome){
    	this.listaAssistidos.add(nome);
    }
    
    public void cadastrar() {
		try {
			String conteudo = "";
			FileWriter fw = new FileWriter("users.txt", true);
			conteudo += this.login;
			conteudo += " ";
			conteudo += this.senha;
			conteudo += "\r\n";
			fw.write(conteudo);
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

    

    public ArrayList<String> mostrarInteresses(){
        return this.listaInteresses;
    }

    public ArrayList<String> mostrarAssistidos(){
        return this.listaAssistidos;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }

    

    

    public ArrayList<String> getLista_interesses() {
        return listaInteresses;
    }

    public void setLista_interesses(ArrayList<String> lista_interesses) {
        this.listaInteresses = lista_interesses;
    }

    public ArrayList<String> getLista_assistidos() {
        return listaAssistidos;
    }

    public void setLista_assistidos(ArrayList<String> lista_assistidos) {
        this.listaAssistidos = lista_assistidos;
    }

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", senha=" + senha + ", reviews=" + reviews + ", lista_reviews_fav="
				+ ", lista_interesses=" + listaInteresses + ", lista_assistidos="
				+ listaAssistidos + "]";
	}   
}