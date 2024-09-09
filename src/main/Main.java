package main;

import controller.SistemaGerenciamento;
import controller.Biblioteca;
import model.Livro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(100); // Capacidade da biblioteca
        SistemaGerenciamento sistema = new SistemaGerenciamento(biblioteca);
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        while (!sair) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Ordenar por Título");
            System.out.println("4. Ordenar por Autor");
            System.out.println("5. Buscar Livro por ID");
            System.out.println("6. Buscar Livro por Título");
            System.out.println("7. Buscar Livro por Autor");
            System.out.println("8. Buscar Livro por Ano de Publicação");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha após o número

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ano de publicação: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha após o número
                    sistema.adicionarLivro(titulo, autor, ano);
                    System.out.println("Livro adicionado com sucesso.");
                    break;

                case 2:
                    Livro[] livros = sistema.listarLivros();
                    for (Livro livro : livros) {
                        if (livro != null) {
                            System.out.println(livro);
                        }
                    }
                    break;

                case 3:
                    sistema.ordenarLivrosPorTitulo();
                    System.out.println("Livros ordenados por título.");
                    break;

                case 4:
                    sistema.ordenarLivrosPorAutor();
                    System.out.println("Livros ordenados por autor.");
                    break;

                case 5:
                    System.out.print("Digite o ID do livro: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Livro livroPorId = sistema.buscarLivroPorId(id);
                    System.out.println(livroPorId != null ? "Livro encontrado: " + livroPorId : "Livro não encontrado.");
                    break;

                case 6:
                    System.out.print("Digite o título do livro: ");
                    String buscaTitulo = scanner.nextLine();
                    Livro livroPorTitulo = sistema.buscarLivroPorTitulo(buscaTitulo);
                    System.out.println(livroPorTitulo != null ? "Livro encontrado: " + livroPorTitulo : "Livro não encontrado.");
                    break;

                case 7:
                    System.out.print("Digite o autor do livro: ");
                    String buscaAutor = scanner.nextLine();
                    Livro livroPorAutor = sistema.buscarLivroPorAutor(buscaAutor);
                    System.out.println(livroPorAutor != null ? "Livro encontrado: " + livroPorAutor : "Livro não encontrado.");
                    break;

                case 8:
                    System.out.print("Digite o ano de publicação: ");
                    int buscaAno = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha após o número
                    Livro[] livrosPorAno = sistema.buscarLivroPorAno(buscaAno);
                    if (livrosPorAno.length > 0) {
                        System.out.println("Livros encontrados no ano " + buscaAno + ":");
                        for (Livro l : livrosPorAno) {
                            System.out.println(l);
                        }
                    } else {
                        System.out.println("Nenhum livro encontrado para o ano " + buscaAno + ".");
                    }
                    break;

                case 9:
                    sair = true;
                    System.out.println("Saindo do sistema.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}