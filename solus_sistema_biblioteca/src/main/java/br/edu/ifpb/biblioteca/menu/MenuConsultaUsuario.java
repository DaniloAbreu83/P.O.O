package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class MenuConsultaUsuario {

    public static void menuConsultaUsuario(
            Scanner sc,
            BibliotecaService service) {

        int opcao = 0;

        while (opcao != 3) {

            CabecalhoMenu.exibir("CONSULTA > USUÁRIOS");
            
            System.out.println("1. Listar Usuários");
            System.out.println("2. Buscar Usuário por nome");
            System.out.println("3. Voltar");

            opcao = MenuCadastro.lerInteiro(
                    sc,
                    "Escolha: ");

            switch (opcao) {

                case 1:

                    if (service.listarUsuarios().isEmpty()) {

                        System.out.println(
                                "Nenhum usuário cadastrado.");

                    } else {

                        for (var usuario : service.listarUsuarios()) {

                            System.out.println(usuario);
                        }
                    }

                    break;

                case 2:
                    System.out.print(
                            "Nome do usuário: ");

                    String nome = sc.nextLine();

                    var usuarios = service.buscarUsuarioPorNome(nome);

                    if (usuarios.isEmpty()) {

                        System.out.println(
                                "Nenhum usuário encontrado.");

                    } else {

                        for (var usuario : usuarios) {

                            System.out.println(usuario);
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
