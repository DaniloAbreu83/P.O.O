package br.edu.ifpb.biblioteca.service;

import br.edu.ifpb.biblioteca.model.Emprestimo;
import br.edu.ifpb.biblioteca.model.Usuario;

public class EmprestimoService {
    public boolean realizarEmprestimo(Usuario usuario, Emprestimo emp) {

        // 1. BLOQUEIO POR MULTA / ATRASO
        if (usuario.isBloqueado() || usuario.isMultaPendente()) {
            System.out.println("Erro: usuário possui pendências.");
            return false;
        }

        // 2. VERIFICAR LIMITE DE EMPRÉSTIMOS
        int limite = 0;

        if ("ALUNO".equals(usuario.getTipo())) {
            limite = 3;
        } else if ("PROFESSOR".equals(usuario.getTipo()) || "POS".equals(usuario.getTipo())) {
            limite = 5;
        } else if ("FUNCIONARIO".equals(usuario.getTipo())) {
            limite = 2;
        }

        if (usuario.getEmprestimosAtivos() >= limite) {
            System.out.println("Erro: limite de empréstimos atingido.");
            return false;
        }

        // 3. DEFINIR PRAZO
        int prazo = 0;

        if ("ALUNO".equals(usuario.getTipo())) {
            prazo = 7;
        } else if ("PROFESSOR".equals(usuario.getTipo()) || "POS".equals(usuario.getTipo())) {
            prazo = 14;
        } else if ("FUNCIONARIO".equals(usuario.getTipo())) {
            prazo = 10;
        }

        emp.setPrazoDias(prazo);

        // 4. ATUALIZAR STATUS
        emp.setStatus("EM_ABERTO");

        // 5. ATUALIZAR USUÁRIO
        usuario.setEmprestimosAtivos(usuario.getEmprestimosAtivos() + 1);

        return true;
    }

    // REALIZAR DEVOLUÇÃO

    public void realizarDevolucao(Emprestimo empt, Usuario usuario, int diaAtual) {

        int atraso = diaAtual;
        empt.setDiasAtraso(atraso);

        double valorMulta = 0;

        if ("ALUNO".equals(usuario.getTipo())) {
            valorMulta = atraso * 2.0;
        } else if ("PROFESSOR".equals(usuario.getTipo()) || "POS".equals(usuario.getTipo())) {
            valorMulta = atraso * 1.0;
        } else if ("FUNCIONARIO".equals(usuario.getTipo())) {
            valorMulta = atraso * 1.5;
        }
        empt.setMulta(valorMulta);
        if (valorMulta > 0) {
            empt.setStatusMulta("PENDENTE");
            usuario.setMultaPendente(true);
            usuario.setBloqueado(true);
        } else {
            empt.setStatusMulta("PAGA");
        }

        empt.setStatus("DEVOLVIDO");

        usuario.setEmprestimosAtivos(usuario.getEmprestimosAtivos() - 1);

    }

}
