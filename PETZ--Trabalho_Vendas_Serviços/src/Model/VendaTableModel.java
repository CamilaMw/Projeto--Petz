package Model;

import Main.Venda;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe o modelo para tabela com dados da venda
 *
 * @author Camila
 */
public class VendaTableModel extends AbstractTableModel {
// Aparece a hora no Menu
    private final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    private final NumberFormat NFC = NumberFormat.getCurrencyInstance();
    private String colunas[] = {"Cliente", "Data", "Valor", "Situação"};
    private List<Venda> dados;

     
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
        Venda venda = dados.get(l);
        switch (c) {
            case 0:
                return venda.getCliente().getNome();
            case 1:
                return SDF.format(venda.getDataVenda());
            case 2:
                return NFC.format(venda.getValorTotal());
            case 3:
                return venda.getSituacao();
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

    public void setDados(List<Venda> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Venda getRowValue(int l) {
        return dados.get(l);
    }
}
