package br.edu.ifpb.biblioteca.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Revista {
    private String ISSN;
    private String titulo;
    private int volume;
    private int numero;
    private String editora;
    private LocalDate dataPublicacao;
    private String status;
    @Override
    public String toString() {
        return "Revista{" +
                "ISSN='" + ISSN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", volume=" + volume +
                ", numero=" + numero +
                ", editora='" + editora + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", status='" + status + '\'' +
                '}';
    }

}
