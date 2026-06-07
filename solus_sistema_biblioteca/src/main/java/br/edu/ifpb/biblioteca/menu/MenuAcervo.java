package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.model.AudioLivro;
import br.edu.ifpb.biblioteca.model.Cd;
import br.edu.ifpb.biblioteca.model.Dvd;
import br.edu.ifpb.biblioteca.model.Editora;
import br.edu.ifpb.biblioteca.model.Jogo;
import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.model.LivroFisico;
import br.edu.ifpb.biblioteca.model.Revista;
import br.edu.ifpb.biblioteca.service.BibliotecaService;


public class MenuAcervo {

    public static void menuAcervo(
            Scanner sc,
            BibliotecaService service) {

        int opcao = 0;

        while (opcao != 6) {

           CabecalhoMenu.exibir("CADASTRO > ACERVO");

            System.out.println("1. Livro");
            System.out.println("2. CD");
            System.out.println("3. DVD");
            System.out.println("4. Revista");
            System.out.println("5. Jogo");
            System.out.println("6. Voltar");

            opcao = MenuCadastro.lerInteiro(
                    sc,
                    "Escolha: ");

            switch (opcao) {

                case 1:

                    System.out.println("\n=== CADASTRO DE LIVRO ===");

                    System.out.println("1. Livro Físico");
                    System.out.println("2. Audiolivro");

                    int tipoLivro = MenuCadastro.lerInteiro(
                            sc,
                            "Escolha: ");

                    int idLivro = MenuCadastro.lerInteiro(
                            sc,
                            "ID do livro: ");

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    String isbn;

                    while (true) {

                        System.out.print("ISBN: ");
                        isbn = sc.nextLine();

                        if (isbn.matches("\\d+")) {
                            break;
                        }

                        System.out.println(
                                "ISBN deve conter apenas números.");
                    }

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    int idEditora = MenuCadastro.lerInteiro(
                            sc,
                            "ID da Editora: ");

                    Editora editora = service.buscarEditoraPorId(idEditora);

                    if (editora == null) {

                        System.out.println(
                                "Editora não encontrada.");

                        break;
                    }

                    int ano = MenuCadastro.lerInteiro(
                            sc,
                            "Ano: ");

                    System.out.print("Edição: ");
                    String edicao = sc.nextLine();

                    System.out.print("Gênero: ");
                    String genero = sc.nextLine();

                    System.out.print("Sinopse: ");
                    String sinopse = sc.nextLine();

                    Livro livro = null;

                    if (tipoLivro == 1) {

                        int paginas = MenuCadastro.lerInteiro(
                                sc,
                                "Número de páginas: ");

                        livro = new LivroFisico(
                                idLivro,
                                titulo,
                                autor,
                                isbn,
                                editora,
                                ano,
                                paginas,
                                edicao,
                                genero,
                                sinopse,
                                "DISPONIVEL");

                    } else if (tipoLivro == 2) {

                        int duracao = MenuCadastro.lerInteiro(
                                sc,
                                "Duração em minutos: ");

                        livro = new AudioLivro(
                                idLivro,
                                titulo,
                                autor,
                                isbn,
                                editora,
                                ano,
                                edicao,
                                genero,
                                sinopse,
                                "DISPONIVEL",
                                duracao);

                    } else {

                        System.out.println("Tipo inválido.");
                        break;
                    }

                    if (service.adicionarLivro(livro)) {

                        System.out.println(
                                "Livro cadastrado com sucesso!");

                    } else {

                        System.out.println(
                                "Erro ao cadastrar livro.");
                    }

                    break;

                case 2:

                    System.out.println("\n=== CADASTRO DE CD ===");

                    int idCd = MenuCadastro.lerInteiro(
                            sc,
                            "ID do CD: ");

                    System.out.print("Título do Álbum: ");
                    String tituloCd = sc.nextLine();

                    System.out.print("Artista: ");
                    String artista = sc.nextLine();

                    System.out.print("Gênero: ");
                    String generoCd = sc.nextLine();

                    System.out.print("Lista de Faixas: ");
                    String listaFaixas = sc.nextLine();

                    Cd cd = new Cd(
                            idCd,
                            tituloCd,
                            artista,
                            generoCd,
                            listaFaixas,
                            "DISPONIVEL");

                    if (service.adicionarCd(cd)) {

                        System.out.println(
                                "CD cadastrado com sucesso!");

                    } else {

                        System.out.println(
                                "Erro ao cadastrar CD.");
                    }

                    break;

                case 3:

                    System.out.println("\n=== CADASTRO DE DVD ===");

                    int idDvd = MenuCadastro.lerInteiro(
                            sc,
                            "ID do DVD: ");

                    System.out.print("Título: ");
                    String tituloDvd = sc.nextLine();

                    System.out.print("Diretor: ");
                    String diretor = sc.nextLine();

                    int duracaoDvd = MenuCadastro.lerInteiro(
                            sc,
                            "Duração (minutos): ");

                    System.out.print(
                            "Classificação Indicativa: ");
                    String classificacao = sc.nextLine();

                    Dvd dvd = new Dvd(
                            idDvd,
                            tituloDvd,
                            diretor,
                            duracaoDvd,
                            classificacao,
                            "DISPONIVEL");

                    if (service.adicionarDvd(dvd)) {

                        System.out.println(
                                "DVD cadastrado com sucesso!");

                    } else {

                        System.out.println(
                                "Erro ao cadastrar DVD.");
                    }

                    break;

                case 4:

                    System.out.println("\n=== CADASTRO DE REVISTA ===");

                    int idRevista = MenuCadastro.lerInteiro(
                            sc,
                            "ID da revista: ");

                    System.out.print("ISSN: ");
                    String issn = sc.nextLine();

                    System.out.print("Título: ");
                    String tituloRevista = sc.nextLine();

                    System.out.print("Autor: ");
                    String autorRevista = sc.nextLine();

                    int volume = MenuCadastro.lerInteiro(
                            sc,
                            "Volume: ");

                    int numero = MenuCadastro.lerInteiro(
                            sc,
                            "Número: ");

                    int idEditoraRevista = MenuCadastro.lerInteiro(
                            sc,
                            "ID da Editora: ");

                    Editora editoraRevista = service.buscarEditoraPorId(
                            idEditoraRevista);

                    if (editoraRevista == null) {

                        System.out.println(
                                "Editora não encontrada.");

                        break;
                    }

                    System.out.print(
                            "Data de Publicação (AAAA-MM-DD): ");

                    String dataPublicacao = sc.nextLine();

                    Revista revista = new Revista(
                            idRevista,
                            tituloRevista,
                            autorRevista,
                            issn,
                            volume,
                            numero,
                            editoraRevista,
                            java.time.LocalDate.parse(
                                    dataPublicacao),
                            "DISPONIVEL");

                    if (service.adicionarRevista(revista)) {

                        System.out.println(
                                "Revista cadastrada com sucesso!");

                    } else {

                        System.out.println(
                                "Erro ao cadastrar revista.");
                    }

                    break;

                case 5:

                    System.out.println(
                            "\n=== CADASTRO DE JOGO ===");

                    int idJogo = MenuCadastro.lerInteiro(
                            sc,
                            "ID: ");

                    System.out.print("Nome: ");
                    String nomeJogo = sc.nextLine();

                    System.out.println(
                            "Tipo:");

                    System.out.println(
                            "1. Cartas");

                    System.out.println(
                            "2. Tabuleiro");

                    int tipo = MenuCadastro.lerInteiro(
                            sc,
                            "Escolha: ");

                    String tipoJogo;

                    if (tipo == 1) {

                        tipoJogo = "CARTAS";

                    } else {

                        tipoJogo = "TABULEIRO";
                    }

                    int quantidadePecas = MenuCadastro.lerInteiro(
                            sc,
                            "Quantidade de peças: ");

                    System.out.print("Preço: ");
                    double preco = Double.parseDouble(
                            sc.nextLine());

                    Jogo jogo = new Jogo(
                            idJogo,
                            nomeJogo,
                            tipoJogo,
                            quantidadePecas,
                            preco,
                            "DISPONIVEL");

                    if (service.adicionarJogo(jogo)) {

                        System.out.println(
                                "Jogo cadastrado com sucesso!");

                    } else {

                        System.out.println(
                                "Erro ao cadastrar jogo.");
                    }

                    break;

                case 6:

                    System.out.println("Voltando...");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }
        }
    }
}
