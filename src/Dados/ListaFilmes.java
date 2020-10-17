package Dados;

import java.util.ArrayList;
import java.util.List;

public class ListaFilmes {
	private List<Filme> movieList;

	public List<Filme> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Filme> movieList) {
		this.movieList = movieList;
	}

	@Override
	public String toString() {
		return "ListaFilmes [movieList=" + movieList + "]";
	}
	
	

}
