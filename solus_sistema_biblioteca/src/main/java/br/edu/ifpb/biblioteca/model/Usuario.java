package br.edu.ifpb.biblioteca.model;

import br.edu.ifpb.biblioteca.util.Cores;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

/**
 * Representa um usuário do sistema de biblioteca,
 * contendo informações e regras comuns a todos os tipos.
 */
public abstract class Usuario {
    private int id;
    private String nome;
    private int emprestimosAtivos;
    private boolean bloqueado;
    private boolean multaPendente;

    public Usuario(
            int id,
            String nome,
            int emprestimosAtivos,
            boolean bloqueado,
            boolean multaPendente) {

        this.id = id;
        this.nome = nome;
        this.emprestimosAtivos = emprestimosAtivos;
        this.bloqueado = bloqueado;
        this.multaPendente = multaPendente;
    }

    public abstract int getLimiteEmprestimos();

    public abstract double getMultaDiaria();

    public abstract int getPrazoEmprestimo();

    @Override
    public String toString() {
        return "\n-----------------------------" +
                "\nID: " + id +
                "\nNome: " + nome +
                "\nTipo: " + Cores.CIANO + getClass().getSimpleName() + Cores.RESET +
                "\nEmpréstimos Ativos: " + emprestimosAtivos +
                "\nBloqueado: " + (bloqueado ? Cores.VERMELHO + "SIM" + Cores.RESET : Cores.VERDE + "NÃO" + Cores.RESET) +
                "\nMulta Pendente: " + (multaPendente ? Cores.VERMELHO + "SIM" + Cores.RESET : Cores.VERDE + "NÃO" + Cores.RESET) +
                "\n-----------------------------";
    }
}
