package br.edu.ifpb.biblioteca.model;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)

public class Dvd extends Item{
       
    private int duracaoMinutos;
    private String classificacaoIndicativa;
    private String status;

    public Dvd(int id, String titulo, String autor, int duracaoMinutos, String classificacaoIndicativa, String status) {
        super(id, titulo, autor);
        
        this.duracaoMinutos = duracaoMinutos;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.status = status;
    }

    @Override
public String toString() {
    return "Dvd{" +
            "id=" + getId() +
            ", titulo='" + getTitulo() + '\'' +
            ", autor='" + getAutor() + '\'' +
            ", duracao=" + duracaoMinutos +
            ", classificacao='" + classificacaoIndicativa + '\'' +
            ", status='" + status + '\'' +
            '}';
}
}
