package br.edu.ifpb.biblioteca.util;

import br.edu.ifpb.biblioteca.model.Administrativo;
import br.edu.ifpb.biblioteca.model.AlunoGraduacao;
import br.edu.ifpb.biblioteca.model.AudioLivro;
import br.edu.ifpb.biblioteca.model.Cd;
import br.edu.ifpb.biblioteca.model.Dvd;
import br.edu.ifpb.biblioteca.model.Editora;
import br.edu.ifpb.biblioteca.model.Jogo;
import br.edu.ifpb.biblioteca.model.LivroFisico;
import br.edu.ifpb.biblioteca.model.PosGraduacao;
import br.edu.ifpb.biblioteca.model.Professor;
import br.edu.ifpb.biblioteca.model.Revista;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class DadosIniciais {

        public static void carregar(BibliotecaService service) {

                service.adicionarUsuario(new AlunoGraduacao(
                                                1,
                                                "João Silva",
                                                0,
                                                false,
                                                false));

                service.adicionarUsuario(new PosGraduacao(
                                                2,
                                                "Maria Souza",
                                                0,
                                                false,
                                                false));

                service.adicionarUsuario(new Professor(
                                                3,
                                                "Carlos Lima",
                                                0,
                                                false,
                                                false));

                service.adicionarUsuario(new Administrativo(
                                                4,
                                                "Ana Costa",
                                                0,
                                                false,
                                                false));

                Editora novatec = new Editora(
                                                1,
                                                "Novatec",
                                                "111");
                service.adicionarEditora(novatec);
                         
                Editora altaBooks = new Editora(
                                                2,
                                                "Alta Books",
                                                "222");
                service.adicionarEditora(altaBooks);
                service.adicionarLivro( new LivroFisico(
                                                1,
                                                "Java Como Programar",
                                                "Deitel",
                                                "111",
                                                novatec,
                                                2023,
                                                1200,
                                                "10ª",
                                                "Programação",
                                                "Livro de Java",
                                                "DISPONIVEL"));

                service.adicionarLivro(new LivroFisico(
                                                2,
                                                "Clean Code",
                                                "Robert Martin",
                                                "222",
                                                altaBooks,
                                                2020,
                                                450,
                                                "1ª",
                                                "Programação",
                                                "Boas práticas",
                                                "DISPONIVEL"));

                service.adicionarLivro(new AudioLivro(
                                                3,
                                                "Arquitetura Limpa",
                                                "Robert Martin",
                                                "333",
                                                altaBooks,
                                                2021,
                                                "1ª",
                                                "Programação",
                                                "Audiolivro",
                                                "DISPONIVEL",
                                                600));

                service.adicionarCd(new Cd(
                                                1,
                                                "Greatest Hits",
                                                "Queen",
                                                "Rock",
                                                "Bohemian Rhapsody",
                                                "DISPONIVEL"));

                service.adicionarCd(new Cd(
                                                2,
                                                "Thriller",
                                                "Michael Jackson",
                                                "Pop",
                                                "Billie Jean",
                                                "DISPONIVEL"));

                service.adicionarDvd(new Dvd(
                                                1,
                                                "Interestelar",
                                                "Christopher Nolan",
                                                169,
                                                "12 anos",
                                                "DISPONIVEL"));

                service.adicionarDvd( new Dvd(
                                                2,
                                                "O Senhor dos Anéis",
                                                "Peter Jackson",
                                                180,
                                                "14 anos",
                                                "DISPONIVEL"));

                service.adicionarRevista( new Revista(
                                                1,
                                                "Super Interessante",
                                                "Editora Abril",
                                                "1234-5678",
                                                10,
                                                5,
                                                novatec,
                                                java.time.LocalDate.of(2025, 5, 10),
                                                "DISPONIVEL"));

                service.adicionarRevista( new Revista(
                                                2,
                                                "Mundo Estranho",
                                                "Editora Abril",
                                                "8765-4321",
                                                8,
                                                3,
                                                altaBooks,
                                                java.time.LocalDate.of(2025, 3, 15),
                                                "DISPONIVEL"));
                Jogo jogo1 = new Jogo(
                                                1,
                                                "Banco Imobiliário",
                                                "TABULEIRO",
                                                120,
                                                99.90,
                                                "DISPONIVEL");

                service.adicionarJogo(jogo1);

                Jogo jogo2 = new Jogo(
                                                2,
                                                "Uno",
                                                "CARTAS",
                                                108,
                                                29.90,
                                                "DISPONIVEL");

                service.adicionarJogo(jogo2);
        }
}
