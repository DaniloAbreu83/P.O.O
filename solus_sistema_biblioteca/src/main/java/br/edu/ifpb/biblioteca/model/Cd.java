package br.edu.ifpb.biblioteca.model;

public class Cd {
    private String artista;
    private String genero;
    private String listaDeFaixa;
    private String album;
    private String status;

    public Cd(String artista, String genero, String listaDeFaixa, String album, String status){
        this.artista = artista;
        this.genero = genero;
        this.listaDeFaixa = listaDeFaixa;
        this.album = album;
        this.status = "DISPONIVEL";

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

 public String getStatus(){
    return status;
}

public String getAlbum() {
   return album;
 }

 public void setArtista(String artista){
    this.artista = artista;
 }

 public void setGenero(String genero){
    this.genero = genero;
 }

 public void setStatus(String status) {
    this.status = status;
 }

 public void setAlbum(String album) {
      this.album = album;
 }

 public void setListaDeFaixa(String listaDeFaixa){
    this.listaDeFaixa = listaDeFaixa;
 }
    @Override
    public String toString() {
        return "Cd{" +
                "artista='" + artista + '\'' +
                ", genero='" + genero + '\'' +
                ", listaDeFaixa='" + listaDeFaixa + '\'' +
                ", album='" + album + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
