package br.edu.ifpb.biblioteca.service;

import br.edu.ifpb.biblioteca.model.Emprestimo;
import br.edu.ifpb.biblioteca.model.Jogo;
import br.edu.ifpb.biblioteca.model.Livro;
import br.edu.ifpb.biblioteca.model.Revista;
import br.edu.ifpb.biblioteca.model.Usuario;

import java.text.Normalizer;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class EmprestimoService {
    private List<Emprestimo> emprestimos = new ArrayList<>();

    private String normalizarTexto(String texto) {

        if (texto == null) {
            return "";
        }

        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase()
                .trim();
    }

    public boolean realizarEmprestimo(Usuario usuario, Emprestimo emp) {

        if (usuario.isBloqueado() || usuario.isMultaPendente()) {
            System.out.println("Erro: usuário possui pendências.");
            return false;
        }

        if (usuario.getEmprestimosAtivos() >= usuario.getLimiteEmprestimos()) {
            System.out.println("Erro: limite de empréstimos atingido.");
            return false;
        }

        emp.setStatus("EM_ABERTO");

        usuario.setEmprestimosAtivos(
                usuario.getEmprestimosAtivos() + 1);

        return true;
    }

    public boolean realizarEmprestimoLivro(Usuario usuario, Livro livro) {

        if (usuario.isBloqueado() || usuario.isMultaPendente())
            return false;

        if (usuario.getEmprestimosAtivos() >= usuario.getLimiteEmprestimos())
            return false;

        if (!livro.getStatus().equalsIgnoreCase("DISPONIVEL"))
            return false;

        LocalDate hoje = LocalDate.now();

        Emprestimo emp = new Emprestimo(
                emprestimos.size() + 1,
                usuario,
                livro.getTitulo(),
                hoje,
                hoje.plusDays(usuario.getPrazoEmprestimo()),
                null,
                0.0,
                "EM_ABERTO");

        emprestimos.add(emp);

        livro.setStatus("EMPRESTADO");

        usuario.setEmprestimosAtivos(usuario.getEmprestimosAtivos() + 1);

        return true;
    }

    public boolean realizarEmprestimoRevista(
            Usuario usuario,
            Revista revista) {

        if (usuario.isBloqueado() || usuario.isMultaPendente())
            return false;

        if (usuario.getEmprestimosAtivos() >= usuario.getLimiteEmprestimos())
            return false;

        if (!revista.getStatus().equalsIgnoreCase("DISPONIVEL"))
            return false;

        LocalDate hoje = LocalDate.now();

        Emprestimo emp = new Emprestimo(
                emprestimos.size() + 1,
                usuario,
                revista.getTitulo(),
                hoje,
                hoje.plusDays(usuario.getPrazoEmprestimo()),
                null,
                0.0,
                "EM_ABERTO");

        emprestimos.add(emp);

        revista.setStatus("EMPRESTADO");

        usuario.setEmprestimosAtivos(
                usuario.getEmprestimosAtivos() + 1);

        return true;
    }

    public boolean realizarEmprestimoJogo(
            Usuario usuario,
            Jogo jogo) {

        if (usuario.isBloqueado() || usuario.isMultaPendente())
            return false;

        if (usuario.getEmprestimosAtivos() >= usuario.getLimiteEmprestimos())
            return false;

        if (!jogo.getStatus().equalsIgnoreCase("DISPONIVEL"))
            return false;

        LocalDate hoje = LocalDate.now();

        Emprestimo emp = new Emprestimo(
                emprestimos.size() + 1,
                usuario,
                jogo.getNome(),
                hoje,
                hoje.plusDays(usuario.getPrazoEmprestimo()),
                null,
                0.0,
                "EM_ABERTO");

        emprestimos.add(emp);

        jogo.setStatus("EMPRESTADO");

        usuario.setEmprestimosAtivos(
                usuario.getEmprestimosAtivos() + 1);

        return true;
    }

    // REALIZAR DEVOLUÇÃO

    public void realizarDevolucao(Emprestimo emp, Usuario usuario) {

        LocalDate hoje = LocalDate.now();

        emp.setDataDevolucao(hoje);

        long diasAtraso = ChronoUnit.DAYS.between(
                emp.getDataPrevistaDevolucao(),
                hoje);

        if (diasAtraso < 0) {
            diasAtraso = 0;
        }

        double multa = diasAtraso * usuario.getMultaDiaria();

        emp.setMulta(multa);

        if (multa > 0) {
            usuario.setMultaPendente(true);
            usuario.setBloqueado(true);
        }

        emp.setStatus("DEVOLVIDO");

        usuario.setEmprestimosAtivos(
                usuario.getEmprestimosAtivos() - 1);
    }

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

            System.out.println(
                    "Nenhum empréstimo encontrado para este usuário.");
        }
    }

    public Emprestimo buscarEmprestimoAberto(
            int idUsuario,
            String tituloItem) {

        for (Emprestimo e : emprestimos) {

            if (e.getUsuario().getId() == idUsuario
                    && normalizarTexto(e.getTituloItem())
                            .equals(normalizarTexto(tituloItem))
                    && e.getStatus().equals("EM_ABERTO")) {

                return e;
            }
        }

        return null;
    }

}
