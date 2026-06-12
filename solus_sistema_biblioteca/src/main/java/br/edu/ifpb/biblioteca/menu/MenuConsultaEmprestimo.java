package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class MenuConsultaEmprestimo {

    public static void menuConsultaEmprestimo(
            Scanner sc,
            BibliotecaService service) {

        int opcao = 0;

        while (opcao != 2) {

           CabecalhoMenu.exibir("CONSULTA > EMPRÉSTIMOS");

            System.out.println("\n=== CONSULTA EMPRÉSTIMOS ===");
            System.out.println("1. Listar Empréstimos");
            System.out.println("2. Voltar");

            opcao = MenuCadastro.lerInteiro(
                    sc,
                    "Escolha: ");

            switch (opcao) {

                case 1:

                    if (service.listarEmprestimos().isEmpty()) {

                        System.out.println( "Nenhum empréstimo registrado.");

                    } else {

                        for (var emprestimo : service.listarEmprestimos()) {

                            System.out.println(emprestimo);
                        }
                    }

                    break;

                case 2:

                    System.out.println("Voltando...");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }
        }
    }
}
