package br.edu.ifpb.biblioteca.model;

public class Dvd {
    private String diretor;
    private int duracaoMinutos;
    private String classificacaoIndicativa;

    public Dvd(String diretor, int duracaoMinutos, String classificacaoIndicativa) {
        this.diretor = diretor;
        this.duracaoMinutos = duracaoMinutos;
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public String getDiretor() {
        return diretor;
    }

    public int getDuracao(){
        return duracaoMinutos;
    }

    public String getClassificacaoIndicativa(){
        return classificacaoIndicativa;
    }

    public void setDiretor(String diretor){
        this.diretor = diretor;
    }
    public void setDuracao(int duracao){
        this.duracaoMinutos = duracao;
    }
    public void setClassificacaoIndicativa(String classificacaoIndicativa){
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    @Override
    public String toString(){
        return  "Dvd{" +
                "diretor= '" + diretor + '\'' +
                ", duracaoMinutos= '" + duracaoMinutos + '\'' +
                ", classificaIndicativa='" + classificacaoIndicativa + '\'' +
                '}';
    }

}
