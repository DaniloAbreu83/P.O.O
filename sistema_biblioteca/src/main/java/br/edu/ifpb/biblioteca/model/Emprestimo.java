package br.edu.ifpb.biblioteca.model;

public class Emprestimo {
    private int idUsuario;
    private String tituloItem;
    private String tipoItem;
    private int prazoDias;
    private int DiasAtraso;
    private double Multa;
    private String Status;

    public Emprestimo(int idUsuario, String tituloItem, String tipoItem, int prazoDias, int diasAtraso, double multa, String status) {
        this.idUsuario = idUsuario;
        this.tituloItem = tituloItem;
        this.tipoItem = tipoItem;
        this.prazoDias = prazoDias;
        this.DiasAtraso = diasAtraso;
        this.Multa = multa;
        this.Status = status;
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
        return DiasAtraso;
    }

    public double getMulta(){
        return Multa;
    }

    public String getStatus(){
        return Status;
    }
    
    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }

    public void setTituloItem(String tituloItem){
        this.tituloItem = tituloItem;
    }

    public void setTipoItem(String tipoItem){
        this.tipoItem = tipoItem;
    }

    public void setPrazoDias(int prazoDias){
        this.prazoDias = prazoDias;
    }

    public void setDiasAtraso(int diasAtraso){
        this.DiasAtraso = diasAtraso;
    }

    public void setMulta(double multa){
        this.Multa = multa;
    }

    public void setStatus(String status){
        this.Status = status;
    }

    @Override

    public String toString() {
        return "Emprestimo{" +
                "idUsuario=" + idUsuario +
                ", tituloItem='" + tituloItem + '\'' +
                ", tipoItem='" + tipoItem + '\'' +
                ", prazoDias=" + prazoDias +
                ", diasAtraso=" + DiasAtraso +
                ", multa=" + Multa +
                ", status='" + Status + '\'' +
                '}';
    }

}
