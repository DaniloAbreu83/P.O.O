package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;
import br.edu.ifpb.biblioteca.util.Cores;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class MenuConsultaEditora {

    public static void menuConsultaEditora(
            Scanner sc,
            BibliotecaService service) {

        int opcao = 0;

        while (opcao != 2) {

           CabecalhoMenu.exibir("CONSULTA > EDITORAS");

            System.out.println("\n=== CONSULTA EDITORAS ===");
            System.out.println("1. Listar Editoras");
            System.out.println("2. Voltar");

            opcao = MenuCadastro.lerInteiro(
                    sc,
                    "Escolha: ");

            switch (opcao) {

                case 1:

                    if (service.listarEditoras().isEmpty()) {

                        Cores.info("Nenhuma editora cadastrada.");

                    } else {

                        for (var editora : service.listarEditoras()) {

                            System.out.println(editora);
                        }
                    }

                    break;

                case 2:

                    Cores.info("Voltando...");
                    break;

                default:

                    Cores.erro("Opção inválida.");
            }
        }
    }
}
