
package ufjf.com.br;


import java.awt.HeadlessException;
import javafx.scene.control.CheckBox;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Janela extends JFrame{

    private final JTextField valor = new JTextField(8);
    private final JLabel valorDolar = new JLabel("Valor do Produto(USD):");
    private final JTextField cotacao = new JTextField(8);
    private final JLabel cotacaoDolar = new JLabel("Cotação USD em (R$):");
    private final JCheckBox tributado = new JCheckBox("Tributado");
    
    
    
    
    public Janela() throws HeadlessException {
        super("Calculo Imposto");
        
        
    }

 
       
       
        
  
    
}
