package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.controller.EditoraController;
import br.edu.ifpb.biblioteca.model.Editora;
import br.edu.ifpb.biblioteca.service.BibliotecaService;
import br.edu.ifpb.biblioteca.util.Cores;

public class MenuEditora {

    public static void menuEditora(Scanner sc, BibliotecaService service) {
        EditoraController editoraController = new EditoraController(service);

        int opcao = 0;

        while (opcao != 4) {

            CabecalhoMenu.exibir("CADASTRO > EDITORA");

            System.out.println("1. Cadastrar Editora");
            System.out.println("2. Buscar Editora");
            System.out.println("3. Listar Editoras");
            System.out.println("4. Voltar");

            opcao = MenuCadastro.lerInteiro(sc, "Escolha: ");

            switch (opcao) {

                case 1:

                    System.out.println("\n=== CADASTRO DE EDITORA ===");

                    int id = MenuCadastro.lerInteiro(
                            sc,
                            "ID: ");

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CNPJ: ");
                    String cnpj = sc.nextLine();

                    Editora editora = new Editora(id, nome, cnpj);

                    boolean sucesso = editoraController.adicionarEditora(editora);

                    if (sucesso) {

                        Cores.sucesso("Editora cadastrada com sucesso!");

                    } else {

                        Cores.erro("Erro: CNPJ já cadastrado.");
                    }
                    MenuCadastro.pausar(sc);
                    break;

                case 2:

                    System.out.println("\n=== BUSCAR EDITORA ===");

                    int idBusca = MenuCadastro.lerInteiro(sc, "ID da editora: ");

                    Editora encontrada = editoraController.buscarEditoraPorId(idBusca);

                    if (encontrada != null) {

                        System.out.println(encontrada);

                    } else {

                        Cores.info("Editora não encontrada.");
                    }
                    MenuCadastro.pausar(sc);
                    break;

                case 3:

                    System.out.println("\n=== EDITORAS CADASTRADAS ===");

                    if (editoraController.listarEditoras().isEmpty()) {

                        Cores.info("Nenhuma editora cadastrada.");

                    } else {

                        for (Editora e : editoraController.listarEditoras()) {

                            System.out.println(e);
                        }
                    }
                        MenuCadastro.pausar(sc);
                    break;

                case 4:

                    Cores.info("Voltando...");
                    break;

                default:

                    Cores.erro("Opção inválida.");
            }
        }
    }
}
