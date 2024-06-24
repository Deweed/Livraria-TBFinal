package model.dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Produtos;

public class ProdutosDAO {

    private Connection con = null;

    public boolean inserirProduto(Produtos prod) throws SQLException {
        boolean inseriu = false;
        String sql = "INSERT INTO produto (titulo, autor, genero, editora, precoUni) VALUES (?, ?, ?, ?, ?)";

        try {
            con = new Conexao().getConnection();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, prod.getTitulo());
                stmt.setString(2, prod.getAutor());
                stmt.setString(3, prod.getGenero());
                stmt.setString(4, prod.getEditora());
                stmt.setFloat(5, prod.getPrecoUni());
                stmt.executeUpdate();
            }
            inseriu = true;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

        return inseriu;
    }

    public boolean excluirProduto(Produtos prod) throws SQLException {
        boolean excluiu = false;
        String sql = "DELETE FROM produto WHERE cod_produto = ?";

        try {
            con = new Conexao().getConnection();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, prod.getCod_prod());
                stmt.executeUpdate();
            }
            excluiu = true;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

        return excluiu;
    }

    public ArrayList<Produtos> buscarProduto() throws SQLException {
        ArrayList<Produtos> listaProd = new ArrayList<>();
        String sql = "SELECT * FROM produto";

        try {
            con = new Conexao().getConnection();
            try (PreparedStatement stmt = con.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Produtos prod = new Produtos();
                    prod.setCod_prod(rs.getInt("cod_produto"));
                    prod.setTitulo(rs.getString("titulo"));
                    prod.setAutor(rs.getString("autor"));
                    prod.setGenero(rs.getString("genero"));
                    prod.setEditora(rs.getString("editora"));
                    prod.setPrecoUni(rs.getFloat("precoUni"));
                    listaProd.add(prod);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

        return listaProd;
    }

    public ArrayList<Produtos> buscarProduto(String coluna, String pesquisa) throws SQLException {
        ArrayList<Produtos> listaProd = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE " + coluna + " LIKE ?";

        try {
            con = new Conexao().getConnection();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, "%" + pesquisa + "%");
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Produtos prod = new Produtos();
                        prod.setCod_prod(rs.getInt("cod_produto"));
                        prod.setTitulo(rs.getString("titulo"));
                        prod.setAutor(rs.getString("autor"));
                        prod.setGenero(rs.getString("genero"));
                        prod.setEditora(rs.getString("editora"));
                        prod.setPrecoUni(rs.getFloat("precoUni"));
                        listaProd.add(prod);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

        return listaProd;
    }

    public boolean atualizarProduto(int cod_produto, String titulo, String autor, String genero, String editora, float precoUni) throws SQLException {
        boolean atualizou = false;
        String sql = "UPDATE produto SET titulo = ?, autor = ?, genero = ?, editora = ?, precoUni = ? WHERE cod_produto = ?";

        try {
            con = new Conexao().getConnection();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, titulo);
                stmt.setString(2, autor);
                stmt.setString(3, genero);
                stmt.setString(4, editora);
                stmt.setFloat(5, precoUni);
                stmt.setInt(6, cod_produto);
                stmt.executeUpdate();
            }
            atualizou = true;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

        return atualizou;
    }
}
