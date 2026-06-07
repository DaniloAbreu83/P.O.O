package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.model.Emprestimo;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class MenuEmprestimo {

    public static void menuEmprestimo(
            Scanner sc,
            BibliotecaService service) {

        int opcao = 0;

        while (opcao != 4) {
            CabecalhoMenu.exibir("EMPRÉSTIMO");
            
            System.out.println("\n=== MENU EMPRÉSTIMO ===");
            System.out.println("1. Realizar Empréstimo");
            System.out.println("2. Registrar Devolução");
            System.out.println("3. Histórico do Usuário");
            System.out.println("4. Voltar");

            opcao = MenuCadastro.lerInteiro(sc, "Escolha: ");

            switch (opcao) {

                case 1:
                    System.out.println("\n=== REALIZAR EMPRÉSTIMO ===");

                    int idUsuario = MenuCadastro.lerInteiro(sc, "ID do usuário: ");

                    System.out.print("Título do livro: ");
                    String tituloLivro = sc.nextLine();

                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();

                    boolean sucesso = service.realizarEmprestimo(
                            idUsuario,
                            tituloLivro,
                            isbn);

                    if (sucesso) {
                        System.out.println("Empréstimo realizado com sucesso!");
                    } else {
                        System.out.println("Não foi possível realizar o empréstimo.");
                    }

                    break;
                case 2:
                    System.out.println("\n=== REGISTRAR DEVOLUÇÃO ===");

                    int idUsuarioDev = MenuCadastro.lerInteiro(
                            sc,
                            "ID do usuário: ");

                    System.out.print("Título do livro: ");
                    String tituloDev = sc.nextLine();

                    Emprestimo emprestimo = service.registrarDevolucao(
                            idUsuarioDev,
                            tituloDev);

                    if (emprestimo != null) {

                        System.out.println("Devolução registrada com sucesso!");

                        if (emprestimo.getMulta() > 0) {

                            System.out.println(
                                    "Multa gerada: R$ "
                                            + emprestimo.getMulta());
                        }

                    } else {

                        System.out.println(
                                "Empréstimo não encontrado.");
                    }

                    break;

                case 3:
                    System.out.println("\n=== HISTÓRICO DO USUÁRIO ===");

                    int idHistorico = MenuCadastro.lerInteiro(
                            sc,
                            "ID do usuário: ");

                    service.listarHistoricoUsuario(idHistorico);

                    break;

                case 4:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
