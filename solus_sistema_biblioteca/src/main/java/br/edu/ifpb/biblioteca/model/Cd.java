package br.edu.ifpb.biblioteca.model;

public class Cd extends Item {
    
    private String genero;
    private String listaDeFaixa;
    private String status;

    public Cd(
        int id,
        String titulo,
        String autor,
        String genero,
        String listaDeFaixa,
        String status) {

    super(id, titulo, autor);

    this.genero = genero;
    this.listaDeFaixa = listaDeFaixa;
    this.status = status;
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

 public void setGenero(String genero){
    this.genero = genero;
 }

 public void setStatus(String status) {
    this.status = status;
 }

 public void setListaDeFaixa(String listaDeFaixa){
    this.listaDeFaixa = listaDeFaixa;
 }
    @Override
    public String toString() {
        return "\n-----------------------------" +
                "\nGenero: " + genero +
                "\nLista de Faixa: " + listaDeFaixa +
                "\nStatus: " + status +
                "\n-----------------------------";
                
    }

}
