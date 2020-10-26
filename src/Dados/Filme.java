package Dados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filme implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String overview;
    private int id;
    private ArrayList<String> reviews;
    private String vote_average;
    private String release_date;
    private List<Filme> results;
    private String poster_path;
    
    public Filme() {
    	this.reviews = new ArrayList<String>();
    	loadMovieReviews();
    }
    
    public Filme(String title, String overview, int id, ArrayList<String> reviews,
			String vote_average, String release_date, List<Filme> results, String poster_path) {
		super();
		this.title = title;
		this.overview = overview;
		this.id = id;
		this.reviews = reviews;
		this.vote_average = vote_average;
		this.release_date = release_date;	
		this.results = results;
		this.poster_path = poster_path;
	}
    
    public void saveReviewsTxt(String txtName, String review) {
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
    
    public void loadMovieReviews() {
    	try {
    		String filename = this.getTitle() + " Reviews.txt";
    		FileInputStream in = new FileInputStream(filename);
    		BufferedReader br = new BufferedReader(new InputStreamReader(in));
    		String strLine;
    		
    		while((strLine = br.readLine()) != null ){
    				this.reviews.add(strLine);
    		}
    	}catch(Exception e) {
    		
    	}
    }
    
    public String getImage() {
    	return "https://image.tmdb.org/t/p/w300"+this.poster_path;
    }
    
    public void addReview(String review) {
    	this.reviews.add(review);
    }
    
    public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
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

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public ArrayList<String> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }

    public String toString() {
        return 
        		"nome:" + this.title 
        		+ "\nsinopse: "+this.overview 
        		+"\nid: "+this.id
        		+"\nnota: "+this.vote_average
        		+"\nPoster: "+this.poster_path
        		+"\nReviews: "+this.reviews
        		+"\nData de lancamento: "+this.release_date;
    }
    
}