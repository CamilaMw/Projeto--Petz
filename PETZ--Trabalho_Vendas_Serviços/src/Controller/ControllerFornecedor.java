 
package Controller;



import Main.Fornecedor;
import DAO.FornecedorDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Fornecedor1;
/**
 *
 * @author Camila
 */
public class ControllerFornecedor {
    FornecedorDAO dao = new FornecedorDAO();
    List<Fornecedor> lista = new ArrayList<Fornecedor>();
    List<String> fornecedor = new ArrayList<Fornecedor>();
    
    public void inserirFornecedor(Fornecedor f)
    {
        if (!f.cnpj.equals("") && !f.nome.equals(""))
        {
            dao.salvarFornecedor(f);
            JOptionPane.showMessageDialog(null,"Fornecedor salvo com sucesso!!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
        }
    }
     
     public void delFornecedor(int id)
    {
        int op = JOptionPane.showConfirmDialog(null, "Você tem certeza que quer excluir a marca"+id,"Certeza?",JOptionPane.YES_NO_OPTION);
       switch(op)
       {
           case 0:
               dao.excluirFornecedor(id);
               JOptionPane.showMessageDialog(null, "Excluído com sucesso!!!");
                            
               break;
           case 1:
               JOptionPane.showMessageDialog(null, "Exclusão cancelada");
               break;
       }
    } 
    public void cancelarFornecedor(Fornecedor f) {
    int opcao = JOptionPane.showOptionDialog(
        null,
        "Deseja cancelar o cadastro do fornecedor " f.getId "?",
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
    public List<Fornecedor> getUpdateFornecedor() 
    {
        lista.clear();
        lista = dao.getFornecedor();
        return lista;
    }
  public List<String> carregaCombo()
    {
        fornecedor.clear();
        fornecedor = dao.carregaComboBox();
        return fornecedor;
    }
  
}
