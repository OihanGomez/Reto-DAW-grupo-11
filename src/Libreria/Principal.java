package Libreria;

import javax.swing.*;
import java.awt.*;

public class Principal {
    public Principal(){
        JFrame frame = new JFrame("Bibliopolis");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900,600));

        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        //Header
        JPanel header = new JPanel();
        header.setBackground(Color.BLUE);
        header.setLayout(new BorderLayout());
        header.setPreferredSize(new Dimension(700,100));

        ImageIcon logo = new ImageIcon("src/logo.png");
        JLabel etiquetaFoto1 = new JLabel(logo);

        JLabel ayuda = new JLabel("Ayuda con...");
        JLabel colecciones = new JLabel("Colecciones");
        JLabel eventosYNoticias = new JLabel("Eventos y Noticias");
        JLabel sobreNosotros = new JLabel("Visitas y Sobre nosotros");
        JLabel inicioSesion = new JLabel("inicioSesion");

        ayuda.setFont(new Font("Arial",Font.BOLD,14));
        colecciones.setFont(new Font("Arial",Font.BOLD,14));
        eventosYNoticias.setFont(new Font("Arial",Font.BOLD,14));
        sobreNosotros.setFont(new Font("Arial",Font.BOLD,14));
        inicioSesion.setFont(new Font("Arial",Font.BOLD,14));

        JPanel grupoBotones = new JPanel();
        grupoBotones.setBackground(Color.white);
        grupoBotones.setLayout(new BoxLayout(grupoBotones, BoxLayout.X_AXIS));
        grupoBotones.setPreferredSize(new Dimension(200,100));
        grupoBotones.add(Box.createHorizontalStrut(30));
        grupoBotones.add(ayuda);
        grupoBotones.add(Box.createHorizontalStrut(30));
        grupoBotones.add(colecciones);
        grupoBotones.add(Box.createHorizontalStrut(30));
        grupoBotones.add(eventosYNoticias);
        grupoBotones.add(Box.createHorizontalStrut(30));
        grupoBotones.add(sobreNosotros);
        grupoBotones.add(Box.createHorizontalStrut(30));
        grupoBotones.add(inicioSesion);



        JPanel headorPanel = new JPanel(new BorderLayout());
        headorPanel.add(grupoBotones, BorderLayout.CENTER);
        headorPanel.add(etiquetaFoto1, BorderLayout.WEST);
        header.add(headorPanel, BorderLayout.CENTER);

        JPanel raya = new JPanel();
        raya.setPreferredSize(new Dimension(700,1));
        raya.setBackground(Color.black);
        raya.setBounds(100,100,700,1);

        //Body
        JPanel body = new JPanel();
        body.setPreferredSize(new Dimension(700,500));
        body.setBackground(Color.LIGHT_GRAY);
        body.setLayout(new BorderLayout());


        frame.add(header, BorderLayout.NORTH);
        frame.add(raya);
        frame.add(body, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
        System.out.println("a");
    }
    public static void main(String[] args){
        Principal ver = new Principal();
    }
}
