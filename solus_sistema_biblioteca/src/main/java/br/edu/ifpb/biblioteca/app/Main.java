package br.edu.ifpb.biblioteca.app;


import java.util.Scanner;
import br.edu.ifpb.biblioteca.service.BibliotecaService;
import br.edu.ifpb.biblioteca.menu.CabecalhoMenu;
import br.edu.ifpb.biblioteca.menu.MenuCadastro;
import br.edu.ifpb.biblioteca.menu.MenuConsulta;
import br.edu.ifpb.biblioteca.menu.MenuEmprestimo;
import br.edu.ifpb.biblioteca.menu.MenuVenda;
import br.edu.ifpb.biblioteca.util.DadosIniciais;

public class Main {

    public static int lerInteiro(Scanner sc, String mensagem) {

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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BibliotecaService service = new BibliotecaService();
        DadosIniciais.carregar(service);

        int opcao = 0;

        while (opcao != 5) {
            CabecalhoMenu.exibir("MENU PRINCIPAL");
            
            System.out.println("\n======= Solus ========");
            System.out.println("1. Cadastro");
            System.out.println("2. Consulta");
            System.out.println("3. Emprestimo");
            System.out.println("4. Venda");
            System.out.println("5. Sair");

            opcao = lerInteiro(sc, "Escolha: ");

            switch (opcao) {

                case 1:

                    MenuCadastro.menuCadastro(sc, service);
                    break;

                case 2:

                    MenuConsulta.menuConsulta(sc, service);
                    break;

                case 3:
                    MenuEmprestimo.menuEmprestimo(sc, service);
                    break;

                case 4:
                    MenuVenda.menuVenda(sc, service);
                    break;

                case 5:
                    System.out.println("Sair...");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
        sc.close();
    }

}

