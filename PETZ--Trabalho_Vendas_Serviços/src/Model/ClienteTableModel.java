package Model;

import Main.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe o modelo para tabela com os dados do cliente
 *
 * @author Camila
 */
public class ClienteTableModel extends AbstractTableModel {

    private String colunas[] = {"Nome", "CPF"};
    private List<Cliente> dados;

    public int getRowCount() {
        if(dados == null){
            return 0;
        }
        return dados.size();
    }
 
    public int getColumnCount() {
        return colunas.length;
    }

     
    public Object getValueAt(int l, int c) {
        Cliente cliente = dados.get(l);
        switch (c) {
            case 0:
                return cliente.getNome();
            case 1:
                return cliente.getCpf();
            default:
                return null;
                
                
                // "throw" em Java é utilizado para lançar uma exceção. Ele é usado quando queremos indicar que ocorreu algum erro ou situação inesperada no nosso código.
        }
    }

   
    public String getColumnName(int c) {
        return colunas[c];
    }

 
    public boolean isCellEditable(int l, int c) {
        return false;
    }

    public void setDados(List<Cliente> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Cliente getRowValue(int l) {
        return dados.get(l);
    }
}
