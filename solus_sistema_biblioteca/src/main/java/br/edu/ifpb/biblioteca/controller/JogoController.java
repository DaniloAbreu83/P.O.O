package br.edu.ifpb.biblioteca.controller;

import java.util.List;

import br.edu.ifpb.biblioteca.model.Jogo;
import br.edu.ifpb.biblioteca.service.BibliotecaService;
import br.edu.ifpb.biblioteca.model.Venda;

public class JogoController {

    private BibliotecaService service;

    public JogoController(BibliotecaService service) {
        this.service = service;
    }

    public boolean adicionarJogo(Jogo jogo) {
        return service.adicionarJogo(jogo);
    }

    public Jogo buscarJogoPorId(int id) {
        return service.buscarJogoPorId(id);
    }

    public List<Jogo> listarJogos() {
        return service.listarJogos();
    }

    public boolean realizarVenda(int idJogo) {
        return service.realizarVendaJogo(idJogo);
    }

    public List<Venda> listarVendas() {
        return service.listarVendas();
    }
}
