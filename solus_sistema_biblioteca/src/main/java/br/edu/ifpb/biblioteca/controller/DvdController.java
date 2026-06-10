package br.edu.ifpb.biblioteca.controller;

import java.util.List;

import br.edu.ifpb.biblioteca.model.Dvd;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class DvdController {

    private BibliotecaService service;

    public DvdController(BibliotecaService service) {
        this.service = service;
    }

    public boolean adicionarDvd(Dvd dvd) {
        return service.adicionarDvd(dvd);
    }

    public Dvd buscarDvdPorTitulo(String titulo) {
        return service.buscarDvd(titulo);
    }

    public List<Dvd> listarDvds() {
        return service.listarDvds();
    }
}
