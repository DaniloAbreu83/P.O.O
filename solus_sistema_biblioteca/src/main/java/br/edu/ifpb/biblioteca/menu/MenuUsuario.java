package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.model.Administrativo;
import br.edu.ifpb.biblioteca.model.AlunoGraduacao;
import br.edu.ifpb.biblioteca.model.PosGraduacao;
import br.edu.ifpb.biblioteca.model.Professor;
import br.edu.ifpb.biblioteca.service.BibliotecaService;
import br.edu.ifpb.biblioteca.controller.UsuarioController;

public class MenuUsuario {
    public static void menuUsuario( Scanner sc, BibliotecaService service) {
        UsuarioController usuarioController = new UsuarioController(service);

        int opcao = 0;

        while (opcao != 5) {

            CabecalhoMenu.exibir("CADASTRO > USUÁRIO");

            System.out.println("1. Aluno Graduação");
            System.out.println("2. Pós-Graduação");
            System.out.println("3. Professor");
            System.out.println("4. Administrativo");
            System.out.println("5. Voltar");

            opcao = MenuCadastro.lerInteiro( sc, "Escolha: ");

            switch (opcao) {
                case 1:
                    // código do aluno
                    int id = MenuCadastro.lerInteiro( sc,  "ID: ");

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    AlunoGraduacao usuario = new AlunoGraduacao(
                            id,
                            nome,
                            0,
                            false,
                            false);

                    boolean sucesso = usuarioController.adicionarUsuario(usuario);

                    if (sucesso) {
                        System.out.println("Aluno cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar aluno.");
                    }

                    break;

                case 2:
                    // código da pós
                    int idPos = MenuCadastro.lerInteiro( sc, "ID: ");

                    System.out.print("Nome: ");
                    String nomePos = sc.nextLine();

                    PosGraduacao usuarioPos = new PosGraduacao(
                            idPos,
                            nomePos,
                            0,
                            false,
                            false);

                    boolean sucessoPos = usuarioController.adicionarUsuario(usuarioPos);

                    if (sucessoPos) {
                        System.out.println("Pós-graduando cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar usuário.");
                    }

                    break;

                case 3:
                    // código do professor
                    int idProfessor = MenuCadastro.lerInteiro( sc, "ID: ");

                    System.out.print("Nome: ");
                    String nomeProfessor = sc.nextLine();

                    Professor professor = new Professor(
                            idProfessor,
                            nomeProfessor,
                            0,
                            false,
                            false);

                    boolean sucessoProfessor = usuarioController.adicionarUsuario(professor);

                    if (sucessoProfessor) {
                        System.out.println("Professor cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar usuário.");
                    }
                    break;

                case 4:
                    // código do administrativo
                    int idAdm = MenuCadastro.lerInteiro( sc, "ID: ");

                    System.out.print("Nome: ");
                    String nomeAdm = sc.nextLine();

                    Administrativo administrativo = new Administrativo(
                            idAdm,
                            nomeAdm,
                            0,
                            false,
                            false);

                    boolean sucessoAdm = usuarioController.adicionarUsuario(administrativo);

                    if (sucessoAdm) {
                        System.out.println("Administrativo cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro: ID já cadastrado.");
                    }
                    break;

                case 5:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
