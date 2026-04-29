package br.edu.ifpb.biblioteca.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Dvd {
    private String diretor;
    private int duracaoMinutos;
    private String classificacaoIndicativa;

}
