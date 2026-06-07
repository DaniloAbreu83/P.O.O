package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.model.Editora;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class MenuEditora {

    public static void menuEditora(
            Scanner sc,
            BibliotecaService service) {

        int opcao = 0;

        while (opcao != 4) {

           CabecalhoMenu.exibir("CADASTRO > EDITORA");
           
            System.out.println("1. Cadastrar Editora");
            System.out.println("2. Buscar Editora");
            System.out.println("3. Listar Editoras");
            System.out.println("4. Voltar");

            opcao = MenuCadastro.lerInteiro(
                    sc,
                    "Escolha: ");

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

                    Editora editora = new Editora(
                            id,
                            nome,
                            cnpj);

                    boolean sucesso =
                            service.adicionarEditora(editora);

                    if (sucesso) {

                        System.out.println(
                                "Editora cadastrada com sucesso!");

                    } else {

                        System.out.println(
                                "Erro: CNPJ já cadastrado.");
                    }

                    break;

                case 2:

                    System.out.println("\n=== BUSCAR EDITORA ===");

                    int idBusca =
                            MenuCadastro.lerInteiro(
                                    sc,
                                    "ID da editora: ");

                    Editora encontrada =
                            service.buscarEditoraPorId(idBusca);

                    if (encontrada != null) {

                        System.out.println(encontrada);

                    } else {

                        System.out.println(
                                "Editora não encontrada.");
                    }

                    break;

                case 3:

                    System.out.println(
                            "\n=== EDITORAS CADASTRADAS ===");

                    if (service.listarEditoras().isEmpty()) {

                        System.out.println(
                                "Nenhuma editora cadastrada.");

                    } else {

                        for (Editora e :
                                service.listarEditoras()) {

                            System.out.println(e);
                        }
                    }

                    break;

                case 4:

                    System.out.println("Voltando...");
                    break;

                default:

                    System.out.println(
                            "Opção inválida.");
            }
        }
    }
}
