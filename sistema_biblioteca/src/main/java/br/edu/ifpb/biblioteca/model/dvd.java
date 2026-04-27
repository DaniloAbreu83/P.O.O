package br.edu.ifpb.biblioteca.model;
import java.time.LocalDate;
public class Dvd {
    private String diretor;
    private LocalDate duracao;
    private String classificacaoIndicativa;

    public Dvd(String diretor, LocalDate duracao, String classificacaoIndicativa) {
        this.diretor = diretor;
        this.duracao = duracao;
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public String getDiretor() {
        return diretor;
    }

    public LocalDate getDuracao(){
        return duracao;
    }

    public String getClassificacaoIndicativa(){
        return classificacaoIndicativa;
    }

    public void setDiretor(String diretor){
        this.diretor = diretor;
    }
    public void setDuracao(LocalDate duracao){
        this.duracao = duracao;
    }
    public void setClassificacaoIndicativa(String classificacaoIndicativa){
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    @Override
    public String toString(){
        return  "Dvd'" +
                "diretor= '" + diretor + '\'' +
                ", duracao= '" + duracao + '\'' +
                ", classificaIndicativa='" + classificacaoIndicativa + '\'' +
                '}';
    }

}
