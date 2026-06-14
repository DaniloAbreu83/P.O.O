package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.service.BibliotecaService;
import br.edu.ifpb.biblioteca.util.Cores;

public class MenuCadastro {

    public static int lerInteiro(
            Scanner sc,
            String mensagem) {

        int valor;

        while (true) {

            System.out.print(mensagem);

            if (sc.hasNextInt()) {

                valor = sc.nextInt();
                sc.nextLine();

                return valor;

            } else {

                System.out.println("Digite apenas números.");

                sc.nextLine();
            }
        }
    }

    public static void menuCadastro(
            Scanner sc,
            BibliotecaService service) {

        int opcaoCadastro = 0;

        while (opcaoCadastro != 4) {

            CabecalhoMenu.exibir("CADASTRO");

            System.out.println("1. Usuários");
            System.out.println("2. Acervo");
            System.out.println("3. Editoras");
            System.out.println("4. Voltar");

            opcaoCadastro = lerInteiro(sc, "Escolha: ");

            switch (opcaoCadastro) {

                case 1:

                    MenuUsuario.menuUsuario(sc, service);

                    break;

                case 2:

                    MenuAcervo.menuAcervo(sc, service);

                    break;

                case 3:

                    MenuEditora.menuEditora(sc, service);

                    break;

                case 4:

                    Cores.info("Voltando...");

                    break;

                default:

                    Cores.erro("Opção inválida.");

                    break;
            }
        }
    }

    public static void pausar(Scanner sc) {

        System.out.println();
        System.out.print("Pressione ENTER para continuar...");
        sc.nextLine();
    }
}