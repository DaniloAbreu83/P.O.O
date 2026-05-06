package br.edu.ifpb.biblioteca.service;

import br.edu.ifpb.biblioteca.model.Usuario;
import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.model.Emprestimo;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {

    private List<Usuario> usuarios = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    // -----------------------------
    // ADICIONAR DADOS
    // -----------------------------
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

    public boolean adicionarLivro(Livro livro) {
        if (livro == null) {
            return false;
        }
        for (Livro l : livros) {
            if (l.getISBN().equals(livro.getISBN())) {
                return false;
            }
        }
        livros.add(livro);
        return true;
    }

    // -----------------------------
    // BUSCAR USUÁRIO
    // -----------------------------
    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    // -----------------------------
    // BUSCAR LIVRO
    // -----------------------------
    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l;
            }
        }
        return null;
    }

    // -----------------------------
    // REALIZAR EMPRÉSTIMO (UC3)
    // -----------------------------
    public boolean realizarEmprestimo(int idUsuario, String tituloLivro) {

        // 1. Buscar usuário
        Usuario usuario = buscarUsuarioPorId(idUsuario);

        if (usuario == null) {
            return false;
        }

        // 2. Verificar se está bloqueado
        if (usuario.isBloqueado() || usuario.isMultaPendente()) {
            return false;
        }

        int limite = 0;

        if (usuario.getTipo().equalsIgnoreCase("ALUNO")) {
            limite = 3;
        } else if (usuario.getTipo().equalsIgnoreCase("PROFESSOR")) {
            limite = 5;
        } else if (usuario.getTipo().equalsIgnoreCase("FUNCIONARIO")) {
            limite = 2;
        }

        // 3. Verificar limite (simples: 3)
        if (usuario.getEmprestimosAtivos() >= limite) {
            return false;
        }

        // 4. Buscar livro
        Livro livro = buscarLivroPorTitulo(tituloLivro);

        if (livro == null) {
            return false;
        }
        if (!livro.getStatus().equalsIgnoreCase("DISPONIVEL")) {
            return false;
        }

        EmprestimoService emprestimoService = new EmprestimoService();

        int prazo = 0;

        if (usuario.getTipo().equalsIgnoreCase("ALUNO")) {
            prazo = 7;
        } else if (usuario.getTipo().equalsIgnoreCase("PROFESSOR")) {
            prazo = 14;
        } else if (usuario.getTipo().equalsIgnoreCase("FUNCIONARIO")) {
            prazo = 10;
        }

        // 5. Criar empréstimo
        Emprestimo e = new Emprestimo(
                idUsuario,
                tituloLivro,
                "Livro",
                prazo,
                0,
                0.0,
                "EM_ABERTO",
                "PENDENTE");
        boolean sucesso = emprestimoService.realizarEmprestimo(usuario, e);
        if (sucesso) {
            emprestimos.add(e);
            livro.setStatus("EMPRESTADO");
            return true;
        } else {
            return false;
        }
    }

    public Emprestimo registrarDevolucao(int idUsuario, String tituloLivro, int diasAtraso) {

        Usuario usuario = buscarUsuarioPorId(idUsuario);

        for (Emprestimo e : emprestimos) {

            if (e.getIdUsuario() == idUsuario &&
                    e.getTituloItem().equalsIgnoreCase(tituloLivro) &&
                    e.getStatus().equals("EM_ABERTO")) {

                EmprestimoService emprestimoService = new EmprestimoService();
                emprestimoService.realizarDevolucao(e, usuario, diasAtraso);

                return e;
            }
        }
        return null;
    }

    public void listarEmprestimosEmAberto() {
        for (Emprestimo e : emprestimos) {
            if (e.getStatus().equals("EM_ABERTO")) {
                System.out.println(e);
            }
        }
    }

    public void listarEmprestimosEmAtraso() {
        for (Emprestimo e : emprestimos) {
            if (e.getDiasAtraso() > 0 && e.getStatus().equals("EM_ABERTO")) {
                System.out.println(e);
            }
        }
    }

    public void listarHistoricoUsuario(int idUsuario) {
        for (Emprestimo e : emprestimos) {
            if (e.getIdUsuario() == idUsuario && e.getStatus().equals("DEVOLVIDO")) {
                System.out.println(e);
            }
        }
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

    public Livro buscarLivroPorISBN(String isbn) {
        for (Livro l : livros) {
            if (l.getISBN().equalsIgnoreCase(isbn)) {
                return l;
            }
        }
        return null;
    }

    public List<Livro> buscarLivroPorEditora(String editora) {
        List<Livro> resultado = new ArrayList<>();

        for (Livro l : livros) {
            if (l.getEditora().equalsIgnoreCase(editora)) {
                resultado.add(l);
            }
        }

        return resultado;
    }

}
