package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.controller.LivroController;
import br.edu.ifpb.biblioteca.controller.CdController;
import br.edu.ifpb.biblioteca.controller.DvdController;
import br.edu.ifpb.biblioteca.controller.RevistaController;
import br.edu.ifpb.biblioteca.controller.JogoController;
import br.edu.ifpb.biblioteca.controller.EditoraController;
import br.edu.ifpb.biblioteca.model.AudioLivro;
import br.edu.ifpb.biblioteca.model.Cd;
import br.edu.ifpb.biblioteca.model.Dvd;
import br.edu.ifpb.biblioteca.model.Editora;
import br.edu.ifpb.biblioteca.model.Jogo;
import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.model.LivroFisico;
import br.edu.ifpb.biblioteca.model.Revista;
import br.edu.ifpb.biblioteca.service.BibliotecaService;
import br.edu.ifpb.biblioteca.util.Cores;

public class MenuAcervo {

        public static void menuAcervo(Scanner sc, BibliotecaService service) {

                LivroController livroController = new LivroController(service);
                CdController cdController = new CdController(service);
                DvdController dvdController = new DvdController(service);
                RevistaController revistaController = new RevistaController(service);
                JogoController jogoController = new JogoController(service);
                EditoraController editoraController = new EditoraController(service);

                int opcao = 0;

                while (opcao != 6) {

                        CabecalhoMenu.exibir("CADASTRO > ACERVO");

                        System.out.println("1. Livro");
                        System.out.println("2. CD");
                        System.out.println("3. DVD");
                        System.out.println("4. Revista");
                        System.out.println("5. Jogo");
                        System.out.println("6. Voltar");

                        opcao = MenuCadastro.lerInteiro( sc, "Escolha: ");

                        switch (opcao) {

                                case 1:

                                        System.out.println("\n=== CADASTRO DE LIVRO ===");

                                        System.out.println("1. Livro Físico");
                                        System.out.println("2. Audiolivro");

                                        int tipoLivro = MenuCadastro.lerInteiro( sc, "Escolha: ");

                                        int idLivro = MenuCadastro.lerInteiro( sc, "ID do livro: ");

                                        System.out.print("Título: ");
                                        String titulo = sc.nextLine();

                                        String isbn;

                                        while (true) {

                                                System.out.print("ISBN: ");
                                                isbn = sc.nextLine();

                                                if (isbn.matches("\\d+")) {
                                                        break;
                                                }

                                                Cores.info("ISBN deve conter apenas números.");
                                        }

                                        System.out.print("Autor: ");
                                        String autor = sc.nextLine();

                                        int idEditora = MenuCadastro.lerInteiro(
                                                        sc,
                                                        "ID da Editora: ");

                                        Editora editora = editoraController.buscarEditoraPorId(idEditora);

                                        if (editora == null) {

                                                Cores.info("Editora não encontrada.");

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

                                                int paginas = MenuCadastro.lerInteiro( sc, "Número de páginas: ");

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

                                                int duracao = MenuCadastro.lerInteiro( sc, "Duração em minutos: ");

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

                                                Cores.erro("Tipo inválido.");
                                                break;
                                        }

                                        if (livroController.adicionarLivro(livro)) {

                                                Cores.sucesso("Livro cadastrado com sucesso!");

                                        } else {

                                                Cores.erro("Erro ao cadastrar livro.");
                                        }

                                        break;

                                case 2:

                                        System.out.println("\n=== CADASTRO DE CD ===");

                                        int idCd = MenuCadastro.lerInteiro( sc, "ID do CD: ");

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

                                        if (cdController.adicionarCd(cd)) {

                                                Cores.sucesso("CD cadastrado com sucesso!");

                                        } else {

                                                Cores.erro("Erro ao cadastrar CD.");
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

                                        int duracaoDvd = MenuCadastro.lerInteiro( sc, "Duração (minutos): ");

                                        System.out.print("Classificação Indicativa: ");
                                        String classificacao = sc.nextLine();

                                        Dvd dvd = new Dvd(
                                                        idDvd,
                                                        tituloDvd,
                                                        diretor,
                                                        duracaoDvd,
                                                        classificacao,
                                                        "DISPONIVEL");

                                        if (dvdController.adicionarDvd(dvd)) {

                                                Cores.sucesso("DVD cadastrado com sucesso!");

                                        } else {

                                                Cores.erro("Erro ao cadastrar DVD.");
                                        }

                                        break;

                                case 4:

                                        System.out.println("\n=== CADASTRO DE REVISTA ===");

                                        int idRevista = MenuCadastro.lerInteiro(sc, "ID da revista: ");

                                        System.out.print("ISSN: ");
                                        String issn = sc.nextLine();

                                        System.out.print("Título: ");
                                        String tituloRevista = sc.nextLine();

                                        System.out.print("Autor: ");
                                        String autorRevista = sc.nextLine();

                                        int volume = MenuCadastro.lerInteiro( sc, "Volume: ");

                                        int numero = MenuCadastro.lerInteiro( sc, "Número: ");

                                        int idEditoraRevista = MenuCadastro.lerInteiro( sc, "ID da Editora: ");

                                        Editora editoraRevista = editoraController.buscarEditoraPorId(idEditoraRevista);

                                        if (editoraRevista == null) {

                                                Cores.info( "Editora não encontrada.");

                                                break;
                                        }

                                        System.out.print( "Data de Publicação (AAAA-MM-DD): ");

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

                                        if (revistaController.adicionarRevista(revista)) {

                                                Cores.sucesso( "Revista cadastrada com sucesso!");

                                        } else {

                                                Cores.erro( "Erro ao cadastrar revista.");
                                        }
                                        MenuCadastro.pausar(sc);
                                        break;

                                case 5:

                                        System.out.println( "\n=== CADASTRO DE JOGO ===");

                                        int idJogo = MenuCadastro.lerInteiro( sc,  "ID: ");

                                        System.out.print("Nome: ");
                                        String nomeJogo = sc.nextLine();

                                        System.out.println( "Tipo:");

                                        System.out.println( "1. Cartas");

                                        System.out.println( "2. Tabuleiro");

                                        int tipo = MenuCadastro.lerInteiro(  sc,  "Escolha: ");

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

                                        if (jogoController.adicionarJogo(jogo)) {

                                                Cores.sucesso( "Jogo cadastrado com sucesso!");

                                        } else {

                                                Cores.erro( "Erro ao cadastrar jogo.");
                                        }

                                        break;

                                case 6:

                                        Cores.info("Voltando...");
                                        break;

                                default:

                                        Cores.erro("Opção inválida.");
                        }
                }
        }
}
