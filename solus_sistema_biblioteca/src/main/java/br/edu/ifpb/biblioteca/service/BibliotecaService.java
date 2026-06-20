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
import br.edu.ifpb.biblioteca.service.EditoraService;

import java.util.ArrayList;
import java.util.List;
import java.text.Normalizer;
import java.time.LocalDate;

public class BibliotecaService {

    private UsuarioService usuarioService = new UsuarioService();
    private List<Livro> livros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private List<Cd> cds = new ArrayList<>();
    private List<Dvd> dvds = new ArrayList<>();
    private List<Revista> revistas = new ArrayList<>();
    private EditoraService editoraService = new EditoraService();
    private List<Jogo> jogos = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();

    private String normalizarTexto(String texto) {

        if (texto == null) {
            return "";
        }

        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase()
                .trim();
    }

    // -----------------------------
    // ADICIONAR DADOS
    // -----------------------------
    public boolean adicionarUsuario(Usuario usuario) {
        return usuarioService.adicionarUsuario(usuario);
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

    public boolean adicionarEditora(Editora editora) {
        return editoraService.adicionarEditora(editora);
    }

    public boolean adicionarJogo(Jogo jogo) {

        if (jogo == null) {
            return false;
        }

        for (Jogo j : jogos) {

            if (j.getId() == jogo.getId()) {
                return false;
            }
        }

        jogos.add(jogo);

        return true;
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

        List<Livro> resultado = new ArrayList<>();

        for (Livro l : livros) {

            if (l.getEditora()
                    .getNome()
                    .equalsIgnoreCase(nomeEditora)) {

                resultado.add(l);
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

    public Livro buscarLivroPorTitulo(String titulo) {

        for (Livro l : livros) {

            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l;
            }
        }

        return null;
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

    // -----------------------------
    // BUSCAR CD
    // -----------------------------
    public Cd buscarCdPorTitulo(String titulo) {

        for (Cd cd : cds) {

            if (cd.getTitulo().equalsIgnoreCase(titulo)) {
                return cd;
            }
        }

        return null;
    }

    public List<Cd> buscarCdPorAutor(String autor) {

        List<Cd> resultado = new ArrayList<>();

        for (Cd cd : cds) {

            if (cd.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(cd);
            }
        }

        return resultado;
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

        for (Revista revista : revistas) {

            if (revista.getISSN().equalsIgnoreCase(issn)) {
                return revista;
            }
        }

        return null;
    }

    public Revista buscarRevistaPorTitulo(String titulo) {

        for (Revista revista : revistas) {

            if (revista.getTitulo().equalsIgnoreCase(titulo)) {
                return revista;
            }
        }

        return null;
    }

    public List<Revista> buscarRevistaPorVolume(int volume) {

        List<Revista> resultado = new ArrayList<>();

        for (Revista revista : revistas) {

            if (revista.getVolume() == volume) {
                resultado.add(revista);
            }
        }

        return resultado;
    }

    // -----------------------------
    // BUSCAR JOGO
    // -----------------------------

    public Jogo buscarJogoPorId(int id) {

        for (Jogo j : jogos) {

            if (j.getId() == id) {
                return j;
            }
        }

        return null;
    }

    public Jogo buscarJogoPorNome(String nome) {

        for (Jogo jogo : jogos) {

            if (jogo.getNome().equalsIgnoreCase(nome)) {
                return jogo;
            }
        }

        return null;
    }

    // -----------------------------
    // VENDAS DE JOGOS (UC11)
    // -----------------------------

    public boolean realizarVendaJogo(int idJogo) {

        Jogo jogo = buscarJogoPorId(idJogo);

        if (jogo == null) {
            return false;
        }

        if (!jogo.getStatus().equalsIgnoreCase("DISPONIVEL")) {
            return false;
        }

        Venda venda = new Venda(
                vendas.size() + 1,
                jogo,
                jogo.getPreco(),
                LocalDate.now());

        vendas.add(venda);

        jogo.setStatus("VENDIDO");

        return true;
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
        Livro livro = null;

        if (ISBN != null && !ISBN.isBlank()) {
            livro = buscarLivroPorISBN(ISBN);
        } else {
            livro = buscarLivroPorTitulo(tituloLivro);
        }

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

    public boolean realizarEmprestimoRevista(
            int idUsuario,
            String tituloRevista) {

        Usuario usuario = buscarUsuario(idUsuario);

        if (usuario == null) {
            return false;
        }

        if (usuario.isBloqueado() || usuario.isMultaPendente()) {
            return false;
        }

        if (usuario.getEmprestimosAtivos() >= usuario.getLimiteEmprestimos()) {
            return false;
        }

        Revista revista = buscarRevistaPorTitulo(tituloRevista);

        if (revista == null) {
            return false;
        }

        if (!revista.getStatus().equalsIgnoreCase("DISPONIVEL")) {
            return false;
        }

        LocalDate hoje = LocalDate.now();

        Emprestimo e = new Emprestimo(
                emprestimos.size() + 1,
                usuario,
                revista.getTitulo(),
                hoje,
                hoje.plusDays(usuario.getPrazoEmprestimo()),
                null,
                0.0,
                "EM_ABERTO");

        EmprestimoService emprestimoService = new EmprestimoService();

        boolean sucesso = emprestimoService.realizarEmprestimo(usuario, e);

        if (sucesso) {
            emprestimos.add(e);
            revista.setStatus("EMPRESTADO");
            return true;
        }

        return false;
    }

    public boolean realizarEmprestimoJogo(int idUsuario, int idJogo) {

        Usuario usuario = buscarUsuario(idUsuario);

        if (usuario == null) {
            return false;
        }

        if (usuario.isBloqueado() || usuario.isMultaPendente()) {
            return false;
        }

        if (usuario.getEmprestimosAtivos() >= usuario.getLimiteEmprestimos()) {
            return false;
        }

        Jogo jogo = buscarJogoPorId(idJogo);

        if (jogo == null) {
            return false;
        }

        if (!jogo.getStatus().equalsIgnoreCase("DISPONIVEL")) {
            return false;
        }

        LocalDate hoje = LocalDate.now();

        Emprestimo e = new Emprestimo(
                emprestimos.size() + 1,
                usuario,
                jogo.getNome(),
                hoje,
                hoje.plusDays(usuario.getPrazoEmprestimo()),
                null,
                0.0,
                "EM_ABERTO");

        EmprestimoService emprestimoService = new EmprestimoService();

        boolean sucesso = emprestimoService.realizarEmprestimo(usuario, e);

        if (sucesso) {
            emprestimos.add(e);
            jogo.setStatus("EMPRESTADO");
            return true;
        }

        return false;
    }

    // REGISTRAR DEVOLUÇÃO (UC4)

    public Emprestimo registrarDevolucao(
            int idUsuario,
            String tituloLivro) {

        Usuario usuario = buscarUsuario(idUsuario);

        if (usuario == null) {
            return null;
        }

        for (Emprestimo e : emprestimos) {

            if (e.getUsuario().getId() == idUsuario
                    && normalizarTexto(e.getTituloItem())
                            .equals(normalizarTexto(tituloLivro))
                    && e.getStatus().equals("EM_ABERTO")) {

                EmprestimoService emprestimoService = new EmprestimoService();

                emprestimoService.realizarDevolucao(e, usuario);
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

    public void listarHistoricoUsuario(int idUsuario) {

        boolean encontrou = false;

        for (Emprestimo e : emprestimos) {

            if (e.getUsuario().getId() == idUsuario) {

                System.out.println(e);
                encontrou = true;
            }
        }

        if (!encontrou) {

            System.out.println("Nenhum empréstimo encontrado para este usuário.");
        }
    }

    // ======================================================
    // DASHBOARD / ESTATÍSTICAS
    // ======================================================

    public int getTotalUsuarios() {
        return usuarioService.getTotalUsuarios();
    }

    public int getTotalEmprestimosEmAberto() {

        int total = 0;

        for (Emprestimo e : emprestimos) {

            if (e.getStatus().equalsIgnoreCase("EM_ABERTO")) {
                total++;
            }
        }

        return total;
    }

    public int getTotalItensDisponiveis() {

        int total = 0;

        for (Livro livro : livros) {

            if (livro.getStatus().equalsIgnoreCase("DISPONIVEL")) {
                total++;
            }
        }

        for (Cd cd : cds) {

            if (cd.getStatus().equalsIgnoreCase("DISPONIVEL")) {
                total++;
            }
        }

        for (Dvd dvd : dvds) {

            if (dvd.getStatus().equalsIgnoreCase("DISPONIVEL")) {
                total++;
            }
        }

        for (Revista revista : revistas) {

            if (revista.getStatus().equalsIgnoreCase("DISPONIVEL")) {
                total++;
            }
        }

        for (Jogo jogo : jogos) {

            if (jogo.getStatus().equalsIgnoreCase("DISPONIVEL")) {
                total++;
            }
        }

        return total;
    }

    // ======================================================
    // LISTAGENS GERAIS
    // ======================================================

    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public List<Cd> listarCds() {
        return cds;
    }

    public List<Dvd> listarDvds() {
        return dvds;
    }

    public List<Revista> listarRevistas() {
        return revistas;
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }

    public List<Editora> listarEditoras() {
        return editoraService.listarEditoras();
    }

    public List<Jogo> listarJogos() {
        return jogos;
    }

    public List<Venda> listarVendas() {
        return vendas;
    }

}
