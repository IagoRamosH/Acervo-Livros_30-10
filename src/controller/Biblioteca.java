package controller;

import model.Livro;

public class Biblioteca {
    private Livro[] livros;
    private int contador;

    public Biblioteca(int capacidade) {
        livros = new Livro[capacidade];
        contador = 0;
    }

    public void adicionarLivro(Livro livro) {
        if (contador < livros.length) {
            livros[contador] = livro;
            contador++;
        } else {
            System.out.println("Acervo cheio!");
        }
    }

    public Livro[] listarLivros() {
        return livros;
    }

    public int getContador() {
        return contador;
    }

    // Busca por ID
    public Livro buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (livros[i].getId() == id) {
                return livros[i];
            }
        }
        return null;
    }

    // Busca por Título
    public Livro buscarPorTitulo(String titulo) {
        for (int i = 0; i < contador; i++) {
            if (livros[i].getTitulo().equalsIgnoreCase(titulo)) {
                return livros[i];
            }
        }
        return null;
    }

    // Busca por Autor
    public Livro buscarPorAutor(String autor) {
        for (int i = 0; i < contador; i++) {
            if (livros[i].getAutor().equalsIgnoreCase(autor)) {
                return livros[i];
            }
        }
        return null;
    }

    // Busca por Ano de Publicação
    public Livro[] buscarPorAno(int ano) {
        Livro[] livrosEncontrados = new Livro[contador];
        int encontrados = 0;

        for (int i = 0; i < contador; i++) {
            if (livros[i].getAnoPublicacao() == ano) {
                livrosEncontrados[encontrados] = livros[i];
                encontrados++;
            }
        }

        Livro[] resultado = new Livro[encontrados];
        System.arraycopy(livrosEncontrados, 0, resultado, 0, encontrados);
        return resultado;
    }

    public Livro[] getLivros() {
        return livros;
    }

    public void setLivros(Livro[] livros) {
        this.livros = livros;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
