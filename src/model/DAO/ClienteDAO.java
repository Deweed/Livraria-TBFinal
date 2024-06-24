package model.DAO;

//import com.mysql.jdbc.Connection;
import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Cliente;

public class ClienteDAO {
    
   Connection con = null;
    
    public boolean inserir(Cliente cli) throws SQLException, ClassNotFoundException{
        
        boolean inseriu = false;
        
        try {
            con = (Connection) new Conexao().getConnection();
            String sql = "insert into cliente (nome, cpf, telefone_cel, cidade, estado, cep, bairro, rua, numero, email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getCpf());
            stmt.setString(3, cli.getTelefone_cel());
            stmt.setString(4, cli.getCidade());
            stmt.setString(5, cli.getEstado());
            stmt.setString(6, cli.getCep());
            stmt.setString(7, cli.getBairro());
            stmt.setString(8, cli.getRua());
            stmt.setString(9, cli.getNumero());
            stmt.setString(10, cli.getEmail());
            stmt.execute();
            inseriu = true;
        }
        catch (ClassNotFoundException | SQLException ex){
        }
        finally {
            con.close();
        }
        return inseriu;
    }
    
    public ArrayList<Cliente> buscarCliente() throws SQLException {
        ResultSet rs = null;
        ArrayList<Cliente> listaCli = new ArrayList<>();
        
        try {
            con = (Connection) new Conexao().getConnection();
            String sql = "SELECT * FROM cliente";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    Cliente cli = new Cliente();
                    cli.setId_cliente(rs.getInt("id_cliente"));
                    cli.setNome(rs.getString("nome"));
                    cli.setCpf(rs.getString("cpf"));
                    cli.setTelefone_cel(rs.getString("telefone_cel"));
                    cli.setCidade(rs.getString("cidade"));
                    cli.setEstado(rs.getString("estado"));
                    cli.setCep(rs.getString("cep"));
                    cli.setBairro(rs.getString("bairro"));
                    cli.setRua(rs.getString("rua"));
                    cli.setNumero(rs.getString("numero"));
                    cli.setEmail(rs.getString("email"));
                    
                    listaCli.add(cli);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
        } finally {
            con.close();
        }
        
        return listaCli;
    }
    
    public ArrayList<Cliente> buscarCliente(String coluna, String frame) throws SQLException {
        ResultSet rs;
        rs = null;
        ArrayList<Cliente> listaCli = new ArrayList<>();
        
        try {
            con = (Connection) new Conexao().getConnection();
            String sql = "SELECT * FROM cliente where " + coluna + " like'%" + frame + "%'";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    Cliente cli = new Cliente();
                    cli.setId_cliente(rs.getInt("id_cliente"));
                    cli.setNome(rs.getString("nome"));
                    cli.setCpf(rs.getString("cpf"));
                    cli.setTelefone_cel(rs.getString("telefone_cel"));
                    cli.setCidade(rs.getString("cidade"));
                    cli.setEstado(rs.getString("estado"));
                    cli.setCep(rs.getString("cep"));
                    cli.setBairro(rs.getString("bairro"));
                    cli.setRua(rs.getString("rua"));
                    cli.setNumero(rs.getString("numero"));
                    cli.setEmail(rs.getString("email"));
                    
                    listaCli.add(cli);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
        } finally {
            con.close();
        }
        
        return listaCli;
    }
    
    public boolean excluirCliente(int id_cliente) throws SQLException {
        
        boolean excluiu = false;
        
        try {
            con = (Connection) new Conexao().getConnection();
            String sql = "DELETE FROM cliente WHERE id_cliente = " + id_cliente ;
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
    
    public boolean atualizarCliente(String nome, String cpf, String telefone_cel, String cidade, String estado, String cep, String bairro, String rua, String numero, String email) throws SQLException {
        
        boolean atualizou = false;
        try {
            con = (Connection) new Conexao().getConnection();
            String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone_cel = ?, cidade = ?, estado = ?, cep = ?, bairro = ?, rua = ?, numero = ?, email = ? WHERE cpf = '" + cpf + "'";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.setString(2, cpf);
                stmt.setString(3, telefone_cel);
                stmt.setString(4, cidade);
                stmt.setString(5, estado);
                stmt.setString(6, cep);
                stmt.setString(7, bairro);
                stmt.setString(8, rua);
                stmt.setString(9, numero);
                stmt.setString(10, email);
                stmt.execute();
            }
            atualizou = true;
            
        } catch (ClassNotFoundException | SQLException ex) {
        } finally {
            con.close();
        }
        
        return atualizou;
    }
}
