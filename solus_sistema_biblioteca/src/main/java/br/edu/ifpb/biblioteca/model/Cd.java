package br.edu.ifpb.biblioteca.model;

import br.edu.ifpb.biblioteca.util.Cores;

/**
 * Representa um CD do acervo da biblioteca,
 * contendo informações como quantidade de faixas.
 */
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

   public String getGenero() {
      return genero;
   }

   public String getListaDeFaixa() {
      return listaDeFaixa;
   }

   public String getStatus() {
      return status;
   }

   public void setGenero(String genero) {
      this.genero = genero;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public void setListaDeFaixa(String listaDeFaixa) {
      this.listaDeFaixa = listaDeFaixa;
   }

   @Override
   public String toString() {
      return "\n-----------------------------" +
            "\nID: " + getId() +
            "\nTítulo: " + getTitulo() +
            "\nAutor: " + getAutor() +
            "\nGênero: " + genero +
            "\nLista de Faixas: " + listaDeFaixa +
            "\nStatus: " + Cores.status(status) +
            "\n-----------------------------";
   }

}
