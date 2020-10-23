package Dados;

import java.net.*;
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.fasterxml.jackson.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.json.*;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Tmdb {
	private String API_KEY;
	private String API_BASE;
	private String API_MOVIE;
	
	public Tmdb(){
		this.API_KEY = "67c58c93f9c117b5d318aefade12d87f";
		this.API_BASE = "https://api.themoviedb.org/3";
		this.API_MOVIE = "/movie/top_rated?api_key=";
	}
	
	public String getAPI_KEY() {
		return API_KEY;
	}


	public void setAPI_KEY(String aPI_KEY) {
		API_KEY = aPI_KEY;
	}


	public String getAPI_BASE() {
		return API_BASE;
	}


	public void setAPI_BASE(String aPI_BASE) {
		API_BASE = aPI_BASE;
	}


	public String getAPI_MOVIE() {
		return API_MOVIE;
	}


	public void setAPI_MOVIE(String aPI_MOVIE) {
		API_MOVIE = aPI_MOVIE;
	}


	public String getJSON() throws Exception, JsonParseException, com.fasterxml.jackson.core.JsonParseException{
		URL url = new URL(this.API_BASE+this.API_MOVIE+this.API_KEY);
		URLConnection connection = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String json;

		//printa o JSON com o resultado de todos os filmes da pagina 1;
		while ((json = in.readLine()) != null ) {
			System.out.println(json);
		}
		in.close();
		return json;
	}
	
	public Filme getMovieInfo(String type, Filme movie) throws JsonSyntaxException, IOException {
		String API_KEY = "67c58c93f9c117b5d318aefade12d87f";
		String API_BASE = "https://api.themoviedb.org/3";
		Filme filme = new Filme();
		String inputLine;
		String dados = ""; 
		
		switch(type) {
		case "movie":
			String url_movie = "/movie/"+movie.getId()+"?&api_key="+API_KEY;
			URL url = new URL(API_BASE+url_movie);
			URLConnection yc = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			while ((inputLine = in.readLine()) != null ) {
				dados += inputLine;
				filme = new Gson().fromJson(dados, Filme.class);
			}
			break;
		default:
			break;
		}
		return filme;
	}

	//Retorna uma lista de filmes a partir da url do tmdb;
	public ArrayList<Filme> getMovieList() throws JsonSyntaxException, IOException, JSONException {
		String API_KEY = "67c58c93f9c117b5d318aefade12d87f";
	    String API_BASE = "https://api.themoviedb.org/3";
	    String API_MOVIE = "/movie/top_rated?api_key=";
	    ArrayList<Filme> movieList = new ArrayList<Filme>();
		URL url = new URL(API_BASE+API_MOVIE+API_KEY);
		URLConnection yc = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;
		String dados = "";
		//le o JSON e armazena tudo dentro de 'dados';
		while ((inputLine = in.readLine()) != null ) {
			dados += inputLine;
		}
		
		//obj recebe os dados do JSON lido acima;
		JSONObject obj = null;
		obj = new JSONObject(dados.toString());
		//Acessa o array "results" dentro de 'obj';
		JSONArray jArray = obj.getJSONArray("results");
		for(int i = 0; i < jArray.length(); i++) {
			JSONObject o = jArray.getJSONObject(i);
			//instancia um filme para cada elemento encontrado dentro de "results";
			Filme filme1 = new Gson().fromJson(o.toString(), Filme.class);
			//adiciona a uma lista de filmes e depois retorna ela;
			movieList.add(filme1);
		}
		return movieList;
	}
	
	//retorna true caso encontre o nome do filme dentro da lista de filmes;
	public boolean searchMovie(String nome, ListaFilmes movieList) {
		boolean res = false;
		for(int i = 0; i < movieList.getMovieList().size(); i++) {
			if(nome.equals(movieList.getMovieList().get(i).getTitle())) {
				System.out.println(movieList.getMovieList().get(i).toString());
				res = true;
			}
		}
		return res;
	}
}