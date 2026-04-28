package br.edu.ifpb.biblioteca.model;

public class Usuario {
    private int id;
    private String nome;
    private String tipo;
    private int emprestimosAtivos;
    private boolean bloqueado;

    public Usuario( int id, String nome, String tipo, int emprestimosAtivos, boolean bloqueado) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.emprestimosAtivos = emprestimosAtivos;
        this.bloqueado = bloqueado;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getTipo(){
        return tipo;
    }

    public int getEmprestimosAtivos(){
        return emprestimosAtivos;
    }

    public boolean isBloqueado(){
        return bloqueado;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setEmprestimosAtivos(int emprestimosAtivos){
        this.emprestimosAtivos = emprestimosAtivos;
    }
    
    public void setBloqueado(boolean bloqueado){
        this.bloqueado = bloqueado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
        "id=" + id +
        ", nome ='" + nome + '\'' +
        ", tipo='" + tipo + '\'' +
        ", emprestimosAtivos=" + emprestimosAtivos +
        ", bloqueado=" + bloqueado +
        '}';
    }

}
