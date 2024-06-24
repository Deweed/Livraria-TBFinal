package model.DAO;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.ItemVenda;

public class ItemVendaDAO {
    
    Connection con = null;
    
    public boolean inserir(ItemVenda item) throws SQLException, ClassNotFoundException{
        
        boolean inseriu = false;
        
        try{
            con = (Connection) new Conexao().getConnection();
            String sql = "INSERT INTO itens_venda (cod_produto,cod_venda,preco_unitario,quantidade) VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, item.getCodProd());
                stmt.setInt(2, item.getCodVenda());
                stmt.setFloat(3, item.getPrecoUnit());
                stmt.setInt(4, item.getQtd());
                stmt.execute();
            }
            inseriu = true;
            
        } catch (ClassNotFoundException | SQLException ex){
        }
        finally{
            con.close();
        }
        
        return inseriu;
    }

    public ArrayList<ItemVenda> buscarItens(int codVenda) throws SQLException, ClassNotFoundException{
        ResultSet rs = null;
        ArrayList<ItemVenda> listaItens = new ArrayList<>();
        
        try{
            con = (Connection) new Conexao().getConnection();
            String sql = "SELECT * FROM itens_venda WHERE cod_venda = " + codVenda;
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    ItemVenda item = new ItemVenda();
                    item.setCodProd(rs.getInt("cod_produto"));
                    item.setCodVenda(rs.getInt("cod_venda"));
                    item.setPrecoUnit(rs.getFloat("preco_unitario"));
                    item.setQtd(rs.getInt("quantidade"));
                    
                    listaItens.add(item);
                }
            }
            
        } catch (ClassNotFoundException | SQLException ex){
        }
        finally{
            con.close();
        }
        
        return listaItens;
    }

    
}
