package br.edu.ifpb.biblioteca.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Dvd {
    private String tituloFilme;
    private String diretor;
    private int duracaoMinutos;
    private String classificacaoIndicativa;
    private String status;

    @Override
    public String toString() {
        return "Dvd{" +
                "tituloFilme='" + tituloFilme + '\'' +
                ", diretor='" + diretor + '\'' +
                ", duracaoMinutos=" + duracaoMinutos +
                ", classificacaoIndicativa='" + classificacaoIndicativa + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
