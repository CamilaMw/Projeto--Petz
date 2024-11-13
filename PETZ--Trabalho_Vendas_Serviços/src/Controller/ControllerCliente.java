package Controller;

import DAO.ClienteDAO;
import Main.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



/**
 *
 * @author Camila
 */
public class ControllerCliente {
   ClienteDAO dao = new ClienteDAO ();
    List<Cliente> lista=  new ArrayList<Cliente>();
    List<String> cliente= new ArrayList<String>();

public void InserirCliente (Cliente c) throws Exception{
    if (!c.nome.equals("") && !c.cpf.equals("") && !c.dataNascimento.equals("")){
    dao.inserir(c);
    JOptionPane.showMessageDialog(null,"Cliente salvo com sucesso!!!");   
    }
    else{
    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
    
    }
    

}
public void delCliente (int id ) throws Exception{
     int op = JOptionPane.showConfirmDialog(null, "Você tem certeza que quer excluir o cliente" +id,"Certeza?",JOptionPane.YES_NO_OPTION);
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
public void cancelarCliente(int id) {
    int opcao = JOptionPane.showOptionDialog(
        null,
        "Deseja cancelar o cadastro do cliente " + id + "?",
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

} 