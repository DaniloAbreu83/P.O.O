package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.service.BibliotecaService;
import br.edu.ifpb.biblioteca.controller.UsuarioController;
import br.edu.ifpb.biblioteca.util.Cores;

public class MenuConsultaUsuario {

    public static void menuConsultaUsuario(Scanner sc, BibliotecaService service) {
        UsuarioController usuarioController = new UsuarioController(service);

        int opcao = 0;

        while (opcao != 3) {

            CabecalhoMenu.exibir("CONSULTA > USUÁRIOS");

            System.out.println("1. Listar Usuários");
            System.out.println("2. Buscar Usuário por nome");
            System.out.println("3. Voltar");

            opcao = MenuCadastro.lerInteiro( sc, "Escolha: ");

            switch (opcao) {

                case 1:

                    if (usuarioController.listarUsuarios().isEmpty()) {

                        Cores.info("Nenhum usuário cadastrado.");

                    } else {

                        for (var usuario : usuarioController.listarUsuarios()) {

                            System.out.println(usuario);
                        }
                    }

                    break;

                case 2:
                    System.out.print("Nome do usuário: ");

                    String nome = sc.nextLine();

                    var usuarios = usuarioController.buscarUsuarioPorNome(nome);

                    if (usuarios.isEmpty()) {

                        Cores.info("Nenhum usuário encontrado.");

                    } else {

                        for (var usuario : usuarios) {

                            System.out.println(usuario);
                        }
                    }

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
