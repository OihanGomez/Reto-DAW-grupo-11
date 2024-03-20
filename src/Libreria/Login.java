package Libreria;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static java.awt.Frame.ICONIFIED;

public class Login {

    public Login(){
        JFrame frame = new JFrame("Bibliopolis");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(900,600));

        JPanel panelNorte = new JPanel();
        panelNorte.setLayout(new BorderLayout());
        panelNorte.setPreferredSize(new Dimension(900,100));
        panelNorte.setBackground(Color.black);

        JPanel panelCentro = new JPanel();
        panelCentro.setPreferredSize(new Dimension(900,500));

        JPanel contenido = new JPanel();
        contenido.setLayout(null);
        contenido.setPreferredSize(new Dimension(300,400));

        JLabel usuario = new JLabel("Usuario");
        usuario.setBounds(50,50,100,50);
        JLabel contraseña = new JLabel("Contraseña");
        contraseña.setBounds(50,150,100,50);

        JTextField userText = new JTextField(10);
        TextPrompt placeholder1 = new TextPrompt("Añade el usuario",userText);
        placeholder1.changeAlpha(0.75f);
        placeholder1.changeStyle(Font.ITALIC);
        userText.setBounds(50,100,175,30);

        JTextField passwordText = new JTextField(10);
        TextPrompt placeholder2 = new TextPrompt("Añade la contraseña",passwordText);
        placeholder2.changeAlpha(0.75f);
        placeholder2.changeStyle(Font.ITALIC);
        passwordText.setBounds(50,200,175,30);

        JLabel login = new JLabel("Iniciar Sesión");
        login.setBounds(100,260,90,30);


        ImageIcon logo = new ImageIcon("src/logo_blanco.png");
        JLabel etiquetaFoto1 = new JLabel(logo);

        contenido.add(usuario);
        contenido.add(contraseña);
        contenido.add(userText);
        contenido.add(passwordText);
        contenido.add(login);
        contenido.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Inicio de Sesión",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));



        panelCentro.add(contenido, BorderLayout.CENTER);
        panelNorte.add(etiquetaFoto1);

        frame.add(panelNorte, BorderLayout.NORTH);
        frame.add(panelCentro, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        Login ver = new Login();
    }
}
