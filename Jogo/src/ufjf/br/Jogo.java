
package ufjf.br;

import javax.swing.JFrame;


public class Jogo {

   
    public static void main(String[] args) {
       JanelaJogo janela = new JanelaJogo();
       janela.setSize(360,180);
       janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       janela.setLocationRelativeTo(null);
       janela.setVisible(true);
    }
    
}
