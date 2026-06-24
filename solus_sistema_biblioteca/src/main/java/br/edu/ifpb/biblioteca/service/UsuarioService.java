package br.edu.ifpb.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.biblioteca.model.Usuario;

/**
 * Responsável pelo gerenciamento dos usuários,
 * incluindo cadastro, consulta e regras relacionadas.
 */
public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public boolean adicionarUsuario(Usuario usuario) {

        if (usuario == null) {
            return false;
        }

        for (Usuario u : usuarios) {

            if (u.getId() == usuario.getId()) {
                return false;
            }
        }

        usuarios.add(usuario);

        return true;
    }

    public Usuario buscarUsuario(int id) {

        for (Usuario u : usuarios) {

            if (u.getId() == id) {
                return u;
            }
        }

        return null;
    }

    public List<Usuario> buscarUsuarioPorNome(String nome) {

        List<Usuario> resultado = new ArrayList<>();

        for (Usuario u : usuarios) {

            if (u.getNome().equalsIgnoreCase(nome)) {
                resultado.add(u);
            }
        }

        return resultado;
    }

    public int getTotalUsuarios() {
        return usuarios.size();
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
}
