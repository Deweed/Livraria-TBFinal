package model.bean;

public class Produtos {
    private int cod_prod;
    private String titulo;
    private String autor;
    private String genero;
    private String editora;
    private float precoUni;
    
    //Recarga de construtor   
    public Produtos(String titulo, String autor, String genero, String editora, float precoUni){
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
        this.precoUni = precoUni;
    }
    
    //Recarga de construtor defalut
    public Produtos(){
        
    }
    
    //Recarga de Construtor
    public Produtos(int cod_produto){
        this.cod_prod = cod_produto;
    }

    //Métodos acessores e Modificadores
    public int getCod_prod() {
        return cod_prod;
    }
    public void setCod_prod(int cod_prod) {
        this.cod_prod = cod_prod;
    }
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    public float getPrecoUni() {
        return precoUni;
    }
    public void setPrecoUni(float precoUni) {
        this.precoUni = precoUni;
    }
    
}
