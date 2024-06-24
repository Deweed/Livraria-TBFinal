package model.DAO;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Venda;

public class VendaDAO {
    Connection con = null;
    
    public boolean inserir(Venda venda) throws SQLException, ClassNotFoundException{
        
        boolean inseriu = false;
        
        try{
            con = (Connection) new Conexao().getConnection();
            String sql = "INSERT INTO venda (cod_venda,date_time,id_cliente) VALUES (default, now(), ?)";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, venda.getIdCliente());
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
    
    public ArrayList<Venda> buscar() throws SQLException {
        ResultSet rs = null;
        ArrayList<Venda> listaVenda = new ArrayList<>();
        
        try {
            con = (Connection) new Conexao().getConnection();
            String sql = "SELECT * FROM venda";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    Venda vend = new Venda();
                    vend.setCodVenda(rs.getInt("cod_venda"));
                    vend.setDataVenda(rs.getString("date_time"));
                    vend.setIdCliente(rs.getInt("id_cliente"));
                    
                    listaVenda.add(vend);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
        } finally {
            con.close();
        }
        
        return listaVenda;
    }
    
    public Venda buscar(String coluna, int value) throws SQLException {
        ResultSet rs = null;
        Venda vendaCriada = new Venda();
        
        try {
            con = (Connection) new Conexao().getConnection();
            String sql = "SELECT * FROM venda WHERE " + coluna + " = " + value;
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    Venda vend = new Venda();
                    vend.setCodVenda(rs.getInt("cod_venda"));
                    vend.setDataVenda(rs.getString("date_time"));
                    vend.setIdCliente(rs.getInt("id_cliente"));
                    
                    vendaCriada = vend;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
        } finally {
            con.close();
        }
        
        return vendaCriada;
    }
        
    public boolean excluir(int codVenda) throws SQLException {
        boolean excluiu = false;
        
        try {
            con = (Connection) new Conexao().getConnection();
            String sql = "DELETE FROM venda WHERE cod_venda = " + codVenda;
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.execute();
            }
            excluiu = true;
        } catch (ClassNotFoundException | SQLException ex) {
        } finally {
            con.close();
        }
        
        return excluiu;
    }

}
