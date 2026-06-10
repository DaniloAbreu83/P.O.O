package br.edu.ifpb.biblioteca.controller;

import br.edu.ifpb.biblioteca.model.Emprestimo;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class EmprestimoController {

    private BibliotecaService service;

    public EmprestimoController(BibliotecaService service) {
        this.service = service;
    }

    public boolean realizarEmprestimo(
            int idUsuario,
            String tituloLivro,
            String isbn) {

        return service.realizarEmprestimo(
                idUsuario,
                tituloLivro,
                isbn);
    }

    public Emprestimo registrarDevolucao(
            int idUsuario,
            String tituloLivro) {

        return service.registrarDevolucao(
                idUsuario,
                tituloLivro);
    }

    public void listarHistoricoUsuario(
            int idUsuario) {

        service.listarHistoricoUsuario(idUsuario);
    }

    public void listarEmprestimosEmAberto() {

        service.listarEmprestimosEmAberto();
    }
}
