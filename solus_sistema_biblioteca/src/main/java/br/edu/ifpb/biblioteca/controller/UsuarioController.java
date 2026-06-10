package br.edu.ifpb.biblioteca.controller;

import java.util.List;

import br.edu.ifpb.biblioteca.model.Usuario;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class UsuarioController {

    private BibliotecaService service;

    public UsuarioController(BibliotecaService service) {
        this.service = service;
    }

    public boolean adicionarUsuario(Usuario usuario) {
        return service.adicionarUsuario(usuario);
    }

    public Usuario buscarUsuarioPorId(int id) {
        return service.buscarUsuario(id);
    }

    public List<Usuario> buscarUsuarioPorNome(String nome) {
        return service.buscarUsuarioPorNome(nome);
    }

    public List<Usuario> listarUsuarios() {
        return service.listarUsuarios();
    }
}
