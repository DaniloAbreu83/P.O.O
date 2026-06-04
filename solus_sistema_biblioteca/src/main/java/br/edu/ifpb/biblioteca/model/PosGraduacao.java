package br.edu.ifpb.biblioteca.model;

public class PosGraduacao extends Usuario {

    public PosGraduacao(
            int id,
            String nome,
            int emprestimosAtivos,
            boolean bloqueado,
            boolean multaPendente) {

        super(id, nome, emprestimosAtivos, bloqueado, multaPendente);
    }

    @Override
    public int getLimiteEmprestimos() {
        return 5;
    }

    @Override
    public int getPrazoEmprestimo() {
        return 7;
    }

    @Override
    public double getMultaDiaria() {
        return 1.0;
    }
}
