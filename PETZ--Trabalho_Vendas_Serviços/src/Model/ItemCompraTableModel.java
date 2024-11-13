package Model;

import Main.ItemCompra;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe o modelo para tabela com os dados dos itens da compra
 *
 * @author Camila
 */
public class ItemCompraTableModel extends AbstractTableModel {

    private final NumberFormat NF = NumberFormat.getNumberInstance();
    private final NumberFormat NFC = NumberFormat.getCurrencyInstance();
    private String colunas[] = {"Produto", "Quantidade", "Valor Unitário"};
    private List<ItemCompra> dados;

 
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
        ItemCompra itemCompra = dados.get(l);
        switch (c) {
            case 0:
                return itemCompra.getProduto().getNome();
            case 1:
                return NF.format(itemCompra.getQuantidade());
            case 2:
                return NFC.format(itemCompra.getValorUnitario());
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

    public void setDados(List<ItemCompra> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public ItemCompra getRowValue(int l) {
        return dados.get(l);
    }
}
