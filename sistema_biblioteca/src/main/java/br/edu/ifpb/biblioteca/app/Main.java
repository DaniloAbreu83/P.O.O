package br.edu.ifpb.biblioteca.app;

import java.util.Scanner;
import br.edu.ifpb.biblioteca.model.Usuario;
import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BibliotecaService service = new BibliotecaService();

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Adicionar Usuário");
            System.out.println("2. Cadrastrar Livro");
            System.out.println("3. Realizar emprestimo");
            System.out.println("4. Devolver livro");
            System.out.println("5. Sair");
            
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();
        

        switch (opcao) {
            case 1:
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Nome: ");
                String nome = sc.nextLine();
                
                System.out.print("Tipo (ALUNO/PROFESSOR/FUNCIONARIO): ");
                String tipo = sc.nextLine();

                Usuario usuario = new Usuario(id, nome, tipo, 0, false);
                service.adicionarUsuario(usuario);

                System.out.println("Usuário adicionado com sucesso!");
                break;

            case 2:
                System.out.print("ISBN:");
                String isbn = sc.nextLine();

                System.out.print("Titulo: ");
                String titulo = sc.nextLine();

                System.out.print("Autor: ");
                String autor = sc.nextLine();

                System.out.print("Editora: ");
                String editora = sc.nextLine();

                System.out.print("Ano:");
                int ano = sc.nextInt();
                sc.nextLine();

                System.out.print("Paginas:");
                int paginas = sc.nextInt();
                sc.nextLine();

                Livro livro = new Livro(isbn, titulo, autor, editora, ano, paginas);
                service.adicionarLivro(livro);
                System.out.println("Livro adicionado com sucesso!");
                break;
            
            case 3:
                System.out.print("ID do usuário: ");
                int idDev = sc.nextInt();
                sc.nextLine();

                System.out.print("Título do livro: ");
                String tituloDev = sc.nextLine();

                System.out.print("Dias de atraso: ");
                int diasAtraso = sc.nextInt();

                service.registrarDevolucao(idDev, tituloDev, diasAtraso);
                break;

            case 5:
                System.out.println("Sair...");
                break;

            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
        }
        }

    }
}