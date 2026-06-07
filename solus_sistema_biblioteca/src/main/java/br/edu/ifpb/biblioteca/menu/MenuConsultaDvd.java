package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.model.Dvd;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class MenuConsultaDvd {

    public static void menuConsultaDvd(
            Scanner sc,
            BibliotecaService service) {

        int opcao = 0;

        while (opcao != 3) {

            CabecalhoMenu.exibir("CONSULTA > DVDs");
            
            System.out.println("1. Listar DVDs");
            System.out.println("2. Buscar por Título");
            System.out.println("3. Voltar");

            opcao = MenuCadastro.lerInteiro(
                    sc,
                    "Escolha: ");

            switch (opcao) {

                case 1:

                    if (service.listarDvds().isEmpty()) {

                        System.out.println(
                                "Nenhum DVD cadastrado.");

                    } else {

                        for (Dvd dvd : service.listarDvds()) {

                            System.out.println(dvd);
                        }
                    }

                    break;

                case 2:

                    System.out.print(
                            "Título do DVD: ");

                    String titulo = sc.nextLine();

                    Dvd dvd = service.buscarDvd(
                            titulo);

                    if (dvd == null) {

                        System.out.println(
                                "DVD não encontrado.");

                    } else {

                        System.out.println(
                                dvd);
                    }

                    break;

                case 3:

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
