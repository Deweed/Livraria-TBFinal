package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import model.DAO.ItemVendaDAO;
import model.bean.ItemVenda;


public class ControleItemVenda {
    
    public boolean inserirItemVenda(ArrayList<ItemVenda> listItem) {
        ItemVenda item = new ItemVenda();
        ItemVendaDAO vendaSQL = new ItemVendaDAO();
        boolean inseriu = false;
        
        Iterator it = listItem.iterator();
        
        while (it.hasNext()) {
            item = (ItemVenda) it.next();
            try {
                inseriu = vendaSQL.inserir(item);
            } catch (ClassNotFoundException | SQLException ex) {
            }
        }
         
        return inseriu;
    }
    
    public ArrayList<ItemVenda> buscaItem(int codVenda) throws SQLException, ClassNotFoundException {
        ItemVendaDAO itemSQL = new ItemVendaDAO();
        
        return itemSQL.buscarItens(codVenda);
    }
}
