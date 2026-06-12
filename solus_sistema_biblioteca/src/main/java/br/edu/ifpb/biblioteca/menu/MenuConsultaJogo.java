package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.model.Jogo;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class MenuConsultaJogo {

    public static void menuConsultaJogo(
            Scanner sc,
            BibliotecaService service) {

        int opcao = 0;

        while (opcao != 3) {

            CabecalhoMenu.exibir("CONSULTA > JOGOS");

            System.out.println("1. Listar Jogos");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Voltar");

            opcao = MenuCadastro.lerInteiro( sc, "Escolha: ");

            switch (opcao) {

                case 1:

                    if (service.listarJogos().isEmpty()) {

                        System.out.println( "Nenhum jogo cadastrado.");

                    } else {

                        for (Jogo jogo : service.listarJogos()) {

                            System.out.println(jogo);
                        }
                    }

                    break;

                case 2:

                    int id = MenuCadastro.lerInteiro( sc, "ID do jogo: ");

                    Jogo jogo = service.buscarJogoPorId(id);

                    if (jogo != null) {

                        System.out.println( "\nJogo encontrado:");

                        System.out.println(jogo);

                    } else {

                        System.out.println( "Jogo não encontrado.");
                    }

                    break;

                case 3:

                    System.out.println(  "Voltando...");
                    break;

                default:

                    System.out.println( "Opção inválida.");
            }
        }
    }
}
