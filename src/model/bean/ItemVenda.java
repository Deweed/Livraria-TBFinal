package model.bean;

public class ItemVenda {
    private int codProd;
    private int codVenda;
    private float precoUnit;
    private int qtd;

    public int getCodProd() {
        return codProd;
    }
    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public int getCodVenda() {
        return codVenda;
    }
    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public float getPrecoUnit() {
        return precoUnit;
    }
    public void setPrecoUnit(float precoUnit) {
        this.precoUnit = precoUnit;
    }

    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    public ItemVenda() {

    }
}
