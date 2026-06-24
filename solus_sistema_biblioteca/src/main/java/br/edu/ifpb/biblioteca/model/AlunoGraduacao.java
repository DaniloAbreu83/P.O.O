package br.edu.ifpb.biblioteca.model;

/**
 * Representa um usuário do tipo aluno,
 * possuindo regras específicas de empréstimo e multa.
 */
public class AlunoGraduacao extends Usuario {

    public AlunoGraduacao(
            int id,
            String nome,
            int emprestimosAtivos,
            boolean bloqueado,
            boolean multaPendente) {

        super(id, nome, emprestimosAtivos, bloqueado, multaPendente);
    }

    @Override
    public int getLimiteEmprestimos() {
        return 3;
    }

    @Override
    public int getPrazoEmprestimo() {
        return 7;
    }

    @Override
    public double getMultaDiaria() {
        return 2.0;
    }
}
