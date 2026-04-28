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
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
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
    public void realizarEmprestimo(int idUsuario, String tituloLivro) {

        // 1. Buscar usuário
        Usuario usuario = buscarUsuarioPorId(idUsuario);

        if (usuario == null) {
            System.out.println("Usuário não encontrado");
            return;
        }

        // 2. Verificar se está bloqueado
        if (usuario.isBloqueado()) {
            System.out.println("Usuário está bloqueado");
            return;
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
            System.out.println("Limite de empréstimos atingido");
            return;
        }

        // 4. Buscar livro
        Livro livro = buscarLivroPorTitulo(tituloLivro);

        if (livro == null) {
            System.out.println("Livro não encontrado");
            return;
        }

        // 5. Criar empréstimo
        Emprestimo e = new Emprestimo(
                idUsuario,
                tituloLivro,
                "Livro",
                7,
                0,
                0.0,
                "EM_ABERTO");

        // 6. Salvar empréstimo
        emprestimos.add(e);

        // 7. Atualizar usuário
        usuario.setEmprestimosAtivos(usuario.getEmprestimosAtivos() + 1);

        System.out.println("Empréstimo realizado com sucesso!");
    }

    public void registrarDevolucao(int idUsuario, String tituloLivro, int diasAtraso) {

        Usuario usuario = buscarUsuarioPorId(idUsuario);

        for (Emprestimo e : emprestimos) {

            if (e.getIdUsuario() == idUsuario &&
                    e.getTituloItem().equalsIgnoreCase(tituloLivro) &&
                    e.getStatus().equals("EM_ABERTO")) {

                // calcular atraso
                                
                double valorMultaPorDia = 0;

                if (usuario.getTipo().equalsIgnoreCase("ALUNO")) {
                    valorMultaPorDia = 2.0;
                } else if (usuario.getTipo().equalsIgnoreCase("PROFESSOR")) {
                    valorMultaPorDia = 1.0;
                } else if (usuario.getTipo().equalsIgnoreCase("FUNCIONARIO")) {
                    valorMultaPorDia = 1.5;
                }

                double multa = diasAtraso * valorMultaPorDia;

                // atualizar empréstimo
                e.setDiasAtraso(diasAtraso);
                e.setMulta(multa);
                e.setStatus("DEVOLVIDO");

                // atualizar usuário
                
                usuario.setEmprestimosAtivos(usuario.getEmprestimosAtivos() - 1);

                System.out.println("Devolução realizada!");
                System.out.println("Multa: R$ " + multa);

                return;
            }
        }

        System.out.println("Empréstimo não encontrado");
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
        if (e.getIdUsuario() == idUsuario) {
            System.out.println(e);
        }
    }
}

}
