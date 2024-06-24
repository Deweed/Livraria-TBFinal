package model.bean;

public class Cliente {
    private int id_cliente;
    private String nome;
    private String cpf;
    private String telefone_cel;
    private String cidade;
    private String estado;
    private String cep;
    private String bairro;
    private String rua;
    private String numero;
    private String email;
    
    public Cliente(String nome, String cpf, String telefone_cel, String cidade,
                   String estado, String cep, String bairro, String rua, String numero, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone_cel = telefone_cel;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.email = email;
    }
    
    public Cliente(String cpf){
        this.setCpf(cpf);
    }
    
    public Cliente(){
        
    }

    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public final void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone_cel() {
        return telefone_cel;
    }
    public void setTelefone_cel(String telefone_cel) {
        this.telefone_cel = telefone_cel;
   
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }  
}
