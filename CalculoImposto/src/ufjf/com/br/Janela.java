package ufjf.com.br;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Janela extends JFrame {

    private final JTextField valor = new JTextField(8);
    private final JLabel valorDolar = new JLabel("Valor do Produto(USD):");
    private final JTextField cotacao = new JTextField(8);
    private final JLabel cotacaoDolar = new JLabel("Cotação USD em (R$):");
    private final JCheckBox tributado = new JCheckBox("Tributado");
    private final JCheckBox icms = new JCheckBox("ICMS");
    private final JButton calcular = new JButton("Calcular");
    private double Vtotal = 0.0;
    private final JLabel resultado = new JLabel("VLTotal");

    public Janela() throws HeadlessException {
        super("Calculo Imposto ");
        setLayout(new FlowLayout());
        add(valorDolar);
        add(valor);
        add(cotacaoDolar);
        add(cotacao);
        add(calcular);
        add(tributado);
        add(icms);
        add(resultado);
        TratarFuncoes tratador = new TratarFuncoes();
        calcular.addActionListener(tratador);
        tributado.addActionListener(tratador);
        icms.addItemListener(tratador);
    }

    private class TratarFuncoes implements ActionListener, ItemListener {

        public TratarFuncoes() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            calcular();
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            calcular();
        }

        private void calcular() throws NumberFormatException {
            Vtotal = 0.0;
            Double Val_Inicial = Double.parseDouble(valor.getText());
            Double Val_cotacao = Double.parseDouble(cotacao.getText());
            if (tributado.isSelected() && icms.isSelected()) {
                Vtotal = Vtotal + (Val_Inicial * Val_cotacao) + Val_Inicial * 0.60 + Val_Inicial * 0.18;
            } else if (tributado.isSelected()) {
                Vtotal = Vtotal + (Val_Inicial * Val_cotacao) + Val_Inicial * 0.60;
            } else if (icms.isSelected()) {
                Vtotal = Vtotal + (Val_Inicial * Val_cotacao) + Val_Inicial * 0.18;
            } else {
                Vtotal = Vtotal + (Val_Inicial * Val_cotacao);
            }
            resultado.setText("Total a pagar em (R$):" + Vtotal);
        }
    }

}
