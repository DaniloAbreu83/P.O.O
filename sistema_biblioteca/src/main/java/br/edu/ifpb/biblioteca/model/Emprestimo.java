package br.edu.ifpb.biblioteca.model;

public class Emprestimo {
    private int idUsuario;
    private String tituloItem;
    private String tipoItem;
    private int prazoDias;
    private int diasAtraso;
    private double multa;
    private String status;

    public Emprestimo(int idUsuario, String tituloItem, String tipoItem, int prazoDias, int diasAtraso, double multa, String status) {
        this.idUsuario = idUsuario;
        this.tituloItem = tituloItem;
        this.tipoItem = tipoItem;
        this.prazoDias = prazoDias;
        this.diasAtraso = diasAtraso;
        this.multa = multa;
        this.status = status;
    }

    public int getIdUsuario(){
        return idUsuario;
    }

    public String getTituloItem(){
        return tituloItem;
    }

    public String getTipoItem(){
        return tipoItem;
    }

    public int getPrazoDias(){
        return prazoDias;
    }

    public int getDiasAtraso(){
        return diasAtraso;
    }

    public double getMulta(){
        return multa;
    }

    public String getStatus(){
        return status;
    }

    public String toString() {
        return "Emprestimo{" +
                "idUsuario=" + idUsuario +
                ", tituloItem='" + tituloItem + '\'' +
                ", tipoItem='" + tipoItem + '\'' +
                ", prazoDias=" + prazoDias +
                ", diasAtraso=" + diasAtraso +
                ", multa=" + multa +
                ", status='" + status + '\'' +
                '}';
    }

}
