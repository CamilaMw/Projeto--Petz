package Model;

import Main.ItemVenda;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe  do modelo para tabela com os dados dos itens da venda
 *
 * @author Camila
 */
public class ItemVendaTableModel extends AbstractTableModel {

    private final NumberFormat NF = NumberFormat.getNumberInstance();
    private final NumberFormat NFC = NumberFormat.getCurrencyInstance();
    private String colunas[] = {"Produto", "Quantidade", "Valor Unitário"};
    private List<ItemVenda> dados;

    
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
        ItemVenda itemVenda = dados.get(l);
        switch (c) {
            case 0:
                return itemVenda.getProduto().getNome();
            case 1:
                return NF.format(itemVenda.getQuantidade());
            case 2:
                return NFC.format(itemVenda.getValorUnitario());
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente!");
        }
    }

    
    public String getColumnName(int c) {
        return colunas[c];
    }

     
    public boolean isCellEditable(int l, int c) {
        return false;
    }

    public void setDados(List<ItemVenda> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public ItemVenda getRowValue(int l) {
        return dados.get(l);
    }
}
