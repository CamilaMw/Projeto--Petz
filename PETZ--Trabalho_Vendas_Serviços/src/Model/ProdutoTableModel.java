package Model;

import Main.Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe o modelo para tabela com os  dados do produto
 *
 * @author Camila
 */
public class ProdutoTableModel extends AbstractTableModel {

    private String colunas[] = {"Nome"};
    private List<Produto> dados;

   
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
        Produto produto = dados.get(l);
        switch (c) {
            case 0:
                return produto.getNome();
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

    public void setDados(List<Produto> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Produto getRowValue(int l) {
        return dados.get(l);
    }
}
