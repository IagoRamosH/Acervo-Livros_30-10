package util;

import model.Livro;

public class AlgoritmoOrdenacao {

    // Bubble Sort por Título
    public static void bubbleSortPorTitulo(Livro[] livros, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (livros[j] != null && livros[j + 1] != null) {
                    if (livros[j].getTitulo().compareToIgnoreCase(livros[j + 1].getTitulo()) > 0) {
                        // Troca de posição
                        Livro temp = livros[j];
                        livros[j] = livros[j + 1];
                        livros[j + 1] = temp;
                    }
                }
            }
        }
    }

    // Quick Sort por Autor
    public static void quickSortPorAutor(Livro[] livros, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(livros, inicio, fim);
            quickSortPorAutor(livros, inicio, indicePivo - 1);
            quickSortPorAutor(livros, indicePivo + 1, fim);
        }
    }

    private static int particionar(Livro[] livros, int inicio, int fim) {
        Livro pivo = livros[fim];
        int i = (inicio - 1);

        for (int j = inicio; j < fim; j++) {
            if (livros[j] != null && pivo != null && livros[j].getAutor().compareToIgnoreCase(pivo.getAutor()) < 0) {
                i++;
                Livro temp = livros[i];
                livros[i] = livros[j];
                livros[j] = temp;
            }
        }

        Livro temp = livros[i + 1];
        livros[i + 1] = livros[fim];
        livros[fim] = temp;

        return i + 1;
    }
}
