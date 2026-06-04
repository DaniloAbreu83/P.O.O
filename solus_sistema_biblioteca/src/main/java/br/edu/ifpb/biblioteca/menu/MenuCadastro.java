package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.model.Administrativo;
import br.edu.ifpb.biblioteca.model.AlunoGraduacao;
import br.edu.ifpb.biblioteca.model.Cd;
import br.edu.ifpb.biblioteca.model.Dvd;
import br.edu.ifpb.biblioteca.model.Editora;
import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.model.PosGraduacao;
import br.edu.ifpb.biblioteca.model.Professor;
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
                    System.out.println("1. ALUNO GRADUAÇÃO");
                    System.out.println("2. ALUNO PÓS-GRADUAÇÃO");
                    System.out.println("3. PROFESSOR");
                    System.out.println("4. FUNCIONARIO");

                    int tipoOpcao = lerInteiro(sc, "Escolha: ");

                    System.out.println();

                    int id = lerInteiro(sc, "ID: ");

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    Usuario usuario = null;

                    if (tipoOpcao == 1) {

                        usuario = new AlunoGraduacao(
                                id,
                                nome,
                                0,
                                false,
                                false);

                    } else if (tipoOpcao == 2) {

                        usuario = new PosGraduacao(
                                id, 
                                nome, 
                                0, 
                                false, 
                                false);

                    } else if (tipoOpcao == 3) {

                        usuario = new Professor(
                                id,
                                nome,
                                0,
                                false,
                                false);

                    } else if (tipoOpcao == 4) {

                        usuario = new Administrativo(
                                id,
                                nome,
                                0,
                                false,
                                false);
                    } else {

                        System.out.println("Tipo de usuário inválido.");
                        break;
                    }

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

                    int idLivro = lerInteiro(sc, "ID do livro: ");
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

                    System.out.print("Nome da Editora: ");
                    String nomeEditora = sc.nextLine();
                    Editora editora = new Editora(
                            1,
                            nomeEditora,
                            "00000000000000");

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
                            idLivro,
                            titulo,
                            autor,
                            ISBN,
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

                    int idCd = lerInteiro(sc, "ID do CD: ");

                    System.out.print("Título do Album: ");
                    String tituloCd = sc.nextLine();

                    System.out.print("Artista: ");
                    String artista = sc.nextLine();

                    System.out.print("Gênero: ");
                    String generoCd = sc.nextLine();

                    System.out.print("Lista de Faixas: ");
                    String listaDeFaixa = sc.nextLine();

                    Cd cd = new Cd(
                            idCd,
                            tituloCd,
                            artista,
                            generoCd,
                            listaDeFaixa,

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

                    int idDvd = lerInteiro(sc, "ID do DVD: ");

                    System.out.print("Título: ");
                    String tituloDvd = sc.nextLine();

                    System.out.print("Diretor: ");
                    String autorDvd = sc.nextLine();

                    System.out.print("Duração (minutos): ");
                    int duracao = lerInteiro(sc, "Duração (minutos): ");

                    System.out.print("Classificação Indicativa: ");
                    String classificacao = sc.nextLine();

                    Dvd dvd = new Dvd(
                            idDvd,
                            tituloDvd,
                            autorDvd,
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

                    int idRevista = lerInteiro(sc, "ID da revista: ");

                    System.out.print("ISSN: ");
                    String ISSN = sc.nextLine();

                    System.out.print("Título: ");
                    String tituloRevista = sc.nextLine();

                    System.out.print("Autor: ");
                    String autorRevista = sc.nextLine();

                    System.out.print("Volume: ");
                    int volume = lerInteiro(sc, "Volume: ");

                    System.out.print("Número: ");
                    int numero = lerInteiro(sc, "Número: ");

                    System.out.print("Nome da Editora: ");
                    String nomeEditoraRevista = sc.nextLine();

                    Editora editoraRevista = new Editora(
                            1,
                            nomeEditoraRevista,
                            "00000000000000");

                    System.out.print("Data de Publicação (AAAA-MM-DD): ");
                    String dataPublicacaoStr = sc.nextLine();

                    Revista revista = new Revista(
                            idRevista,
                            tituloRevista,
                            autorRevista,
                            ISSN,
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
