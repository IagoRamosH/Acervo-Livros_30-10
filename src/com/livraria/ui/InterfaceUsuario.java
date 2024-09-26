package com.livraria.ui;

import util.Ordenacao;
import java.util.Scanner;
import java.util.List;
import com.livraria.model.Livro;
import com.livraria.service.AcervoService;

public class InterfaceUsuario {
    private static AcervoService acervoService = new AcervoService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;
        while (executando) {
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Ordenar por Título e Exibir");
            System.out.println("4. Ordenar por Autor e Exibir");
            System.out.println("5. Buscar Livro por Título");
            System.out.println("6. Buscar Livro por Autor");
            System.out.println("7. Buscar Livro por Ano de Publicação");
            System.out.println("8. Recomendar Livros por Autor");
            System.out.println("9. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();  

            switch (escolha) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    acervoService.listarLivros();
                    break;
                case 3:
                    Ordenacao.bubbleSortPorTitulo(acervoService.getLivros());
                    System.out.println("Livros ordenados por título:");
                    acervoService.listarLivros();
                    break;
                case 4:
                    Ordenacao.bubbleSortPorAutor(acervoService.getLivros());
                    System.out.println("Livros ordenados por autor:");
                    acervoService.listarLivros();
                    break;
                case 5:
                    buscarLivroPorTitulo();
                    break;
                case 6:
                    buscarLivroPorAutor();
                    break;
                case 7:
                    buscarLivroPorAnoPublicacao();
                    break;
                case 8:
                    recomendarLivrosPorAutor();
                    break;
                case 9:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarLivro() {
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o autor do livro:");
        String autor = scanner.nextLine();
        System.out.println("Digite o ano de publicação:");
        int anoPublicacao = scanner.nextInt();
        scanner.nextLine();  

        Livro livro = new Livro(titulo, autor, anoPublicacao);
        acervoService.adicionarLivro(livro);
        System.out.println("Livro adicionado com sucesso!");
    }

   
    private static void buscarLivroPorTitulo() {
        System.out.println("Digite o título do livro que deseja buscar:");
        String titulo = scanner.nextLine();
        List<Livro> resultados = acervoService.buscarLivroPorTitulo(titulo);
        if (resultados.isEmpty()) {
            System.out.println("Nenhum livro encontrado com esse título.");
        } else {
            System.out.println("Resultado(s) da busca por título:");
            for (Livro livro : resultados) {
                System.out.println(livro);
            }
        }
    }

 
    private static void buscarLivroPorAutor() {
        System.out.println("Digite o nome do autor que deseja buscar:");
        String autor = scanner.nextLine();
        acervoService.buscarLivroPorAutor(autor);
    }


    private static void recomendarLivrosPorAutor() {
        System.out.println("Digite o nome do autor para obter recomendações:");
        String autor = scanner.nextLine();
        acervoService.recomendarLivrosPorAutor(autor);
    }


    private static void buscarLivroPorAnoPublicacao() {
        System.out.println("Digite o ano de publicação do livro que deseja buscar:");
        int anoPublicacao = scanner.nextInt();
        List<Livro> resultados = acervoService.buscarLivroPorAno(anoPublicacao);
        if (resultados.isEmpty()) {
            System.out.println("Nenhum livro encontrado com esse ano de publicação.");
        } else {
            System.out.println("Resultado(s) da busca por ano de publicação:");
            for (Livro livro : resultados) {
                System.out.println(livro);
            }
        }
    }
}
