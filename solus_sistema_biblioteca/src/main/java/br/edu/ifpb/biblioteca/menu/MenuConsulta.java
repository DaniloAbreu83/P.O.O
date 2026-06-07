package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class MenuConsulta {

    public static void menuConsulta(
            Scanner sc,
            BibliotecaService service) {

        int opcao = 0;

        while (opcao != 7) {

            CabecalhoMenu.exibir("CONSULTA");
            
            System.out.println("1. Listar Usuários");
            System.out.println("2. Listar Livros");
            System.out.println("3. Listar CDs");
            System.out.println("4. Listar DVDs");
            System.out.println("5. Listar Revistas");
            System.out.println("6. Listar Empréstimos");
            System.out.println("7. Voltar");

            opcao = MenuCadastro.lerInteiro(sc, "Escolha: ");

            switch (opcao) {

                case 1:
                    if (service.listarUsuarios().isEmpty()) {

                        System.out.println("Nenhum usuário cadastrado.");

                    } else {

                        System.out.println("\n=== USUÁRIOS CADASTRADOS ===");

                        for (var usuario : service.listarUsuarios()) {
                            System.out.println(usuario);
                        }
                    }

                    break;

                case 2:
                    if (service.listarLivros().isEmpty()) {

                        System.out.println("Nenhum livro cadastrado.");

                    } else {

                        System.out.println("\n=== LIVROS CADASTRADOS ===");

                        for (var livro : service.listarLivros()) {
                            System.out.println(livro);
                        }
                    }

                    break;

                case 3:
                    if (service.listarCds().isEmpty()) {

                        System.out.println("Nenhum CD cadastrado.");

                    } else {

                        System.out.println("\n=== CDs CADASTRADOS ===");

                        for (var cd : service.listarCds()) {
                            System.out.println(cd);
                        }
                    }

                    break;

                case 4:
                    if (service.listarDvds().isEmpty()) {

                        System.out.println("Nenhum DVD cadastrado.");

                    } else {

                        System.out.println("\n=== DVDs CADASTRADOS ===");

                        for (var dvd : service.listarDvds()) {
                            System.out.println(dvd);
                        }
                    }

                    break;

                case 5:
                    if (service.listarRevistas().isEmpty()) {

                        System.out.println("Nenhuma revista cadastrada.");

                    } else {

                        System.out.println("\n=== REVISTAS CADASTRADAS ===");

                        for (var revista : service.listarRevistas()) {
                            System.out.println(revista);
                        }
                    }

                    break;

                case 6:
                    if (service.listarEmprestimos().isEmpty()) {

                        System.out.println("Nenhum empréstimo registrado.");

                    } else {

                        System.out.println("\n=== EMPRÉSTIMOS ===");

                        for (var emprestimo : service.listarEmprestimos()) {
                            System.out.println(emprestimo);
                        }
                    }

                    break;

                case 7:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}