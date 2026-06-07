package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class MenuConsultaAcervo {

    public static void menuConsultaAcervo(
            Scanner sc,
            BibliotecaService service) {

        int opcao = 0;

        while (opcao != 6) {

            CabecalhoMenu.exibir("CONSULTA > ACERVO");

            System.out.println("1. Livros");
            System.out.println("2. CDs");
            System.out.println("3. DVDs");
            System.out.println("4. Revistas");
            System.out.println("5. Jogos");
            System.out.println("6. Voltar");

            opcao = MenuCadastro.lerInteiro(
                    sc,
                    "Escolha: ");

            switch (opcao) {

                case 1:

                    MenuConsultaLivro.menuConsultaLivro(sc, service);
                    break;

                case 2:

                    MenuConsultaCd.menuConsultaCd(sc, service);

                    break;

                case 3:

                    MenuConsultaDvd.menuConsultaDvd(sc, service);
                    break;

                case 4:

                    MenuConsultaRevista.menuConsultaRevista(sc, service);
                    break;

                case 5:
                    MenuConsultaJogo.menuConsultaJogo(
                            sc,
                            service);

                    break;

                case 6:

                    System.out.println("Voltando...");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }
        }
    }
}
