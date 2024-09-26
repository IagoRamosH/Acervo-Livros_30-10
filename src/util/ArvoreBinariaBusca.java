package util;

import com.livraria.model.Livro;

public class ArvoreBinariaBusca {
    private Nodo raiz;

    private class Nodo {
        Livro livro;
        Nodo esquerda, direita;

        public Nodo(Livro livro) {
            this.livro = livro;
            this.esquerda = null;
            this.direita = null;
        }
    }

    
    public void inserir(Livro livro) {
        raiz = inserirRecursivo(raiz, livro);
    }

    private Nodo inserirRecursivo(Nodo nodo, Livro livro) {
        if (nodo == null) {
            return new Nodo(livro);
        }
        if (livro.getAutor().compareToIgnoreCase(nodo.livro.getAutor()) < 0) {
            nodo.esquerda = inserirRecursivo(nodo.esquerda, livro);
        } else if (livro.getAutor().compareToIgnoreCase(nodo.livro.getAutor()) > 0) {
            nodo.direita = inserirRecursivo(nodo.direita, livro);
        }
        return nodo;
    }

 
    public void buscarPorAutor(String autor) {
        buscarPorAutorRecursivo(raiz, autor);
    }

    private void buscarPorAutorRecursivo(Nodo nodo, String autor) {
        if (nodo == null) {
            return;
        }

        if (nodo.livro.getAutor().equalsIgnoreCase(autor)) {
            System.out.println(nodo.livro);
        }
        buscarPorAutorRecursivo(nodo.esquerda, autor);
        buscarPorAutorRecursivo(nodo.direita, autor);
    }


    public void recomendarLivros(String autor) {
        System.out.println("Recomendações de livros de autores com nomes semelhantes:");
        recomendarRecursivo(raiz, autor);
    }

    private void recomendarRecursivo(Nodo nodo, String autor) {
        if (nodo == null) {
            return;
        }


        if (nodo.livro.getAutor().substring(0, 1).equalsIgnoreCase(autor.substring(0, 1))) {
            System.out.println(nodo.livro);
        }

        recomendarRecursivo(nodo.esquerda, autor);
        recomendarRecursivo(nodo.direita, autor);
    }
}
