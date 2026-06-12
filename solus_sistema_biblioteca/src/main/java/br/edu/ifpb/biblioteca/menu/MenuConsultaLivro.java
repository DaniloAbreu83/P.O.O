package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.service.BibliotecaService;
import br.edu.ifpb.biblioteca.controller.LivroController;

public class MenuConsultaLivro {

    public static void menuConsultaLivro( Scanner sc, BibliotecaService service) {

        LivroController livroController = new LivroController(service);

        int opcao = 0;

        while (opcao != 6) {

            CabecalhoMenu.exibir("CONSULTA > LIVROS");

            System.out.println("1. Listar Livros");
            System.out.println("2. Buscar por Título");
            System.out.println("3. Buscar por Autor");
            System.out.println("4. Buscar por ISBN");
            System.out.println("5. Buscar por Editora");
            System.out.println("6. Voltar");

            opcao = MenuCadastro.lerInteiro( sc, "Escolha: ");

            switch (opcao) {

                case 1:

                    if (livroController.listarLivros().isEmpty()) {

                        System.out.println( "Nenhum livro cadastrado.");

                    } else {

                        for (Livro livro : livroController.listarLivros()) {

                            System.out.println(livro);
                        }
                    }

                    break;

                case 2:

                    System.out.print( "Título do livro: ");

                    String titulo = sc.nextLine();

                    Livro livroTitulo = livroController.buscarLivroPorTitulo( titulo);

                    if (livroTitulo == null) {

                        System.out.println( "Livro não encontrado.");

                    } else {

                        System.out.println(livroTitulo);
                    }

                    break;

                case 3:

                    System.out.print( "Autor: ");

                    String autor = sc.nextLine();

                    var livrosAutor = livroController.buscarLivroPorAutor(
                            autor);

                    if (livrosAutor.isEmpty()) {

                        System.out.println(
                                "Nenhum livro encontrado.");

                    } else {

                        for (Livro livro : livrosAutor) {

                            System.out.println( livro);
                        }
                    }

                    break;

                case 4:

                    System.out.print( "ISBN: ");

                    String isbn = sc.nextLine();

                    Livro livroISBN = livroController.buscarLivroPorISBN(
                            isbn);

                    if (livroISBN == null) {

                        System.out.println( "Livro não encontrado.");

                    } else {

                        System.out.println( livroISBN);
                    }

                    break;

                case 5:

                    System.out.print( "Nome da editora: ");

                    String editora = sc.nextLine();

                    var livrosEditora = livroController.buscarLivroPorEditora( editora);

                    if (livrosEditora.isEmpty()) {

                        System.out.println( "Nenhum livro encontrado.");

                    } else {

                        for (Livro livro : livrosEditora) {

                            System.out.println( livro);
                        }
                    }

                    break;

                case 6:

                    System.out.println( "Voltando...");
                    break;

                default:

                    System.out.println( "Opção inválida.");
            }
        }
    }
}
