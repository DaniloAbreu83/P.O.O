package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.model.Revista;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class MenuConsultaRevista {

    public static void menuConsultaRevista(
            Scanner sc,
            BibliotecaService service) {

        int opcao = 0;

        while (opcao != 5) {

            CabecalhoMenu.exibir("CONSULTA > REVISTAS");
            
            System.out.println("1. Listar Revistas");
            System.out.println("2. Buscar por Título");
            System.out.println("3. Buscar por ISSN");
            System.out.println("4. Buscar por Volume");
            System.out.println("5. Voltar");

            opcao = MenuCadastro.lerInteiro(
                    sc,
                    "Escolha: ");

            switch (opcao) {

                case 1:

                    if (service.listarRevistas().isEmpty()) {

                        System.out.println(
                                "Nenhuma revista cadastrada.");

                    } else {

                        for (Revista revista : service.listarRevistas()) {

                            System.out.println(revista);
                        }
                    }

                    break;

                case 2:

                    System.out.print(
                            "Título da revista: ");

                    String titulo = sc.nextLine();

                    Revista revistaTitulo = service.buscarRevistaPorTitulo(
                            titulo);

                    if (revistaTitulo == null) {

                        System.out.println(
                                "Revista não encontrada.");

                    } else {

                        System.out.println(
                                revistaTitulo);
                    }

                    break;

                case 3:

                    System.out.print(
                            "ISSN: ");

                    String issn = sc.nextLine();

                    Revista revistaIssn = service.buscarRevistaPorISSN(
                            issn);

                    if (revistaIssn == null) {

                        System.out.println(
                                "Revista não encontrada.");

                    } else {

                        System.out.println(
                                revistaIssn);
                    }

                    break;

                case 4:

                    int volume = MenuCadastro.lerInteiro(
                            sc,
                            "Volume: ");

                    var revistas = service.buscarRevistaPorVolume(
                            volume);

                    if (revistas.isEmpty()) {

                        System.out.println(
                                "Nenhuma revista encontrada.");

                    } else {

                        for (Revista revista : revistas) {

                            System.out.println(
                                    revista);
                        }
                    }

                    break;

                case 5:

                    System.out.println(
                            "Voltando...");
                    break;

                default:

                    System.out.println(
                            "Opção inválida.");
            }
        }
    }
}
