package Libreria;

import javax.swing.*;
import java.awt.*;

public class Login {
    private static final boolean MELAPELA = true;

    public Login(){
        JFrame frame = new JFrame("Bibliopolis");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(900,600));

        JPanel panelNorte = new JPanel();
        panelNorte.setLayout(new BorderLayout());
        panelNorte.setPreferredSize(new Dimension(900,100));

        ImageIcon logo = new ImageIcon("src/logo.png");
        JLabel etiquetaFoto1 = new JLabel(logo);

        panelNorte.add(etiquetaFoto1);

        frame.add(panelNorte, BorderLayout.NORTH);

        frame.pack();
        frame.setVisible(MELAPELA);
    }
    public static void main(String[] args){
        Login ver = new Login();
    }
}
