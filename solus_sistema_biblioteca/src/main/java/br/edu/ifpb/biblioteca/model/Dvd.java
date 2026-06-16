package br.edu.ifpb.biblioteca.model;

import br.edu.ifpb.biblioteca.util.Cores;
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
    return "\n-----------------------------" +
             "\nID: " + getId() +
            "\nTítulo: " + getTitulo() +
            "\nAutor: " + getAutor() +
            "\nDuração: " + duracaoMinutos + " minutos" +
            "\nClassificação Indicativa: " + classificacaoIndicativa +
            "\nStatus: " +Cores.status(status)+
            "\n-----------------------------";
}
}
