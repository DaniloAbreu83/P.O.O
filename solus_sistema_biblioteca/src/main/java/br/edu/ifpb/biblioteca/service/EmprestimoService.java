package br.edu.ifpb.biblioteca.service;

import br.edu.ifpb.biblioteca.model.Emprestimo;
import br.edu.ifpb.biblioteca.model.Usuario;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmprestimoService {
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

}
