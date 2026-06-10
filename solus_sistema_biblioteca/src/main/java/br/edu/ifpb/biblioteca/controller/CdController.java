package br.edu.ifpb.biblioteca.controller;

import java.util.List;

import br.edu.ifpb.biblioteca.model.Cd;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class CdController {

    private BibliotecaService service;

    public CdController(BibliotecaService service) {
        this.service = service;
    }

    public boolean adicionarCd(Cd cd) {
        return service.adicionarCd(cd);
    }

    public Cd buscarCdPorTitulo(String titulo) {
        return service.buscarCdPorTitulo(titulo);
    }

    public List<Cd> buscarCdPorAutor(String autor) {
        return service.buscarCdPorAutor(autor);
    }

    public List<Cd> listarCds() {
        return service.listarCds();
    }
}
