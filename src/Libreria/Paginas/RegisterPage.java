package Libreria.Paginas;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RegisterPage {
    public RegisterPage(){
            JFrame frame = new JFrame("Bibliopolis");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setPreferredSize(new Dimension(600,600));

            JPanel panelNorte = new JPanel();
            panelNorte.setLayout(new BorderLayout());
            panelNorte.setPreferredSize(new Dimension(600,100));
            panelNorte.setBackground(Color.black);

            JPanel panelCentro = new JPanel();
            panelCentro.setPreferredSize(new Dimension(900,500));

            JPanel contenido = new JPanel();
            contenido.setLayout(null);
            contenido.setPreferredSize(new Dimension(300,400));

            JLabel usuario = new JLabel("Usuario");
            usuario.setBounds(50,90,100,50);
            JLabel contraseña = new JLabel("Contraseña");
            contraseña.setBounds(50,150,100,50);
            JLabel contraseñaConfirmacion = new JLabel("Confirmar contraseña");
            contraseñaConfirmacion.setBounds(50,210,130,50);
            JLabel correo = new JLabel("Correo electronico");
            correo.setBounds(50,30,130,50);







            JTextField userText = new JTextField(10);
            TextPrompt placeholder1 = new TextPrompt("Añade el usuario",userText);
            placeholder1.changeAlpha(0.75f);
            placeholder1.changeStyle(Font.ITALIC);
            userText.setBounds(50,125,175,30);

            JTextField passwordText = new JTextField(10);
            TextPrompt placeholder2 = new TextPrompt("Añade la contraseña",passwordText);
            placeholder2.changeAlpha(0.75f);
            placeholder2.changeStyle(Font.ITALIC);
            passwordText.setBounds(50,185,175,30);

            JTextField passwordConfirm = new JTextField(30);
            TextPrompt placeholder3 = new TextPrompt("Vuelve a añadir la contraseña",passwordConfirm);
            placeholder3.changeAlpha(0.75f);
            placeholder3.changeStyle(Font.ITALIC);
            passwordConfirm.setBounds(50,245,175,30);

            JTextField añadirCorreo = new JTextField(30);
            TextPrompt placeholder4 = new TextPrompt("Añade el correo electrónico",añadirCorreo);
            placeholder4.changeAlpha(0.75f);
            placeholder4.changeStyle(Font.ITALIC);
            añadirCorreo.setBounds(50,65,175,30);


            JLabel regist = new JLabel("Registrarse");
            regist.setBounds(100,300,90,30);
            regist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


            ImageIcon logo = new ImageIcon("src/Libreria/imagenes/logo_blanco.png");
            JLabel etiquetaFoto1 = new JLabel(logo);

            contenido.add(usuario);
            contenido.add(contraseña);
            contenido.add(userText);
            contenido.add(passwordText);
            contenido.add(regist);
            contenido.add(passwordConfirm);
            contenido.add(contraseñaConfirmacion);
            contenido.add(correo);
            contenido.add(añadirCorreo);
            contenido.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Registro",
                    TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));

            panelCentro.add(contenido, BorderLayout.CENTER);
            panelNorte.add(etiquetaFoto1);

            frame.add(panelNorte, BorderLayout.NORTH);
            frame.add(panelCentro, BorderLayout.CENTER);

            frame.pack();
            frame.setVisible(true);
        }
    public static void main(String[] args){
        RegisterPage rp = new RegisterPage();
    }
}

