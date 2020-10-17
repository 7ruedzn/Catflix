package Dados;

import java.util.ArrayList;

public class Usuario {
    private String login;
    private String senha;
    private ArrayList<String> reviews;
    private ArrayList<String> lista_reviews_fav;
    private ArrayList<Filme> lista_interesses;
    private ArrayList<Filme> lista_assistidos;

    Usuario(){

    }

    Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    public boolean procurarFilme(Filme nome){
        return true;
    }

    public void adicionarReview(String Review){

    }

    public void adicionarInteresses(){

    }

    public void adicionarAssistidos(){

    }

    public void favReview(){

    }

    public ArrayList<String> mostrarFav(){
        return this.lista_reviews_fav;
    }

    public ArrayList<Filme> mostrarInteresses(){
        return this.lista_interesses;
    }

    public ArrayList<Filme> mostrarAssistidos(){
        return this.lista_assistidos;
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

    public ArrayList<String> getLista_reviews_fav() {
        return lista_reviews_fav;
    }

    public void setLista_reviews_fav(ArrayList<String> lista_reviews_fav) {
        this.lista_reviews_fav = lista_reviews_fav;
    }

    public ArrayList<Filme> getLista_interesses() {
        return lista_interesses;
    }

    public void setLista_interesses(ArrayList<Filme> lista_interesses) {
        this.lista_interesses = lista_interesses;
    }

    public ArrayList<Filme> getLista_assistidos() {
        return lista_assistidos;
    }

    public void setLista_assistidos(ArrayList<Filme> lista_assistidos) {
        this.lista_assistidos = lista_assistidos;
    }
}

