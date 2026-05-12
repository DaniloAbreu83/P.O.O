package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.model.Cd;
import br.edu.ifpb.biblioteca.model.Dvd;
import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.model.Revista;
import br.edu.ifpb.biblioteca.model.Usuario;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class MenuCadastro {

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

    public static void menuCadastro(Scanner sc, BibliotecaService service) {

        int opcaoCadastro = 0;

        while (opcaoCadastro != 6) {

            System.out.println("\n=== MENU CADASTRO ===");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Cadastrar livro");
            System.out.println("3. Cadastrar CD");
            System.out.println("4. Cadastrar DVD");
            System.out.println("5. Cadastrar Revista");
            System.out.println("6. Voltar");

            opcaoCadastro = lerInteiro(sc, "Escolha: ");

            switch (opcaoCadastro) {

                case 1:
                    System.out.println();
                    System.out.println("\n====MENU CADASTRO====");
                    System.out.println("\n===Tipo de usuário:===");
                    System.out.println("1. ALUNO");
                    System.out.println("2. PROFESSOR");
                    System.out.println("3. FUNCIONARIO");

                    int tipoOpcao = lerInteiro(sc, "Escolha: ");

                    String tipo = "";

                    if (tipoOpcao == 1) {
                        tipo = "ALUNO";
                    } else if (tipoOpcao == 2) {
                        tipo = "PROFESSOR";
                    } else if (tipoOpcao == 3) {
                        tipo = "FUNCIONARIO";
                    } else {
                        System.out.println("Tipo inválido.");
                        break;
                    }

                    System.out.println();

                    int id = lerInteiro(sc, "ID: ");

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    Usuario usuario = new Usuario(
                            id,
                            nome,
                            tipo,
                            0,
                            false,
                            false);

                    boolean sucessoUsuario = service.adicionarUsuario(usuario);

                    if (sucessoUsuario) {
                        System.out.println("Usuário cadastrado com sucesso!");
                        System.out.println("\nDeseja realizar outro cadastro?");
                        System.out.println("1. Sim");
                        System.out.println("2. Não");
                        System.out.print("Escolha: ");
                        int opcaoOutroCadastro = lerInteiro(sc, "Escolha: ");

                        if (opcaoOutroCadastro == 2) {
                            opcaoCadastro = 6;
                        }
                    } else {
                        System.out.println("Erro: ao cadastrar usuário.");
                    }
                    break;

                case 2:
                    System.out.println("Cadastrar livro");

                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    String ISBN;
                    while (true) {
                        System.out.print("ISBN: ");
                        ISBN = sc.nextLine();
                        if (ISBN.matches("\\d+")) {
                            break;
                        }
                        System.out.println("ISBN deve conter apenas números.");
                    }

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Editora: ");
                    String editora = sc.nextLine();

                    System.out.print("Ano: ");
                    int ano = lerInteiro(sc, "Ano: ");
                    sc.nextLine();

                    System.out.print("Páginas: ");
                    int paginas = lerInteiro(sc, "Páginas: ");
                    sc.nextLine();

                    System.out.print("Edição: ");
                    String edicao = sc.nextLine();

                    System.out.print("Gênero: ");
                    String genero = sc.nextLine();

                    System.out.print("Sinopse: ");
                    String sinopse = sc.nextLine();

                    Livro livro = new Livro(
                            ISBN,
                            titulo,
                            autor,
                            editora,
                            ano,
                            paginas,
                            edicao,
                            genero,
                            sinopse,
                            "DISPONIVEL");

                    boolean sucessoLivro = service.adicionarLivro(livro);
                    if (sucessoLivro) {
                        System.out.println("Livro cadastrado com sucesso!");
                    }

                    if (sucessoLivro) {
                        System.out.println("\nDeseja realizar outro cadastro?");
                        System.out.println("1. Sim");
                        System.out.println("2. Não");
                        int opcaoOutroCadastro = lerInteiro(sc, "Escolha: ");

                        if (opcaoOutroCadastro == 2) {
                            opcaoCadastro = 6;
                        }
                    } else {
                        System.out.println("Erro: ao cadastrar livro.");
                    }
                    break;

                case 3:
                    System.out.println("Cadastrar CD");

                    System.out.print("Artista: ");
                    String artista = sc.nextLine();

                    System.out.print("Gênero: ");
                    String generoCd = sc.nextLine();

                    System.out.print("Lista de Faixas: ");
                    String listaDeFaixa = sc.nextLine();

                    System.out.print("Álbum: ");
                    String album = sc.nextLine();

                    Cd cd = new Cd(
                            artista,
                            generoCd,
                            listaDeFaixa,
                            album,
                            "DISPONIVEL");
                    boolean sucessoCd = service.adicionarCd(cd);
                    if (sucessoCd) {
                        System.out.println("CD cadastrado com sucesso!");
                    }
                    if (sucessoCd) {
                        System.out.println("\nDeseja realizar outro cadastro?");
                        System.out.println("1. Sim");
                        System.out.println("2. Não");
                        System.out.print("Escolha: ");
                        int opcaoOutroCadastro = lerInteiro(sc, "Escolha: ");

                        if (opcaoOutroCadastro == 2) {
                            opcaoCadastro = 6;
                        }
                    } else {
                        System.out.println("Erro: ao cadastrar CD.");
                    }
                    break;

                case 4:
                    System.out.println("Cadastrar DVD");

                    System.out.print("Título do Filme: ");
                    String tituloFilme = sc.nextLine();

                    System.out.print("Diretor: ");
                    String diretor = sc.nextLine();

                    System.out.print("Duração (minutos): ");
                    int duracao = lerInteiro(sc, "Duração (minutos): ");

                    System.out.print("Classificação Indicativa: ");
                    String classificacao = sc.nextLine();

                    Dvd dvd = new Dvd(
                            tituloFilme,
                            diretor,
                            duracao,
                            classificacao,
                            "DISPONIVEL");
                    boolean sucessoDvd = service.adicionarDvd(dvd);
                    if (sucessoDvd) {
                        System.out.println("DVD cadastrado com sucesso!");
                    }
                    if (sucessoDvd) {
                        System.out.println("\nDeseja realizar outro cadastro?");
                        System.out.println("1. Sim");
                        System.out.println("2. Não");
                        int opcaoOutroCadastro = lerInteiro(sc, "Escolha: ");

                        if (opcaoOutroCadastro == 2) {
                            opcaoCadastro = 6;
                        }
                    } else {
                        System.out.println("Erro: ao cadastrar DVD.");
                    }
                    break;

                case 5:
                    System.out.println("Cadastrar Revista");

                    System.out.print("ISSN: ");
                    String ISSN = sc.nextLine();

                    System.out.print("Título: ");
                    String tituloRevista = sc.nextLine();

                    System.out.print("Volume: ");
                    int volume = lerInteiro(sc, "Volume: ");
                    sc.nextLine();

                    System.out.print("Número: ");
                    int numero = lerInteiro(sc, "Número: ");
                    sc.nextLine();

                    System.out.print("Editora: ");
                    String editoraRevista = sc.nextLine();

                    System.out.print("Data de Publicação (AAAA-MM-DD): ");
                    String dataPublicacaoStr = sc.nextLine();

                    Revista revista = new Revista(
                            ISSN,
                            tituloRevista,
                            volume,
                            numero,
                            editoraRevista,
                            java.time.LocalDate.parse(dataPublicacaoStr),
                            "DISPONIVEL");
                    boolean sucessoRevista = service.adicionarRevista(revista);
                    if (sucessoRevista) {
                        System.out.println("Revista cadastrada com sucesso!");
                    }
                    if (sucessoRevista) {
                        System.out.println("\nDeseja realizar outro cadastro?");
                        System.out.println("1. Sim");
                        System.out.println("2. Não");
                        int opcaoOutroCadastro = lerInteiro(sc, "Escolha: ");

                        if (opcaoOutroCadastro == 2) {
                            opcaoCadastro = 6;
                        }
                    } else {
                        System.out.println("Erro: ao cadastrar Revista.");
                    }
                    break;

                case 6:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        }

    }

}
