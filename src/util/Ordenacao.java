package util;

import com.livraria.model.Livro;
import java.util.List;

public class Ordenacao {

    // Implementação do Bubble Sort para ordenar por título
    public static void bubbleSortPorTitulo(List<Livro> livros) {
        int n = livros.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (livros.get(j).getTitulo().compareTo(livros.get(j + 1).getTitulo()) > 0) {
                    Livro temp = livros.get(j);
                    livros.set(j, livros.get(j + 1));
                    livros.set(j + 1, temp);
                }
            }
        }
    }

    // Implementação do Bubble Sort para ordenar por autor
    public static void bubbleSortPorAutor(List<Livro> livros) {
        int n = livros.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (livros.get(j).getAutor().compareTo(livros.get(j + 1).getAutor()) > 0) {
                    Livro temp = livros.get(j);
                    livros.set(j, livros.get(j + 1));
                    livros.set(j + 1, temp);
                }
            }
        }
    }
}
