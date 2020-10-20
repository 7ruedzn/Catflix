package Dados;

import java.util.ArrayList;
import java.util.List;

public class ListaFilmes {
	private ArrayList<Filme> movieList;
	
	ListaFilmes(){
		this.movieList = new ArrayList<Filme>();
	}

	public ArrayList<Filme> getMovieList() {
		return movieList;
	}

	public void setMovieList(ArrayList<Filme> movieList) {
		this.movieList = movieList;
	}

	@Override
	public String toString() {
		return "ListaFilmes [movieList=" + movieList + "]";
	}
	
	

}
