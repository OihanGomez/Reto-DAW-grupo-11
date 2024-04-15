package Libreria;

import Libreria.TextPrompt;

import javax.swing.*;
import java.awt.*;

public class Principal {
    public Principal(){
        JFrame frame = new JFrame("Bibliopolis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900,600));

        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        //Header
        JPanel header = new JPanel();
        header.setBackground(Color.BLACK);
        header.setLayout(new BorderLayout());
        header.setPreferredSize(new Dimension(700,100));

        ImageIcon logo = new ImageIcon("src/imagenes/logo_blanco.png");
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
        grupoBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        grupoBotones.setPreferredSize(new Dimension(700,100));
        grupoBotones.add(ayuda);
        grupoBotones.add(colecciones);
        grupoBotones.add(eventosYNoticias);
        grupoBotones.add(sobreNosotros);
        grupoBotones.add(inicioSesion);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.BLACK);
        headerPanel.add(grupoBotones, BorderLayout.CENTER);
        headerPanel.add(etiquetaFoto1, BorderLayout.WEST);
        header.add(headerPanel, BorderLayout.CENTER);

        //Body
        JPanel body = new JPanel();
        body.setPreferredSize(new Dimension(700,500));
        body.setBackground(Color.yellow);
        body.setLayout(new BorderLayout());

        //Contenido panel
        JPanel bodyArriba = new JPanel();
        bodyArriba.setPreferredSize(new Dimension(700,125));
        bodyArriba.setLayout(null);

        JPanel bodyAbajo = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bodyAbajo.setPreferredSize(new Dimension(700,300));
        bodyAbajo.setBackground(Color.green);
        bodyAbajo.setLayout(null);


        //Panel de dentro de panelArriba

        JPanel arribaContenido = new JPanel();
        arribaContenido.setBackground(Color.lightGray);
        arribaContenido.setPreferredSize(new Dimension(400,30));
        arribaContenido.setLayout(new BoxLayout(arribaContenido, BoxLayout.X_AXIS));
        arribaContenido.setBounds(300,40,300,30);

        JTextField buscadorTexto = new JTextField(30);
        TextPrompt placeHolder = new TextPrompt("Busca tu libro...", buscadorTexto);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        buscadorTexto.setPreferredSize(new Dimension(300,30));

        ImageIcon buscadorIcono = new ImageIcon("src/imagenes/buscador.png");
        JLabel buscadorEtiqueta = new JLabel(buscadorIcono);

        //Panel dentro de panelAbajo

        JPanel abajoContenido = new JPanel();
        abajoContenido.setBounds(5,5,874,326);
        abajoContenido.setLayout(null);
        abajoContenido.setBackground(Color.magenta);



        //Añadir contenido

        bodyAbajo.add(abajoContenido);
        bodyArriba.add(arribaContenido,BorderLayout.NORTH);

        arribaContenido.add(buscadorTexto);
        arribaContenido.add(buscadorEtiqueta);

        body.add(bodyArriba, BorderLayout.NORTH);
        body.add(bodyAbajo, BorderLayout.CENTER);

        frame.add(header, BorderLayout.NORTH);
        frame.add(body, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        Principal ver = new Principal();
    }
}
