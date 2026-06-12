package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class MenuVenda {

    public static void menuVenda( Scanner sc, BibliotecaService service) {

        int opcao = 0;

        while (opcao != 3) {

            CabecalhoMenu.exibir("VENDA DE JOGOS");

            System.out.println("1. Vender Jogo");
            System.out.println("2. Consultar Vendas");
            System.out.println("3. Voltar");

            opcao = MenuCadastro.lerInteiro( sc, "Escolha: ");

            switch (opcao) {

                case 1:

                    System.out.println( "\n=== VENDA DE JOGO ===");

                    int idJogo = MenuCadastro.lerInteiro( sc, "ID do jogo: ");

                    boolean sucesso = service.realizarVendaJogo(idJogo);

                    if (sucesso) {

                        System.out.println("Venda realizada com sucesso!");

                    } else {

                        System.out.println("Não foi possível realizar a venda.");
                    }

                    break;

                case 2:

                    System.out.println("\n=== HISTÓRICO DE VENDAS ===");

                    if (service.listarVendas().isEmpty()) {

                        System.out.println("Nenhuma venda registrada.");

                    } else {

                        for (var venda : service.listarVendas()) {

                            System.out.println(venda);
                        }
                    }

                    break;

                case 3:

                    System.out.println("Voltando...");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }
        }
    }
}
