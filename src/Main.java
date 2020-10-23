import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import com.google.gson.JsonSyntaxException;
import Dados.Filme;
import Dados.ListaFilmes;
import Dados.Tmdb;
import Interface.TelaCadastro;
import Interface.TelaPesquisa;
import Interface.TelaPrincipal;

public class Main {

	public static void main(String[] args) throws JsonSyntaxException, IOException, JSONException {
		Tmdb tmdb = new Tmdb();
		ListaFilmes movieList = new ListaFilmes();
		movieList.setMovieList(tmdb.getMovieList());//Essa lista recebe os filmes;
		movieList.createNLoadMoviesReviews();
		TelaCadastro.main(movieList, tmdb);
	}
}