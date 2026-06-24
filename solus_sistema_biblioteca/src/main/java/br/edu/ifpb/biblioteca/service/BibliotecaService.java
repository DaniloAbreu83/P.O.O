package br.edu.ifpb.biblioteca.service;

import br.edu.ifpb.biblioteca.model.Usuario;
import br.edu.ifpb.biblioteca.model.Venda;
import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.model.Emprestimo;
import br.edu.ifpb.biblioteca.model.Jogo;
import br.edu.ifpb.biblioteca.model.Cd;
import br.edu.ifpb.biblioteca.model.Dvd;
import br.edu.ifpb.biblioteca.model.Editora;
import br.edu.ifpb.biblioteca.model.Revista;
import br.edu.ifpb.biblioteca.util.Cores;

import java.util.List;

/**
 * Serviço principal do sistema.
 * Centraliza e coordena as operações de usuários,
 * acervo, editoras, empréstimos e vendas.
 */
public class BibliotecaService {

    private UsuarioService usuarioService = new UsuarioService();
    private AcervoService acervoService = new AcervoService();
    private EditoraService editoraService = new EditoraService();
    private VendaService vendaService = new VendaService();
    private EmprestimoService emprestimoService = new EmprestimoService();

    // -----------------------------
    // ADICIONAR DADOS
    // -----------------------------
    public boolean adicionarUsuario(Usuario usuario) {
        return usuarioService.adicionarUsuario(usuario);
    }

    public boolean adicionarLivro(Livro livro) {
        return acervoService.adicionarLivro(livro);
    }

    public boolean adicionarCd(Cd cd) {
        return acervoService.adicionarCd(cd);
    }

    public boolean adicionarDvd(Dvd dvd) {
        return acervoService.adicionarDvd(dvd);
    }

    public boolean adicionarRevista(Revista revista) {
        return acervoService.adicionarRevista(revista);
    }

    public boolean adicionarJogo(Jogo jogo) {
        return acervoService.adicionarJogo(jogo);
    }

    public boolean adicionarEditora(Editora editora) {
        return editoraService.adicionarEditora(editora);
    }

    // -----------------------------
    // BUSCAR USUÁRIO
    // -----------------------------
    public Usuario buscarUsuario(int id) {
        return usuarioService.buscarUsuario(id);
    }

    public List<Usuario> buscarUsuarioPorNome(String nome) {
        return usuarioService.buscarUsuarioPorNome(nome);
    }

    // -----------------------------
    // BUSCAR LIVRO
    // -----------------------------
    public List<Livro> buscarLivroPorEditora(String nomeEditora) {
        return acervoService.buscarLivroPorEditora(nomeEditora);
    }

    public Livro buscarLivroPorISBN(String isbn) {
        return acervoService.buscarLivroPorISBN(isbn);
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        return acervoService.buscarLivroPorTitulo(titulo);
    }

    public List<Livro> buscarLivroPorAutor(String autor) {
        return acervoService.buscarLivroPorAutor(autor);
    }

    // -----------------------------
    // BUSCAR CD
    // -----------------------------
    public Cd buscarCdPorTitulo(String titulo) {
        return acervoService.buscarCdPorTitulo(titulo);
    }

    public List<Cd> buscarCdPorAutor(String autor) {
        return acervoService.buscarCdPorAutor(autor);
    }

    // -----------------------------
    // BUSCAR DVD
    // -----------------------------
    public Dvd buscarDvd(String titulo) {
        return acervoService.buscarDvd(titulo);
    }

    // ------------------------------
    // BUSCAR EDITORA
    // ------------------------------

    public Editora buscarEditoraPorId(int id) {
        return editoraService.buscarEditoraPorId(id);
    }

    public Editora buscarEditoraPorNome(String nome) {
        return editoraService.buscarEditoraPorNome(nome);
    }

    // -----------------------------
    // BUSCAR REVISTA
    // -----------------------------
    public Revista buscarRevistaPorISSN(String issn) {
        return acervoService.buscarRevistaPorISSN(issn);
    }

    public Revista buscarRevistaPorTitulo(String titulo) {
        return acervoService.buscarRevistaPorTitulo(titulo);
    }

    public List<Revista> buscarRevistaPorVolume(int volume) {
        return acervoService.buscarRevistaPorVolume(volume);
    }
    // -----------------------------
    // BUSCAR JOGO
    // -----------------------------

    public Jogo buscarJogoPorId(int id) {
        return acervoService.buscarJogoPorId(id);
    }

    public Jogo buscarJogoPorNome(String nome) {
        return acervoService.buscarJogoPorNome(nome);
    }

    // -----------------------------
    // VENDAS DE JOGOS (UC11)
    // -----------------------------

    public boolean realizarVendaJogo(int idJogo) {

        Jogo jogo = buscarJogoPorId(idJogo);

        return vendaService.realizarVendaJogo(jogo);
    }

    // 6. Realizar empréstimo
    public boolean realizarEmprestimoLivro(int idUsuario, String isbn) {

        Usuario usuario = usuarioService.buscarUsuario(idUsuario);
        Livro livro = acervoService.buscarLivroPorISBN(isbn);

        if (usuario == null || livro == null)
            return false;

        return emprestimoService.realizarEmprestimoLivro(usuario, livro);
    }

    public boolean realizarEmprestimoLivroPorTitulo(
            int idUsuario,
            String titulo) {

        Usuario usuario = usuarioService.buscarUsuario(idUsuario);
        if (usuario == null) {
            Cores.info("[INFO] Usuário não encontrado.");
            return false;
        }

        Livro livro = acervoService.buscarLivroPorTitulo(titulo);

        if (livro == null) {
            Cores.info("[INFO] Livro não encontrado.");
            return false;
        }

        return emprestimoService.realizarEmprestimoLivro(
                usuario,
                livro);
    }

    public boolean realizarEmprestimoRevista(int idUsuario, String titulo) {

        Usuario usuario = usuarioService.buscarUsuario(idUsuario);
        Revista revista = acervoService.buscarRevistaPorTitulo(titulo);

        if (usuario == null) {
            Cores.info("[INFO] Usuário não encontrado.");
            return false;
        }

        if (revista == null) {
            Cores.info("[INFO] Revista não encontrada.");
            return false;
        }

        return emprestimoService.realizarEmprestimoRevista(
                usuario,
                revista);
    }

    public boolean realizarEmprestimoJogo(int idUsuario, int idJogo) {

        Usuario usuario = usuarioService.buscarUsuario(idUsuario);
        Jogo jogo = acervoService.buscarJogoPorId(idJogo);

        if (usuario == null) {
            Cores.info("[INFO] Usuário não encontrado.");
            return false;
        }

        if (jogo == null) {
            Cores.info("[INFO] Jogo não encontrado.");
            return false;
        }

        return emprestimoService.realizarEmprestimoJogo(
                usuario,
                jogo);
    }

    // REGISTRAR DEVOLUÇÃO (UC4)

    public Emprestimo registrarDevolucao(
            int idUsuario,
            String tituloLivro) {

        Usuario usuario = buscarUsuario(idUsuario);

        if (usuario == null) {
            Cores.info("[INFO] Usuário não encontrado.");
            return null;
        }

        Emprestimo e = emprestimoService.buscarEmprestimoAberto(
                idUsuario,
                tituloLivro);

        if (e == null) {
            Cores.info("[INFO] Empréstimo não encontrado.");
            return null;
        }

        emprestimoService.realizarDevolucao(
                e,
                usuario);

        Livro livro = buscarLivroPorTitulo(
                e.getTituloItem());

        if (livro != null) {

            livro.setStatus("DISPONIVEL");

        } else {

            Revista revista = buscarRevistaPorTitulo(
                    e.getTituloItem());

            if (revista != null) {

                revista.setStatus("DISPONIVEL");

            } else {

                Jogo jogo = buscarJogoPorNome(
                        e.getTituloItem());

                if (jogo != null) {

                    jogo.setStatus("DISPONIVEL");
                }
            }
        }

        return e;
    }

    // CONSULTAR EMPRESTIMO
    public void listarEmprestimosEmAberto() {
        emprestimoService.listarEmprestimosEmAberto();
    }

    public void listarHistoricoUsuario(int idUsuario) {
        emprestimoService.listarHistoricoUsuario(idUsuario);
    }

    // ======================================================
    // DASHBOARD / ESTATÍSTICAS
    // ======================================================

    public int getTotalUsuarios() {
        return usuarioService.getTotalUsuarios();
    }

    public int getTotalEmprestimosEmAberto() {

        int total = 0;

        for (Emprestimo e : emprestimoService.getEmprestimos()) {

            if (e.getStatus().equalsIgnoreCase("EM_ABERTO")) {
                total++;
            }
        }

        return total;
    }

    public int getTotalItensDisponiveis() {
        return acervoService.getTotalItensDisponiveis();
    }

    // ======================================================
    // LISTAGENS GERAIS
    // ======================================================

    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    public List<Livro> listarLivros() {
        return acervoService.getLivros();
    }

    public List<Cd> listarCds() {
        return acervoService.getCds();
    }

    public List<Dvd> listarDvds() {
        return acervoService.getDvds();
    }

    public List<Revista> listarRevistas() {
        return acervoService.getRevistas();
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimoService.getEmprestimos();
    }

    public List<Editora> listarEditoras() {
        return editoraService.listarEditoras();
    }

    public List<Jogo> listarJogos() {
        return acervoService.getJogos();
    }

    public List<Venda> listarVendas() {
        return vendaService.listarVendas();
    }

}
