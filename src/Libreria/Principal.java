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
        header.setBackground(Color.BLACK);
        header.setLayout(new BorderLayout());
        header.setPreferredSize(new Dimension(700,100));

        ImageIcon logo = new ImageIcon("src/logo_blanco.png");
        JLabel etiquetaFoto1 = new JLabel(logo);

        JLabel ayuda = new JLabel("Ayuda con...");
        JLabel colecciones = new JLabel("Colecciones");
        JLabel eventosYNoticias = new JLabel("Eventos y Noticias");
        JLabel sobreNosotros = new JLabel("Visitas y Sobre nosotros");
        JLabel inicioSesion = new JLabel("inicioSesion");

        ayuda.setForeground(Color.WHITE);
        colecciones.setForeground(Color.WHITE);
        eventosYNoticias.setForeground(Color.WHITE);
        sobreNosotros.setForeground(Color.WHITE);
        inicioSesion.setForeground(Color.WHITE);


        ayuda.setFont(new Font("Arial",Font.BOLD,14));
        colecciones.setFont(new Font("Arial",Font.BOLD,14));
        eventosYNoticias.setFont(new Font("Arial",Font.BOLD,14));
        sobreNosotros.setFont(new Font("Arial",Font.BOLD,14));
        inicioSesion.setFont(new Font("Arial",Font.BOLD,14));

        JPanel grupoBotones = new JPanel();
        grupoBotones.setBackground(Color.BLACK);
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



        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.BLACK);
        headerPanel.add(grupoBotones, BorderLayout.CENTER);
        headerPanel.add(etiquetaFoto1, BorderLayout.WEST);
        header.add(headerPanel, BorderLayout.CENTER);



        //Body
        JPanel body = new JPanel();
        body.setPreferredSize(new Dimension(700,500));

        body.setLayout(new BorderLayout());


        frame.add(header, BorderLayout.NORTH);
        frame.add(body, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        Principal ver = new Principal();
    }
}
