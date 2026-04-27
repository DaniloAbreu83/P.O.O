package br.edu.ifpb.biblioteca.model;

public class cd {
    private String artista;
    private String genero;
    private String listaDeFaixa;

    public cd(String artista, String genero, String listaDeFaixa){
        this.artista = artista;
        this.genero = genero;
        this.listaDeFaixa = listaDeFaixa;
    }

 public String getArtista(){
    return artista;
 }

 public String getGenero(){
    return genero;
 }

 public String getListaDeFaixa(){
    return listaDeFaixa;
 }

 public void setArtista(String artista){
    this.artista = artista;
 }

 public void setGenero(String genero){
    this.genero = genero;
 }

 public void setListaDeFaixa(String listaDeFaixa){
    this.listaDeFaixa = listaDeFaixa;
 }
    @Override
    public String toString() {
        return "cd{" +
                "artista='" + artista + '\'' +
                ", genero='" + genero + '\'' +
                ", listaDeFaixa='" + listaDeFaixa + '\'' +
                '}';
    }

}
