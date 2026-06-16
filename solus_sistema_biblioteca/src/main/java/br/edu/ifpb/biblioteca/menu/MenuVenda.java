package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.service.BibliotecaService;
import br.edu.ifpb.biblioteca.util.Cores;

public class MenuVenda {

    public static void menuVenda(Scanner sc, BibliotecaService service) {

        int opcao = 0;

        while (opcao != 3) {

            CabecalhoMenu.exibir("VENDA DE JOGOS");

            System.out.println("1. Vender Jogo");
            System.out.println("2. Consultar Vendas");
            System.out.println("3. Voltar");

            opcao = MenuCadastro.lerInteiro(sc, "Escolha: ");

            switch (opcao) {

                case 1:

                    System.out.println("\n=== VENDA DE JOGO ===");

                    int idJogo = MenuCadastro.lerInteiro(sc, "ID do jogo: ");

                    boolean sucesso = service.realizarVendaJogo(idJogo);

                    if (sucesso) {

                        Cores.sucesso("Venda realizada com sucesso!");

                    } else {

                        Cores.erro( "Não foi possível realizar a venda.");
                    }
                    MenuCadastro.pausar(sc);
                    break;

                case 2:

                    System.out.println("\n=== HISTÓRICO DE VENDAS ===");

                    if (service.listarVendas().isEmpty()) {

                        Cores.aviso("Nenhuma venda registrada.");

                    } else {

                        for (var venda : service.listarVendas()) {

                            System.out.println(venda);
                        }
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
