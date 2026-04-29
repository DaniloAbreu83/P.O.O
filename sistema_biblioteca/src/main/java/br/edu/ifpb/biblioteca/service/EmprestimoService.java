package br.edu.ifpb.biblioteca.service;

import br.edu.ifpb.biblioteca.model.Emprestimo;
import br.edu.ifpb.biblioteca.model.Usuario;

public class EmprestimoService {
    public boolean realizarEmprestimo(Usuario usuario, Emprestimo emp) {

        // 1. BLOQUEIO POR MULTA / ATRASO
        if (usuario.isBloqueado()) {
            System.out.println("Erro: usuário possui multa pendente ou está bloqueado.");
            return false;
        }

        // 2. VERIFICAR LIMITE DE EMPRÉSTIMOS
        int limite = 0;

        if ("aluno".equals(usuario.getTipo())) {
            limite = 3;
        } else if ("professor".equals(usuario.getTipo()) || "pos".equals(usuario.getTipo())) {
            limite = 5;
        } else if ("funcionario".equals(usuario.getTipo())) {
            limite = 2;
        }

        if (usuario.getEmprestimosAtivos() >= limite) {
            System.out.println("Erro: limite de empréstimos atingido.");
            return false;
        }

        // 3. DEFINIR PRAZO
        int prazo = 0;

        if ("aluno".equals(usuario.getTipo())) {
            prazo = 7;
        } else if ("professor".equals(usuario.getTipo()) || "pos".equals(usuario.getTipo())) {
            prazo = 14;
        } else if ("funcionario".equals(usuario.getTipo())) {
            prazo = 10;
        }

        emp.setPrazoDias(prazo);

        // 4. ATUALIZAR STATUS
        emp.setStatus("EM_ABERTO");

        // 5. ATUALIZAR USUÁRIO
        usuario.setEmprestimosAtivos(usuario.getEmprestimosAtivos() + 1);

        // 6. SAÍDA
        System.out.println("Empréstimo realizado com sucesso!");
        System.out.println("Prazo: " + prazo + " dias");

        return true;
    }

    public void realizarDevolucao(Emprestimo empt, Usuario usuario, int diaAtual) {
        int atraso =0;
        if (diaAtual > empt.getPrazoDias()) {
            atraso = diaAtual - empt.getPrazoDias();
        }
        empt.setDiasAtraso(atraso);

        double valorMulta = 0;

        if("aluno".equals(usuario.getTipo())) {
            valorMulta = atraso * 2.0;
        } else if ("professor".equals(usuario.getTipo()) || "pos".equals(usuario.getTipo())) {
            valorMulta = atraso * 1.0;
        } else if ("funcionario".equals(usuario.getTipo())) {
            valorMulta = atraso * 1.5;
        }
        empt.setMulta(valorMulta);

        empt.setStatus("DEVOLVIDO");

        usuario.setEmprestimosAtivos(usuario.getEmprestimosAtivos() - 1);

        if (valorMulta> 0){
            usuario.setBloqueado(true);
        }

        System.out.println("Devolução realizada!");
        System.out.println("Dias de atraso: " + atraso);
        System.out.println("Multa: R$ " + valorMulta);

    }

}
