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
	
	//JSON com pagina 1 de filmes;
	//Pega informação de um filme passando Id e tipo do filme;
	
	/*Fazer ->
	 * Lista com todos os filmes da página do JSON;
	 * Procurar filme passando nome dele, caso encontrado mostrar os dados do filme;
	 * 
	 */

	public static void main(String[] args) throws Exception, JsonParseException, com.fasterxml.jackson.core.JsonParseException{
		String API_KEY = "67c58c93f9c117b5d318aefade12d87f";
	    String API_BASE = "https://api.themoviedb.org/3";
	    String API_MOVIE = "/movie/top_rated?api_key=";
	    ArrayList<Filme> filmes = new ArrayList<Filme>();
		URL url = new URL(API_BASE+API_MOVIE+API_KEY);
		URLConnection connection = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String json;

		
		//printa o JSON com o resultado de todos os filmes da pagina 1;
		while ((json = in.readLine()) != null ) {
			Filme filme = new Gson().fromJson(json, Filme.class);
			filmes.add(filme);
			System.out.println(json);
		}
		in.close();
		
		//Adicionando alguns filmes aleatórios na lista de filmes
		//Precisa automatizar criando todos os objetos a partir do JSON lido;
		//Gson gson = new Gson();
		//ListaFilmes listaFilmes = gson.fromJson(json, ListaFilmes.class);
		//List<Filme> list = listaFilmes.getMovieList();
		
		Filme filme2 = getMovieInfo("402", "movie");
		Filme filme3 = getMovieInfo("403", "movie");
		Filme filme4 = getMovieInfo("550", "movie");
		
		//Printa os dados de um filme;
		System.out.println("Filme 2: "+filme2.toString());
		
		ArrayList<Filme> listaFilmes = getMovieList();
		for(int i = 0; i < listaFilmes.size(); i++) {
			System.out.println("listFilmes["+i+"]= "+listaFilmes.get(i));
			System.out.println();
		}
		
		//Função de procurar filme que retorna 'true or false' caso encontre ou não o filme;
		
		System.out.println("\n------- Procurando filme ------");
		if(searchMovie("The Dark Knight", listaFilmes) == true) {
			System.out.println("Filme encontrado!");
		}else {
			System.out.println("Filme não encontrado!");
		}
		
		System.out.println("\n----------Lista de Filmes-------------");
		
		
	}
	
	public static Filme getMovieInfo(String movieId, String type) throws JsonSyntaxException, IOException {
		String API_KEY = "67c58c93f9c117b5d318aefade12d87f";
		String API_BASE = "https://api.themoviedb.org/3";
		Filme filme = new Filme();
		String inputLine;
		String dados = ""; 
		
		switch(type) {
		case "movie":
			String url_movie = "/movie/"+movieId+"?&api_key="+API_KEY;
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
	
	public static ArrayList<Filme> getMovieList() throws JsonSyntaxException, IOException, JSONException {
		String API_KEY = "67c58c93f9c117b5d318aefade12d87f";
	    String API_BASE = "https://api.themoviedb.org/3";
	    String API_MOVIE = "/movie/top_rated?api_key=";
	    ArrayList<Filme> movieList = new ArrayList<Filme>();
		URL url = new URL(API_BASE+API_MOVIE+API_KEY);
		URLConnection yc = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;
		String dados = "";
		while ((inputLine = in.readLine()) != null ) {
			dados += inputLine;
		}
		
		JSONObject obj = null;
		obj = new JSONObject(dados.toString());
		JSONArray jArray = obj.getJSONArray("results");
		for(int i = 0; i < jArray.length(); i++) {
			JSONObject o = jArray.getJSONObject(i);
			Filme filme1 = new Gson().fromJson(o.toString(), Filme.class);
			movieList.add(filme1);
		}
		return movieList;
	}
	
	public static boolean searchMovie(String nome, ArrayList<Filme> movieList) {
		boolean res = false;
		for(int i = 0; i < movieList.size(); i++) {
			if(nome.equals(movieList.get(i).getTitle())) {
				System.out.println(movieList.get(i).toString());
				res = true;
			}
		}
		return res;
	}
}