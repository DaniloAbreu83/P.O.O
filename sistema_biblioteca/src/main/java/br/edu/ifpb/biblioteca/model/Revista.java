package br.edu.ifpb.biblioteca.model;

import java.util.Date;

public class Revista {
    private String isbn;
    private String titulo;
    private int volume;
    private int numero;
    private String editora;
    private Date datapublicacao;

    public Revista(String isbn, String titulo, int volume, int numero, String editora, Date datapublicacao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.volume  = volume;
        this.numero = numero;
        this.editora = editora;
        this.datapublicacao = datapublicacao;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getTitulo(){
        return titulo;
    }

    public int getVolume(){
        return volume;
    }

    public int getNumero(){
        return numero;
    }

    public String getEditora(){
        return editora;
    }
    public Date getdataPublicacao(){
        return datapublicacao;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public void setEditora(String editora){
        this.editora = editora;
    }

    public void setdataPublicacao(Date datapublicacao){
        this.datapublicacao = datapublicacao;
    }

    @Override
    public String toString() {
        return "Revista{" +
                "isbn= '" + isbn + '\'' +
                ", titulo= '" + titulo + '\'' +
                ", volume'" + volume + '\'' +
                ", numero= '" + numero + '\'' +
                ", editora= '" + editora +'\'' +
                ", daatapublicacao= '" + datapublicacao + '\'' +
                '}';
    }

}
