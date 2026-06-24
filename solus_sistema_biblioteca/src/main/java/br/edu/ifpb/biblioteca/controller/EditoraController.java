package br.edu.ifpb.biblioteca.controller;

import java.util.List;

import br.edu.ifpb.biblioteca.model.Editora;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

/**
 * Controlador responsável por intermediar as operações
 * relacionadas às editoras cadastradas.
 */
public class EditoraController {

     private BibliotecaService service;

    public EditoraController(BibliotecaService service) {
        this.service = service;
    }

    public boolean adicionarEditora(Editora editora) {
        return service.adicionarEditora(editora);
    }

    public Editora buscarEditoraPorId(int id) {
        return service.buscarEditoraPorId(id);
    }

    public Editora buscarEditoraPorNome(String nome) {
        return service.buscarEditoraPorNome(nome);
    }

    public List<Editora> listarEditoras() {
        return service.listarEditoras();
    }
}
