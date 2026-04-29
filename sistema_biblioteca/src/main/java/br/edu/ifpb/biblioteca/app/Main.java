package br.edu.ifpb.biblioteca.app;

import br.edu.ifpb.biblioteca.model.Usuario;
import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class Main {
    public static void main(String[] args) {

        BibliotecaService service = new BibliotecaService();

        // Criar usuário
        Usuario usuarioteste = new Usuario(1, "Danilo", "ALUNO", 0, false);

        // Criar livro
        Livro livroteste = new Livro();

        // Adicionar ao sistema
        service.adicionarUsuario(usuarioteste);
        service.adicionarLivro(livroteste);

        // Testar empréstimo
        service.realizarEmprestimo(1, "Java Básico");
        System.out.println("Fim do teste");

    }
}