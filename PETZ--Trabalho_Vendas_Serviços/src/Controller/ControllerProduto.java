 
package Controller;

import DAO.ProdutoDAO;
import Main.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Produto1;
/**
 *
 * @author Camila
 */
public class ControllerProduto {
    ProdutoDAO dao = new ProdutoDAO();
    List<Produto> lista= new ArrayList<Produto>();
    public void inserirProduto(Produto p)
    {
        if (!p.nome.equals("") && p.precoCompra != 0 && p.precoVenda != 0 && p.quantidade != 0)
        {
            dao.salvarProduto(p);
            JOptionPane.showMessageDialog(null,"Produto salvo com sucesso!!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
        }
    }
    
     public void alterarProduto(Produto p)
    {
        if (!p.nome.equals("") && p.precoCompra != 0 && p.precoVenda != 0 && p.quantidade != 0 && p.id!=0)
        {
            dao.editarProduto(p);
            JOptionPane.showMessageDialog(null,"Produto salvo com sucesso!!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
        }
    }
     
     public void delProduto(int id) throws Exception
    {
        int op = JOptionPane.showConfirmDialog(null, "Você tem certeza que quer excluir este produto"+id,"Certeza?",JOptionPane.YES_NO_OPTION);
       switch(op)
       {
           case 0:
               dao.excluir(id);
               JOptionPane.showMessageDialog(null, "Excluído com sucesso!!!");
                            
               break;
           case 1:
               JOptionPane.showMessageDialog(null, "Exclusão cancelada");
               break;
       }
    } 
     public void cancelarProduto(int id ) {
    int opcao = JOptionPane.showOptionDialog(
        null,
        "Deseja cancelar o cadastro do produto " + id + "?",
        "Cancelar Cadastro",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.WARNING_MESSAGE,
        null,
        new Object[]{"Cancelar"},
        "Cancelar"
    );

    if (opcao == 0) {
        JOptionPane.showMessageDialog(null, "Cadastro cancelado");
       
    }
     }
    public List<Produto> getUpdateProdutos()
    {
        lista.clear();
        lista = dao.getProdutos();
        return lista;
    }
}
