package principal;


import Telas.FrmLogin;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Classe principal que inicia o menu
 *
 * @author Camila
 */
public class Main {

    /**
     * Método responsável por iniciar o menu
     *
     * @param args lista de parâmetros do método main
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
         

       
        
        FrmLoginAfranio tela = new FrmLoginAfranio();  
        tela.setVisible(true);
        lookAndFeel();
        /*Menu menu = new Menu();
        menu.setVisible(true);*/
   }

    

    
    
    private static void lookAndFeel() {

        try {
            
            // UIManager  é usada para gerenciar a aparência de componentes como botões, caixas de texto em Java Swing 
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

  //  void show() {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
//}


//UIManager: Essa classe faz parte do pacote javax.swing, e é usada para fornecer um conjunto de propriedades de sistema de aparência que podem ser configuradas para alterar a aparência dos componentes Swing.

// UnsupportedLookAndFeelException: Essa exceção é lançada quando você tenta usar um "look and feel" que não é suportado. Se, por exemplo, você tentar configurar um "look and feel" que não está presente na máquina ou não é suportado pela implementação Java, essa exceção será lançada.
