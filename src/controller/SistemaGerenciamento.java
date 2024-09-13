package controller;

import com.livraria.model.Livro;

import util.AlgoritmoOrdenacao;

public class SistemaGerenciamento {
    private Biblioteca biblioteca;

    public SistemaGerenciamento(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        Livro livro = new Livro(titulo, autor, anoPublicacao);
        biblioteca.adicionarLivro(livro);
    }

    public Livro[] listarLivros() {
        return biblioteca.listarLivros();
    }

    public void ordenarLivrosPorTitulo() {
        AlgoritmoOrdenacao.bubbleSortPorTitulo(biblioteca.listarLivros(), biblioteca.getContador());
    }

    public void ordenarLivrosPorAutor() {
        AlgoritmoOrdenacao.quickSortPorAutor(biblioteca.listarLivros(), 0, biblioteca.getContador() - 1);
    }

    public Livro buscarLivroPorId(int id) {
        return biblioteca.buscarPorId(id);
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        return biblioteca.buscarPorTitulo(titulo);
    }

    public Livro buscarLivroPorAutor(String autor) {
        return biblioteca.buscarPorAutor(autor);
    }

    public Livro[] buscarLivroPorAno(int ano) {
        return biblioteca.buscarPorAno(ano);
    }
}
