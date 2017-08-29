package ufjf.br;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JanelaJogo extends JFrame {
private  final Random gerador = new Random();
private final JRadioButton rbPedra = new JRadioButton("Pedra", false);
private final JRadioButton rbPapel = new JRadioButton("Papel", false);
private final JRadioButton rbTesoura = new JRadioButton("Tesoura", false);
private final JButton jbCalcular = new JButton("Jogar");
private final JLabel jlMaquina = new JLabel("O COMPUTADOR ESCOLHEU");
private final JLabel jlPlacar = new JLabel("Placar: Usuario");
private final JTextField texto1 = new JTextField(10);
private final JTextField texto2 = new JTextField(5);
private final JLabel Placarpc = new JLabel("Placar: Maquina");
private final JTextField texto3 = new JTextField(5);
private int rodadas =0, opcaoMaquina =0, opcaoUsuario=0, placarA =0, placarB=0, empate=0;

    public JanelaJogo() throws HeadlessException {

        super("PedraPapelTesoura");
        setLayout(new FlowLayout());
        add(rbPedra);
        add(rbPapel);
        add(rbTesoura);
        add(jbCalcular);
        add(jlMaquina);
        add(texto1);
        add(jlPlacar);
        add(texto2);
        add(Placarpc);
        add(texto3);
        
        rbPapel.addItemListener(new OpcaoRadio(0));
        rbPedra.addItemListener(new OpcaoRadio(1));
        rbTesoura.addItemListener(new OpcaoRadio(2));
        
        botaoClicado botao = new botaoClicado();
        jbCalcular.addActionListener(botao);
        
        if(rodadas == 7){
            if(placarA > placarB){
                JOptionPane.showMessageDialog(null, "O vencedor foi o Usuario");
            }else{
                JOptionPane.showMessageDialog(null, "O vencedor foi a Maquina");
            }
        }
        
    }

    private  class botaoClicado implements ActionListener{

        public botaoClicado() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           if(opcaoUsuario == 0 && opcaoMaquina ==0){
               empate++;
               JOptionPane.showMessageDialog(null, "Empatados!");
           }else if(opcaoUsuario ==0 && opcaoMaquina ==1){
               placarA++;
               texto2.setText(" " + placarA);
        }else if(opcaoUsuario == 0 && opcaoMaquina ==2){
        placarB++;
        texto3.setText(" "+ placarB);
    }else if(opcaoUsuario ==1 && opcaoMaquina ==0){
        placarA++;
        texto3.setText(" " + placarA);
    }else if(opcaoUsuario == 1 && opcaoMaquina ==1){
        empate++;
        JOptionPane.showMessageDialog(null, "Empatados!");
    }else if(opcaoUsuario ==1 && opcaoMaquina ==2){
        placarA++;
        texto3.setText(" " + placarA);
        
    } else if(opcaoUsuario ==2 && opcaoMaquina ==0){
        placarA++;
        texto2.setText(" " + placarA);
    }else if(opcaoUsuario ==2 && opcaoMaquina ==1){
        placarA++;
        texto2.setText(" " + placarA);
    }else if(opcaoUsuario ==2 && opcaoMaquina ==2){
        empate++;
        JOptionPane.showMessageDialog(null,"Empatados!");
    }
           rodadas++;
        }
    }

    private  class OpcaoRadio implements ItemListener {

        public OpcaoRadio(int i) {
            opcaoUsuario = i;
        }

        @Override
        public void itemStateChanged(ItemEvent ie) {
            opcaoMaquina = gerador.nextInt(3);
            if(opcaoMaquina ==0){
                texto1.setText("Papel");
            }else if(opcaoMaquina ==1){
                texto1.setText("Pedra");
            }else if(opcaoMaquina ==2){
                texto1.setText("Tesoura");
            }else{
                texto1.setText("ERRO!");
            }
        }
    }
}
