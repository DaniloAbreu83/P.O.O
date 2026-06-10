package br.edu.ifpb.biblioteca.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

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
                "\nTipo: " + getClass().getSimpleName() +
                "\nEmpréstimos Ativos: " + emprestimosAtivos +
                "\nBloqueado: " + bloqueado +
                "\nMulta Pendente: " + multaPendente +
                "\n-----------------------------";
    }
}
