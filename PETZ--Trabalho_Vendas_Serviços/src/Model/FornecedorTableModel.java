package Model;

import Main.Fornecedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe o modelo para tabela com os dados do fornecedor
 *
 * @author Camila
 */
public class FornecedorTableModel extends AbstractTableModel {

    private String colunas[] = {"Nome", "CNPJ"};
    private List<Fornecedor> dados;

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
        Fornecedor fornecedor = dados.get(l);
        switch (c) {
            case 0:
                return fornecedor.getNome();
            case 1:
                return fornecedor.getCnpj();
            default:
               return null;
        }
    }

   
    public String getColumnName(int c) {
        return colunas[c];
    }

  
    public boolean isCellEditable(int l, int c) {
        return false;
    }

    public void setDados(List<Fornecedor> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Fornecedor getRowValue(int l) {
        return dados.get(l);
    }
}
