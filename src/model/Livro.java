package model;

public class Livro {
    private static int contadorID = 0; // Contador para gerar IDs únicos
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacao;

    public Livro(String titulo, String autor, int anoPublicacao) {
        this.id = ++contadorID; // ID único
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", Ano: " + anoPublicacao;
    }
}
