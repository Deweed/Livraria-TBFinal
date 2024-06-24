
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        //String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/livraria";
        String usuario = "root";
        String senha = "root";
        try { // Tratar o retorno do método 'getConnection' da classe DriverManager
            //Class.forName(driver);
            return (Connection) DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) { // Excessão recebida pelo método 'getConnection'
            throw new RuntimeException("Erro de conexao", ex);
        }
    }
}
