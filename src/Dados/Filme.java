package Dados;

import java.util.ArrayList;
import java.util.List;

public class Filme {
	private String title;
	private String overview;
    private List<Filme> genres;
    private int id;
    private String name;
    private ArrayList<String> reviews;
    private String vote_average;
    private String release_date;
    private List<Filme> results;
    
    public Filme() {
    	
    }
    
    public Filme(String title, String overview, List<Filme> genres, int id, String name, ArrayList<String> reviews,
			String vote_average, String release_date, List<Filme> results) {
		super();
		this.title = title;
		this.overview = overview;
		this.genres = genres;
		this.id = id;
		this.name = name;
		this.reviews = reviews;
		this.vote_average = vote_average;
		this.release_date = release_date;	
		this.results = results;
	}
    
    public List<Filme> getResults() {
		return results;
	}

	public void setResults(List<Filme> results) {
		this.results = results;
	}

	public String getRelease_date() {
    	return this.release_date;
    }
    
    public void setRelease_date(String release_date) {
    	this.release_date = release_date;
    }

	public String getVote_average() {
		return vote_average;
	}

	public void setVote_average(String vote_average) {
		this.vote_average = vote_average;
	}

	public String getTitle() {
		return title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}


	public void setGenres(List<Filme> genres) {
		this.genres = genres;
	}
	
	public List<Filme> getGenres() {
		return this.genres;
	}

	public ArrayList<String> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return 
        		"\nnome:" + this.title 
        		+ "\nsinopse: "+this.overview 
        		/*
        		 * + "\ngeneros: "+this.genres arrumar para conseguir pegar os generos, 
        		 * apesar de passar do JSON ter apenas o id;
        		 */
        		+"\nid: "+this.id
        		+"\nnota: "+this.vote_average
        		+"\nData de lançamento: "+this.release_date;
    }
}

