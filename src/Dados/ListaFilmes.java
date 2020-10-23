package Dados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaFilmes implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Filme> movieList;
	
	public ListaFilmes(){
		this.movieList = new ArrayList<Filme>();
	}
	
	public void addFilme(Filme filme) {
		this.movieList.add(filme);
	}

	public ArrayList<Filme> getMovieList() {
		return movieList;
	}

	public void setMovieList(ArrayList<Filme> movieList) {
		this.movieList = movieList;
	}
	
	//Cria e carrega os txt que armazenam os reviews de que cada filme.
	public void createNLoadMoviesReviews() {
		for(Filme filme : movieList) {
			try {
				String filename = filme.getTitle() + " Reviews.txt";
				File file = new File(filename);
				file.createNewFile();
	    		FileInputStream in = new FileInputStream(filename);
	    		BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    		String strLine;
	    		
	    		while((strLine = br.readLine()) != null ){
	    				filme.addReview(strLine);
	    		}
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
		}
	}

	@Override
	public String toString() {
		return "ListaFilmes [movieList=" + movieList + "]";
	}
	
	

}
