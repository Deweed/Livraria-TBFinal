package model.bean;

public class Venda {
    private int codVenda;
    private String dataVenda;
    private int idCliente;

    public int getCodVenda() {
        return codVenda;
    }
    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }
    
    public String getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public Venda() {
        
    }
    
    public Venda(int idCliente) {
        this.setIdCliente(idCliente);
    }
}
