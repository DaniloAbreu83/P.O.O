package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.model.Cd;
import br.edu.ifpb.biblioteca.service.BibliotecaService;
import br.edu.ifpb.biblioteca.controller.CdController;
import br.edu.ifpb.biblioteca.util.Cores;

public class MenuConsultaCd {

    public static void menuConsultaCd(
            Scanner sc, BibliotecaService service) {

        CdController cdController = new CdController(service);
        int opcao = 0;

        while (opcao != 4) {

            CabecalhoMenu.exibir("CONSULTA > CDs");
            
            System.out.println("1. Listar CDs");
            System.out.println("2. Buscar por Título");
            System.out.println("3. Buscar por Artista");
            System.out.println("4. Voltar");

            opcao = MenuCadastro.lerInteiro(
                    sc,
                    "Escolha: ");

            switch (opcao) {

                case 1:

                    if (cdController.listarCds().isEmpty()) {

                        Cores.info("Nenhum CD cadastrado.");

                    } else {

                        for (Cd cd : cdController.listarCds()) {

                            System.out.println(cd);
                        }
                    }

                    break;

                case 2:

                    System.out.print( "Título do CD: ");

                    String titulo = sc.nextLine();

                    Cd cdTitulo = cdController.buscarCdPorTitulo( titulo);

                    if (cdTitulo == null) {

                        Cores.info("CD não encontrado.");

                    } else {

                        System.out.println( cdTitulo);
                    }

                    break;

                case 3:

                    System.out.print( "Nome do artista: ");

                    String artista = sc.nextLine();

                    var cds = cdController.buscarCdPorAutor( artista);

                    if (cds.isEmpty()) {

                        Cores.info("Nenhum CD encontrado.");

                    } else {

                        for (Cd cd : cds) {

                            System.out.println(cd);
                        }
                    }

                    break;

                case 4:

                    Cores.info("Voltando...");
                    break;

                default:

                    Cores.erro("Opção inválida.");
            }
        }
    }
}
