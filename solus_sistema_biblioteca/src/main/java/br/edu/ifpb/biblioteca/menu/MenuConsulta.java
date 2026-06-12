package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class MenuConsulta {

    public static void menuConsulta(
            Scanner sc,
            BibliotecaService service) {

        int opcao = 0;

        while (opcao != 5) {

            CabecalhoMenu.exibir("CONSULTA");

            System.out.println("1. Usuários");
            System.out.println("2. Acervo");
            System.out.println("3. Editoras");
            System.out.println("4. Empréstimos");
            System.out.println("5. Voltar");

            opcao = MenuCadastro.lerInteiro(sc, "Escolha: ");

            switch (opcao) {

                case 1:
                    MenuConsultaUsuario.menuConsultaUsuario( sc, service);
                    break;

                case 2:
                    MenuConsultaAcervo.menuConsultaAcervo( sc, service);
                    break;

                case 3:
                    MenuConsultaEditora.menuConsultaEditora( sc, service);
                    break;

                case 4:
                    MenuConsultaEmprestimo.menuConsultaEmprestimo( sc, service);
                    break;

                case 5:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}