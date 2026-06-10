package br.edu.ifpb.biblioteca.controller;

import java.util.List;

import br.edu.ifpb.biblioteca.model.Revista;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class RevistaController {

    private BibliotecaService service;

    public RevistaController(BibliotecaService service) {
        this.service = service;
    }

    public boolean adicionarRevista(Revista revista) {
        return service.adicionarRevista(revista);
    }

    public Revista buscarRevistaPorISSN(String issn) {
        return service.buscarRevistaPorISSN(issn);
    }

    public Revista buscarRevistaPorTitulo(String titulo) {
        return service.buscarRevistaPorTitulo(titulo);
    }

    public List<Revista> listarRevistas() {
        return service.listarRevistas();
    }
}
