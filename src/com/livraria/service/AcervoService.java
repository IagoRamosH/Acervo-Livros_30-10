package com.livraria.service;

import com.livraria.model.Livro;
import util.ArvoreBinariaBusca;
import java.util.ArrayList;
import java.util.List;

public class AcervoService {
    private ArrayList<Livro> livros;
    private ArvoreBinariaBusca arvoreDeLivros;

    public AcervoService() {
        this.livros = new ArrayList<>();
        this.arvoreDeLivros = new ArvoreBinariaBusca();
    }

   
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        arvoreDeLivros.inserir(livro);
    }

   
    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }


    public void buscarLivroPorAutor(String autor) {
        System.out.println("Resultado(s) da busca por autor:");
        arvoreDeLivros.buscarPorAutor(autor);
    }

   
    public void recomendarLivrosPorAutor(String autor) {
        arvoreDeLivros.recomendarLivros(autor);
    }

  
    public List<Livro> buscarLivroPorTitulo(String titulo) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

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
