package br.edu.ifpb.biblioteca.app;

import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.model.Revista;
import br.edu.ifpb.biblioteca.model.usuario;

public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
        System.out.println(livro1);
        
        Revista revista = new Revista(null, null, 0, 0, null, null);
        System.out.println(revista);

        usuario usuario = new usuario(0, null, null, 0, false);
        System.out.println(usuario);
    }
}