package br.edu.ifpb.biblioteca.app;

import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.model.Revista;
import br.edu.ifpb.biblioteca.model.usuario;
import br.edu.ifpb.biblioteca.model.dvd;

public class Main {
    public static void main(String[] args) {
        Livro livro = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
        System.out.println(livro);
        
        Revista revista = new Revista(null, null, 0, 0, null, null);
        System.out.println(revista);

        usuario usuario = new usuario(0, null, null, 0, false);
        System.out.println(usuario);

        dvd dvd = new dvd(null, null, null);
        System.out.println(dvd);
    }
}