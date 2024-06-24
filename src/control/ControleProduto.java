package control;

import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Produtos;
import model.dao.ProdutosDAO;

public class ControleProduto {

    private static ControleProduto ctrl = null;

    public static ControleProduto getInstancia() {
        if (ctrl == null) {
            ctrl = new ControleProduto();
        }

        return ctrl;
    }

    public boolean insereProduto(String titulo, String autor, String genero, String editora, float precoUni) throws SQLException{
        Produtos prod = new Produtos(titulo, autor, genero, editora, precoUni);
        ProdutosDAO prodDAO = new ProdutosDAO();
        boolean inseriu = prodDAO.inserirProduto(prod);
        return inseriu;
    }

    public boolean excluirProduto(int cod_produto) throws SQLException{
        Produtos prod = new Produtos(cod_produto);
        ProdutosDAO prodDAO = new ProdutosDAO();
        boolean excluiu = prodDAO.excluirProduto(prod);
        return excluiu;
    }

    public ArrayList<Produtos> buscarProduto() throws SQLException{
        ProdutosDAO prodDAO = new ProdutosDAO();
        return (prodDAO.buscarProduto());
    }

    public ArrayList<Produtos> buscarProduto(String coluna, String pesquisa) throws SQLException{
        ProdutosDAO prodDAO = new ProdutosDAO();
        return (prodDAO.buscarProduto(coluna, pesquisa));
    }

    public boolean atualizarProduto(int cod_produto, String titulo, String autor, String genero, String editora, float precoUni) throws SQLException{
        Produtos prod = new Produtos(cod_produto);
        ProdutosDAO prodDAO = new ProdutosDAO();
        boolean atualizou = prodDAO.atualizarProduto(cod_produto, titulo, autor, genero, editora, precoUni);
        return atualizou;
    }
}
