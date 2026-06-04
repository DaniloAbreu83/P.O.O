package br.edu.ifpb.biblioteca.service;

import br.edu.ifpb.biblioteca.model.Usuario;
import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.model.Emprestimo;
import br.edu.ifpb.biblioteca.model.Cd;
import br.edu.ifpb.biblioteca.model.Dvd;
import br.edu.ifpb.biblioteca.model.Revista;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class BibliotecaService {

    private List<Usuario> usuarios = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private List<Cd> cds = new ArrayList<>();
    private List<Dvd> dvds = new ArrayList<>();
    private List<Revista> revistas = new ArrayList<>();

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

    public boolean adicionarCd(Cd cd) {
        if (cd == null) {
            return false;
        }
        for (Cd c : cds) {
            if (c.getTitulo().equalsIgnoreCase(cd.getTitulo())) {
                return false;
            }
        }
        cds.add(cd);
        return true;
    }

    public boolean adicionarDvd(Dvd dvd) {
        if (dvd == null) {
            return false;
        }
        for (Dvd d : dvds) {
            if (d.getTitulo().equalsIgnoreCase(dvd.getTitulo())) {
                return false;
            }
        }
        dvds.add(dvd);
        return true;
    }

    public boolean adicionarRevista(Revista revista) {
        if (revista == null) {
            return false;
        }

        for (Revista r : revistas)
            if (r.getISSN().equals(revista.getISSN())) {
                return false;
            }
        revistas.add(revista);
        return true;
    }

    // -----------------------------
    // BUSCAR USUÁRIO
    // -----------------------------
    public Usuario buscarUsuario(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public List<Usuario> buscarUsuario(String nome) {

        List<Usuario> resultado = new ArrayList<>();

        for (Usuario u : usuarios) {

            if (u.getNome().equalsIgnoreCase(nome)) {
                resultado.add(u);
            }
        }

        return resultado;
    }

    // -----------------------------
    // BUSCAR LIVRO
    // -----------------------------
    public Livro buscarLivro(String titulo, String ISBN) {
        for (Livro l : livros) {
            if (titulo != null && l.getTitulo().equalsIgnoreCase(titulo)
                    ||
                    (ISBN != null && l.getISBN().equals(ISBN))) {
                return l;
            }
        }
        return null;
    }

    // -----------------------------
    // BUSCAR CD
    // -----------------------------
    public Cd buscarCd(String titulo, String autor) {

        for (Cd cd : cds) {

            if ((titulo != null && cd.getTitulo().equalsIgnoreCase(titulo))
                    ||
                    (autor != null && cd.getAutor().equalsIgnoreCase(autor))) {

                return cd;
            }
        }

        return null;
    }

    // -----------------------------
    // BUSCAR DVD
    // -----------------------------
    public Dvd buscarDvd(String titulo) {

        for (Dvd dvd : dvds) {

            if (dvd.getTitulo().equalsIgnoreCase(titulo)) {
                return dvd;
            }
        }

        return null;
    }

    // -----------------------------
    // BUSCAR REVISTA
    // -----------------------------
    public Revista buscarRevista(String ISSN, String titulo, int volume) {
        for (Revista revista : revistas) {
            if ((ISSN != null && revista.getISSN().equalsIgnoreCase(ISSN))
                    ||
                    (titulo != null && revista.getTitulo().equalsIgnoreCase(titulo))
                    ||
                    (volume > 0 && revista.getVolume() == volume)) {
                return revista;
            }
        }
        return null;
    }

    // -----------------------------
    // REALIZAR EMPRÉSTIMO (UC3)
    // -----------------------------
    public boolean realizarEmprestimo(int idUsuario, String tituloLivro, String ISBN) {

        // 1. Buscar usuário
        Usuario usuario = buscarUsuario(idUsuario);

        if (usuario == null) {
            return false;
        }

        // 2. Verificar se está bloqueado
        if (usuario.isBloqueado() || usuario.isMultaPendente()) {
            return false;
        }

        // 3. Verificar limite de empréstimos
        int limite = usuario.getLimiteEmprestimos();

        if (usuario.getEmprestimosAtivos() >= limite) {
            return false;
        }

        // 4. Buscar livro
        Livro livro = buscarLivro(tituloLivro, ISBN);

        if (livro == null) {
            return false;
        }

        if (!livro.getStatus().equalsIgnoreCase("DISPONIVEL")) {
            return false;
        }

        // 5. Definir prazo
        EmprestimoService emprestimoService = new EmprestimoService();

        int prazo = usuario.getPrazoEmprestimo();

        LocalDate hoje = LocalDate.now();

        Emprestimo e = new Emprestimo(
                emprestimos.size() + 1,
                usuario,
                livro.getTitulo(),
                hoje,
                hoje.plusDays(prazo),
                null,
                0.0,
                "EM_ABERTO");

        // 6. Realizar empréstimo
        boolean sucesso = emprestimoService.realizarEmprestimo(usuario, e);

        if (sucesso) {
            emprestimos.add(e);
            livro.setStatus("EMPRESTADO");
            return true;
        }

        return false;
    }

    // REGISTRAR DEVOLUÇÃO (UC4)

    public Emprestimo registrarDevolucao(int idUsuario, String tituloLivro, String ISBN, int diasAtraso) {

        Usuario usuario = buscarUsuario(idUsuario);

        for (Emprestimo e : emprestimos) {

            if (e.getUsuario().getId() == idUsuario &&
                    e.getTituloItem().equalsIgnoreCase(tituloLivro) &&
                    e.getStatus().equals("EM_ABERTO")) {

                EmprestimoService emprestimoService = new EmprestimoService();
                emprestimoService.realizarDevolucao(
                        e,
                        usuario);

                return e;
            }
        }
        return null;
    }

    // CONSULTAR EMPRESTIMO
    public void listarEmprestimosEmAberto() {
        for (Emprestimo e : emprestimos) {
            if (e.getStatus().equals("EM_ABERTO")) {
                System.out.println(e);
            }
        }
    }

    /*public void listarEmprestimosEmAtraso() {
        for (Emprestimo e : emprestimos) {
            if (e.getDiasAtraso() > 0 && e.getStatus().equals("EM_ABERTO")) {
                System.out.println(e);
            }
        }
    } */

    public void listarHistoricoUsuario(int idUsuario) {
        for (Emprestimo e : emprestimos) {
            if (e.getUsuario().getId() == idUsuario
                    && e.getStatus().equals("DEVOLVIDO")) {

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

            if (l.getEditora().getNome().equalsIgnoreCase(editora)) {
                resultado.add(l);
            }
        }

        return resultado;
    }

    public List<Livro> buscarLivroPorAutor(String autor) {
        List<Livro> resultado = new ArrayList<>();

        for (Livro l : livros) {
            if (l.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(l);
            }
        }

        return resultado;
    }

}
