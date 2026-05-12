package br.edu.ifpb.biblioteca.app;

import java.util.List;
import java.util.Scanner;
import br.edu.ifpb.biblioteca.model.Usuario;
import br.edu.ifpb.biblioteca.model.Emprestimo;
import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.model.Cd;
import br.edu.ifpb.biblioteca.model.Dvd;
import br.edu.ifpb.biblioteca.model.Revista;
import br.edu.ifpb.biblioteca.service.BibliotecaService;
import br.edu.ifpb.biblioteca.menu.MenuCadastro;

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

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("\n======= Solus ========");
            System.out.println("1. Cadastro");
            System.out.println("2. Buscar");
            System.out.println("3. Emprestimo");
            System.out.println("4. Listar");
            System.out.println("5. Sair");

            opcao = lerInteiro(sc, "Escolha: ");

            switch (opcao) {

                case 1:

                   MenuCadastro.menuCadastro(sc, service);
                    break;
                case 2:
                    System.out.println("Menu Buscar");

                    int opcaoBuscar = 0;

                    while (opcaoBuscar != 6) {

                        System.out.println("\n=== MENU BUSCAR ===");
                        System.out.println("1. Buscar usuário");
                        System.out.println("2. Buscar livro");
                        System.out.println("3. Buscar CD");
                        System.out.println("4. Buscar DVD");
                        System.out.println("5. Buscar Revista");
                        System.out.println("6. Voltar");

                        opcaoBuscar = lerInteiro(sc, "Escolha: ");

                        switch (opcaoBuscar) {

                            case 1:

                                int opcaoBuscarUsuario = 0;
                                while (opcaoBuscarUsuario != 3) {
                                    System.out.println("\n=== Buscar Usuário ===");
                                    System.out.println("1. Por ID");
                                    System.out.println("2. Por Nome");
                                    System.out.println("3. Voltar");

                                    opcaoBuscarUsuario = lerInteiro(sc, "Escolha: ");

                                    switch (opcaoBuscarUsuario) {
                                        case 1:

                                            int idBusca = lerInteiro(sc, "ID do usuário: ");
                                            Usuario usuario = service.buscarUsuario(idBusca);
                                            if (usuario != null) {
                                                System.out.println("Usuário encontrado:");
                                                System.out.println(usuario);
                                            } else {
                                                System.out.println("Usuário não encontrado.");
                                            }
                                            break;
                                        case 2:
                                            System.out.print("Nome do usuário: ");
                                            String nomeBusca = sc.nextLine();
                                            List<Usuario> usuarios = service.buscarUsuarioPorNome(nomeBusca);
                                            if (!usuarios.isEmpty()) {
                                                System.out.println("Usuários encontrados:");
                                                for (Usuario u : usuarios) {
                                                    System.out.println(u);
                                                }
                                            } else {
                                                System.out
                                                        .println("Nenhum usuário encontrado com o nome especificado.");
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Voltando...");
                                            break;
                                        default:
                                            System.out.println("Opção inválida.");
                                    }

                                }
                                break;
                            case 2:

                                System.out.print("ISBN do livro: ");
                                String isbnBusca = sc.nextLine();

                                if (!isbnBusca.matches("\\d+")) {

                                    System.out.println("ISBN deve conter apenas números.");
                                    break;
                                }

                                Livro livro = service.buscarLivroPorISBN(isbnBusca);

                                if (livro != null) {

                                    System.out.println("Livro encontrado:");
                                    System.out.println(livro);

                                } else {

                                    System.out.println("Livro não encontrado.");
                                }

                                break;
                        }
                    }

                case 3:

                    break;
                case 4:
                    System.out.println("Menu Emprestimo");
                    break;
                case 5:
                    System.out.println("Menu Listar");
                    break;
                case 6:
                    System.out.println("Sair...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
        sc.close();
    }

}

/*
 * case 1:
 * System.out.print("ID: ");
 * int id = sc.nextInt();
 * sc.nextLine();
 * 
 * System.out.print("Nome: ");
 * String nome = sc.nextLine();
 * 
 * System.out.print("Tipo (ALUNO/PROFESSOR/FUNCIONARIO): ");
 * String tipo = sc.nextLine();
 * tipo = tipo.toUpperCase().trim();
 * 
 * Usuario usuario = new Usuario(id, nome, tipo, 0, false, false);
 * boolean sucessoUsuario = service.adicionarUsuario(usuario);
 * 
 * if (sucessoUsuario) {
 * System.out.println("Usuário adicionado com sucesso!");
 * } else {
 * System.out.println("Erro: ID já existe ou usuário é inválido.");
 * }
 * break;
 * 
 * case 2:
 * System.out.print("ISBN:");
 * String ISBN = sc.nextLine();
 * 
 * System.out.print("Titulo: ");
 * String titulo = sc.nextLine();
 * 
 * System.out.print("Autor: ");
 * String autor = sc.nextLine();
 * 
 * System.out.print("Editora: ");
 * String editora = sc.nextLine();
 * 
 * System.out.print("Ano:");
 * int ano = sc.nextInt();
 * sc.nextLine();
 * 
 * System.out.print("Paginas:");
 * int paginas = sc.nextInt();
 * sc.nextLine();
 * 
 * System.out.print("Edição: ");
 * String edicao = sc.nextLine();
 * 
 * System.out.print("Gênero: ");
 * String genero = sc.nextLine();
 * 
 * System.out.print("Sinopse: ");
 * String sinopse = sc.nextLine();
 * 
 * Livro livro = new Livro(ISBN, titulo, autor, editora, ano, paginas, edicao,
 * genero, sinopse,
 * "DISPONIVEL");
 * 
 * boolean sucessoLivro = service.adicionarLivro(livro);
 * 
 * if (sucessoLivro) {
 * System.out.println("Livro adicionado com sucesso!");
 * } else {
 * System.out.println("Erro: livro já existe ou é inválido.");
 * }
 * break;
 * 
 * case 3:
 * System.out.print("ID do usuário: ");
 * int idUsuario = sc.nextInt();
 * sc.nextLine();
 * 
 * System.out.print("Título do livro: ");
 * String tituloItem = sc.nextLine();
 * 
 * boolean sucessoEmprestimo = service.realizarEmprestimo(idUsuario,
 * tituloItem);
 * if (sucessoEmprestimo) {
 * System.out.println("Empréstimo realizado com sucesso!");
 * } else {
 * System.out.
 * println("Erro ao realizar emprestimo. O livro encontra-se emprestado.");
 * }
 * break;
 * 
 * case 4:
 * System.out.print("ID do usuário: ");
 * int idDev = sc.nextInt();
 * sc.nextLine();
 * 
 * System.out.print("Título do livro: ");
 * String tituloDev = sc.nextLine();
 * 
 * System.out.print("Dias de atraso: ");
 * int diasAtraso = sc.nextInt();
 * sc.nextLine();
 * 
 * Emprestimo emp = service.registrarDevolucao(idDev, tituloDev, diasAtraso);
 * if (emp != null) {
 * System.out.println("Devolução realizada com sucesso!");
 * System.out.println("Multa: R$ " + emp.getMulta());
 * } else {
 * System.out.println("Erro ao realizar devolução.");
 * }
 * break;
 * 
 * case 5:
 * System.out.print("Título do livro: ");
 * String tituloBusca = sc.nextLine();
 * 
 * Livro livroEncontrado = service.buscarLivroPorTitulo(tituloBusca);
 * 
 * if (livroEncontrado != null) {
 * System.out.println("Livro encontrado:");
 * System.out.println(livroEncontrado);
 * } else {
 * System.out.println("Livro não encontrado.");
 * }
 * break;
 * 
 * case 6:
 * System.out.print("Nome do autor: ");
 * String autorBusca = sc.nextLine();
 * List<Livro> livrosAutor = service.buscarLivroPorAutor(autorBusca);
 * if (!livrosAutor.isEmpty()) {
 * System.out.println("Livros encontrados:");
 * for (Livro l : livrosAutor) {
 * System.out.println(l);
 * }
 * } else {
 * System.out.println("Nenhum livro encontrado para o autor especificado.");
 * }
 * break;
 * 
 * case 7:
 * System.out.print("ISBN do livro: ");
 * String isbnBusca = sc.nextLine();
 * Livro livroISBN = service.buscarLivroPorISBN(isbnBusca);
 * if (livroISBN != null) {
 * System.out.println("Livro encontrado:");
 * System.out.println(livroISBN);
 * } else {
 * System.out.println("Livro não encontrado.");
 * }
 * break;
 * 
 * case 8:
 * System.out.print("Nome do usuário: ");
 * String nomeUsuario = sc.nextLine();
 * List<Usuario> usuariosNome = service.buscarUsuarioPorNome(nomeUsuario);
 * if (!usuariosNome.isEmpty()) {
 * System.out.println("Usuários encontrados:");
 * for (Usuario u : usuariosNome) {
 * System.out.println(u);
 * }
 * } else {
 * System.out.println("Nenhum usuário encontrado com o nome especificado.");
 * }
 * break;
 * 
 * case 9:
 * service.listarEmprestimosEmAberto();
 * break;
 * 
 * case 10:
 * System.out.print("ID do usuário: ");
 * int idHistorico = sc.nextInt();
 * sc.nextLine();
 * service.listarHistoricoUsuario(idHistorico);
 * break;
 * 
 * case 11:
 * System.out.println("Sair...");
 * break;
 * 
 * default:
 * System.out.println("Opção inválida. Por favor, tente novamente.");
 * }
 * }
 * sc.close();
 * }
 * 
 * }
 */