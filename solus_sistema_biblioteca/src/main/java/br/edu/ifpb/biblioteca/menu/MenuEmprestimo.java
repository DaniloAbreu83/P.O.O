package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;
import br.edu.ifpb.biblioteca.util.Cores;
import br.edu.ifpb.biblioteca.model.Emprestimo;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class MenuEmprestimo {

    public static void menuEmprestimo(Scanner sc, BibliotecaService service) {

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

                    int idUsuario = MenuCadastro.lerInteiro(
                            sc,
                            "ID do usuário: ");

                    System.out.println("Tipo do item:");
                    System.out.println("1. Livro");
                    System.out.println("2. Revista");
                    System.out.println("3. Jogo");

                    int tipoItem = MenuCadastro.lerInteiro(
                            sc,
                            "Escolha: ");

                    boolean sucesso = false;

                    switch (tipoItem) {

                        case 1:

                            System.out.print("Título do livro: ");
                            String tituloLivro = sc.nextLine();

                            System.out.print("ISBN: ");
                            String isbn = sc.nextLine();

                            sucesso = service.realizarEmprestimo(
                                    idUsuario,
                                    tituloLivro,
                                    isbn);

                            break;

                        case 2:

                            System.out.print("Título da revista: ");
                            String tituloRevista = sc.nextLine();

                            sucesso = service.realizarEmprestimoRevista(
                                    idUsuario,
                                    tituloRevista);

                            break;

                        case 3:

                            int idJogo = MenuCadastro.lerInteiro(
                                    sc,
                                    "ID do jogo: ");

                            sucesso = service.realizarEmprestimoJogo(
                                    idUsuario,
                                    idJogo);

                            break;

                        default:

                            System.out.println("Tipo inválido.");
                            break;
                    }

                    if (sucesso) {

                        Cores.sucesso("Empréstimo realizado com sucesso!");

                    } else {

                        Cores.erro("Não foi possível realizar o empréstimo.");
                        Cores.erro("item indisponível, tente outro item.");
                    }
                    MenuCadastro.pausar(sc);
                    break;

                case 2:
                    System.out.println("\n=== REGISTRAR DEVOLUÇÃO ===");

                    int idUsuarioDev = MenuCadastro.lerInteiro(sc, "ID do usuário: ");

                    System.out.print("Título do item: ");
                    String tituloDev = sc.nextLine();

                    Emprestimo emprestimo = service.registrarDevolucao(idUsuarioDev, tituloDev);

                    if (emprestimo != null) {

                        Cores.sucesso("Devolução registrada com sucesso!");

                        if (emprestimo.getMulta() > 0) {

                            Cores.info("Multa gerada: R$ " + emprestimo.getMulta());
                        }

                    } else {

                        Cores.erro("Empréstimo não encontrado.");
                        Cores.info("Por favor, verifique os dados e tente novamente.");
                    }

                    break;

                case 3:
                    System.out.println("\n=== HISTÓRICO DO USUÁRIO ===");

                    int idHistorico = MenuCadastro.lerInteiro(sc, "ID do usuário: ");

                    service.listarHistoricoUsuario(idHistorico);

                    break;

                case 4:
                    Cores.info("Voltando...");
                    break;

                default:
                    Cores.erro("Opção inválida.");
                    Cores.info("Por favor, escolha uma opção de 1 a 4.");
            }
        }
    }
}
