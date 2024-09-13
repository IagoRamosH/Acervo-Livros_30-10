package com.livraria.service;

import com.livraria.model.Livro;
import java.util.ArrayList;
import java.util.List;

public class AcervoService {
    private ArrayList<Livro> livros;

    public AcervoService() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    // Método para buscar livro por título
    public List<Livro> buscarLivroPorTitulo(String titulo) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    // Método para buscar livro por autor
    public List<Livro> buscarLivroPorAutor(String autor) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    // Método para buscar livro por ano de publicação
    public List<Livro> buscarLivroPorAno(int anoPublicacao) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAnoPublicacao() == anoPublicacao) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }
}
