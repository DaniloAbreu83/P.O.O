package br.edu.ifpb.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.biblioteca.model.Cd;
import br.edu.ifpb.biblioteca.model.Dvd;
import br.edu.ifpb.biblioteca.model.Editora;
import br.edu.ifpb.biblioteca.model.Jogo;
import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.model.Revista;
import lombok.Data;

@Data

/**
 * Responsável pelo gerenciamento do acervo da biblioteca,
 * incluindo livros, revistas, CDs, DVDs e jogos.
 */
public class AcervoService {

    private List<Livro> livros = new ArrayList<>();
    private List<Cd> cds = new ArrayList<>();
    private List<Dvd> dvds = new ArrayList<>();
    private List<Revista> revistas = new ArrayList<>();
    private List<Jogo> jogos = new ArrayList<>();
    private List<Editora> editoras = new ArrayList<>();

    // -----------------------------
    // ADICIONAR DADOS
    // -----------------------------

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

    public boolean adicionarRevista(Revista revista) {

        if (revista == null) {
            return false;
        }

        for (Revista r : revistas) {

            if (r.getTitulo().equalsIgnoreCase(revista.getTitulo())) {
                return false;
            }
        }

        revistas.add(revista);
        return true;
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

    public boolean adicionarEditora(Editora e) {
        return editoras.add(e);
    }

    // -----------------------------
    // BUSCAR LIVRO
    // -----------------------------
    public List<Livro> buscarLivroPorEditora(String nomeEditora) {

        List<Livro> resultado = new ArrayList<>();

        for (Livro l : livros) {

            if (l.getEditora()
                    .getNome()
                    .replace(" ", "")
                    .equalsIgnoreCase(
                            nomeEditora.replace(" ", ""))) {

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

        for (Cd cd : getCds()) {

            if (cd.getTitulo().equalsIgnoreCase(titulo)) {
                return cd;
            }
        }

        return null;
    }

    public List<Cd> buscarCdPorAutor(String autor) {

        List<Cd> resultado = new ArrayList<>();

        for (Cd cd : getCds()) {

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

        for (Dvd dvd : getDvds()) {

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

    // -----------------------------
    // BUSCAR REVISTA
    // -----------------------------

    public Revista buscarRevistaPorTitulo(String titulo) {

        for (Revista revista : revistas) {

            if (revista.getTitulo().equalsIgnoreCase(titulo)) {
                return revista;
            }
        }

        return null;
    }

    public Revista buscarRevistaPorISSN(String issn) {

        for (Revista revista : getRevistas()) {

            if (revista.getISSN().equalsIgnoreCase(issn)) {
                return revista;
            }
        }

        return null;
    }

    public List<Revista> buscarRevistaPorVolume(int volume) {

        List<Revista> resultado = new ArrayList<>();

        for (Revista revista : getRevistas()) {

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

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Cd> getCds() {
        return cds;
    }

    public List<Dvd> getDvds() {
        return dvds;
    }

    public List<Revista> getRevistas() {
        return revistas;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

}
