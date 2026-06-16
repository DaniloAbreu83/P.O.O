package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.model.Administrativo;
import br.edu.ifpb.biblioteca.model.AlunoGraduacao;
import br.edu.ifpb.biblioteca.model.PosGraduacao;
import br.edu.ifpb.biblioteca.model.Professor;
import br.edu.ifpb.biblioteca.service.BibliotecaService;
import br.edu.ifpb.biblioteca.controller.UsuarioController;
import br.edu.ifpb.biblioteca.util.Cores;

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
                        Cores.sucesso("Aluno cadastrado com sucesso!");
                    } else {
                        Cores.erro("Erro ao cadastrar aluno.");
                        Cores.info("Usuario ja cadastrado");
                    }
                    MenuCadastro.pausar(sc);
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
                        Cores.sucesso("Pós-graduando cadastrado com sucesso!");
                    } else {
                        Cores.erro("Erro ao cadastrar usuário.");
                        Cores.info("Usuario ja cadastrado");
                    }
                        MenuCadastro.pausar(sc);

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
                        Cores.sucesso("Professor cadastrado com sucesso!");
                    } else {
                        Cores.erro("Erro ao cadastrar usuário.");
                        Cores.info("Usuario ja cadastrado");
                    }
                    MenuCadastro.pausar(sc);
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
                        Cores.sucesso("Administrativo cadastrado com sucesso!");
                    } else {
                        Cores.erro("Erro ao cadastrar usuário.");
                        Cores.info("Usuario ja cadastrado");
                    }
                    MenuCadastro.pausar(sc);
                    break;

                case 5:
                    Cores.info("Voltando...");
                    break;

                default:
                    Cores.erro("Opção inválida.");
                    Cores.info("Digite apenas números entre 1 e 5.");
                    break;
            }
        }
    }
}
