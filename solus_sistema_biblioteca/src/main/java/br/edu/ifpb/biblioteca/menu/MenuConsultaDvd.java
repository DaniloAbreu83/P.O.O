package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.model.Dvd;
import br.edu.ifpb.biblioteca.service.BibliotecaService;
import br.edu.ifpb.biblioteca.controller.DvdController;
import br.edu.ifpb.biblioteca.util.Cores;

public class MenuConsultaDvd {

    public static void menuConsultaDvd(
            Scanner sc, BibliotecaService service) {
        DvdController dvdController = new DvdController(service);
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

                    if (dvdController.listarDvds().isEmpty()) {

                        Cores.info("Nenhum DVD cadastrado.");

                    } else {

                        for (Dvd dvd : dvdController.listarDvds()) {

                            System.out.println(dvd);
                        }
                    }
                        MenuCadastro.pausar(sc);
                    break;

                case 2:

                    System.out.print( "Título do DVD: ");

                    String titulo = sc.nextLine();

                    Dvd dvd = dvdController.buscarDvdPorTitulo( titulo);

                    if (dvd == null) {

                        Cores.info("DVD não encontrado.");

                    } else {

                        System.out.println( dvd);
                    }
                        MenuCadastro.pausar(sc);
                    break;

                case 3:

                    Cores.info("Voltando...");
                    break;

                default:

                    Cores.erro("Opção inválida.");
            }
        }
    }
}
