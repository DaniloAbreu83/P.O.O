package br.edu.ifpb.biblioteca.controller;

import java.util.List;

import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class LivroController {

    private BibliotecaService service;

    public LivroController(BibliotecaService service) {
        this.service = service;
    }

    public boolean adicionarLivro(Livro livro) {
        return service.adicionarLivro(livro);
    }

    public Livro buscarLivroPorISBN(String isbn) {
        return service.buscarLivroPorISBN(isbn);
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        return service.buscarLivroPorTitulo(titulo);
    }

    public List<Livro> buscarLivroPorAutor(String autor) {
        return service.buscarLivroPorAutor(autor);
    }

    public List<Livro> buscarLivroPorEditora(String editora) {
        return service.buscarLivroPorEditora(editora);
    }

    public List<Livro> listarLivros() {
        return service.listarLivros();
    }
}
