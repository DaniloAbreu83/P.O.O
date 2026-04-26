package br.edu.ifpb.biblioteca.model;

public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private String editora;
    private int ano;
    private int paginas;

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public String getEditora(){
        return editora;
    }

    public int getAno(){
        return ano;
    }

    public int getPaginas(){
        return paginas;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setEditora(String editora){
        this.editora = editora;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public void setPaginas(int paginas){
        this.paginas = paginas;
    }
    @Override
    public String toString() {
        return "livro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", ano=" + ano +
                ", paginas=" + paginas +
                '}';
    }

}
