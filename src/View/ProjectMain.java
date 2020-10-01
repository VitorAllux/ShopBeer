
package View;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import Connection.ConnectionFactory;
import Daos.produtoDAO;
import Daos.vendaProdutoDAO;
import Models.ProdutoModel;

/**
 *
 * @author vitor
 */
public class ProjectMain {
    public static void main(String [] args) throws SQLException{
    FrameLogin Login = new FrameLogin();
    Login.setVisible(true);

    /* produtoDAO dao = new produtoDAO(conn);
    ProdutoModel produto = new ProdutoModel();
    produto.setNome("bala1");
    produto.setCategoria("doce");
    produto.setPreco(1.50);
    produto.setQuantidade(20);
    produto.setBarCode(3002);
    produto.setValDate(new Date(0));


    dao.createProduto(produto);
    
    System.out.println(dao.getOneProduto(6).getNome());
    //dao.deleteProduto(4);
     */

    
    }
            
}
