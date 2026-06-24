package br.edu.ifpb.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.biblioteca.model.Editora;

/**
 * Responsável pelo cadastro e consulta de editoras
 * utilizadas pelos itens do acervo.
 */
public class EditoraService {

    private List<Editora> editoras = new ArrayList<>();

    public boolean adicionarEditora(Editora editora) {

        if (editora == null) {
            return false;
        }

        for (Editora e : editoras) {

            if (e.getCnpj().equals(editora.getCnpj())) {
                return false;
            }
        }

        editoras.add(editora);

        return true;
    }

    public Editora buscarEditoraPorId(int id) {

        for (Editora e : editoras) {

            if (e.getId() == id) {
                return e;
            }
        }

        return null;
    }

    public Editora buscarEditoraPorNome(String nome) {

        for (Editora e : editoras) {

            if (e.getNome().equalsIgnoreCase(nome)) {
                return e;
            }
        }

        return null;
    }

    public List<Editora> listarEditoras() {
        return editoras;
    }
}
