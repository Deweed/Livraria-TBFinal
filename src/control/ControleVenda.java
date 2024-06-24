package control;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DAO.VendaDAO;
import model.bean.Venda;

public class ControleVenda {
    public boolean insereVenda(int idCli) throws SQLException { 
        Venda venda = new Venda(idCli);
        VendaDAO vendaSQL = new VendaDAO();
        boolean inseriu = false;

        try {
            inseriu = vendaSQL.inserir(venda);
        } catch (ClassNotFoundException ex) {
        }

        return inseriu;
    }
     
    public Venda buscaVenda(String coluna, int idCli) {
        Venda venda = new Venda();
        VendaDAO vendaSQL = new VendaDAO();

        try {
           venda = vendaSQL.buscar(coluna, idCli);
        } catch (SQLException ex) {
        }

        return venda;
    }
    
    public ArrayList<Venda> buscaVenda() {
        ArrayList<Venda> vendas = new ArrayList<>();
        VendaDAO vendaSQL = new VendaDAO();

        try {
           vendas = vendaSQL.buscar();
        } catch (SQLException ex) {
        }

        return vendas;
    }

    public void excluiVenda(int codVenda) {
        VendaDAO vendaSQL = new VendaDAO();

        try {
            if(vendaSQL.excluir(codVenda)) {
                JOptionPane.showMessageDialog(null, "Excluído com Sucesso");
            }
        } catch (SQLException ex) {
        }
    }
}
