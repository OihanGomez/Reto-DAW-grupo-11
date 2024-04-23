package Libreria.Paginas;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserMainPage {
    public UserMainPage(){
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

        ImageIcon logo = new ImageIcon("src/Libreria/imagenes/logo_blanco.png");
        JLabel etiquetaFoto1 = new JLabel(logo);

        JLabel ayuda = new JLabel("Ayuda con...");
        JLabel colecciones = new JLabel("Colecciones");
        JLabel eventosYNoticias = new JLabel("Eventos y Noticias");
        JLabel sobreNosotros = new JLabel("Visitas y Sobre nosotros");

        ImageIcon userLogedIcon = new ImageIcon(("src/Libreria/imagenes/user_icon_white_resize.png"));
        JLabel inicioSesion = new JLabel(userLogedIcon);

        JLabel underUser = new JLabel("User");
        ayuda.setForeground(Color.WHITE);
        colecciones.setForeground(Color.WHITE);
        eventosYNoticias.setForeground(Color.WHITE);
        sobreNosotros.setForeground(Color.WHITE);
        inicioSesion.setForeground(Color.WHITE);
        underUser.setForeground(Color.WHITE);

        ayuda.setFont(new Font("Arial",Font.BOLD,14));
        ayuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        colecciones.setFont(new Font("Arial",Font.BOLD,14));
        colecciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        eventosYNoticias.setFont(new Font("Arial",Font.BOLD,14));
        eventosYNoticias.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sobreNosotros.setFont(new Font("Arial",Font.BOLD,14));
        sobreNosotros.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        inicioSesion.setFont(new Font("Arial",Font.BOLD,14));
        inicioSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));



        ayuda.setFont(new Font("Arial",Font.BOLD,14));
        colecciones.setFont(new Font("Arial",Font.BOLD,14));
        eventosYNoticias.setFont(new Font("Arial",Font.BOLD,14));
        sobreNosotros.setFont(new Font("Arial",Font.BOLD,14));
        underUser.setFont(new Font("Arial",Font.BOLD,14));

        JPanel vertical= new JPanel();
        vertical.setLayout(new BoxLayout(vertical, BoxLayout.Y_AXIS));
        vertical.setLayout(new FlowLayout());
        vertical.setPreferredSize(new Dimension(50,50));
        vertical.setBackground(Color.BLACK);
        vertical.add(inicioSesion);
        vertical.add(underUser);

        JPanel grupoBotones = new JPanel();
        grupoBotones.setBackground(Color.BLACK);
        grupoBotones.setLayout(new BoxLayout(grupoBotones, BoxLayout.X_AXIS));
        grupoBotones.setPreferredSize(new Dimension(200,100));
        grupoBotones.add(Box.createHorizontalStrut(40));
        grupoBotones.add(ayuda);
        grupoBotones.add(Box.createHorizontalStrut(40));
        grupoBotones.add(colecciones);
        grupoBotones.add(Box.createHorizontalStrut(40));
        grupoBotones.add(eventosYNoticias);
        grupoBotones.add(Box.createHorizontalStrut(40));
        grupoBotones.add(sobreNosotros);
        grupoBotones.add(Box.createHorizontalStrut(70));
        grupoBotones.add(vertical);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.BLACK);
        headerPanel.add(grupoBotones, BorderLayout.CENTER);
        headerPanel.add(etiquetaFoto1, BorderLayout.WEST);
        header.add(headerPanel, BorderLayout.CENTER);



        //Body
        JPanel body = new JPanel();
        body.setPreferredSize(new Dimension(700,500));
        body.setLayout(new BorderLayout());

        //Contenido panel
        JPanel bodyArriba = new JPanel();
        bodyArriba.setPreferredSize(new Dimension(700,125));
        bodyArriba.setLayout(null);


        JPanel bodyAbajo = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bodyAbajo.setPreferredSize(new Dimension(700,300));
        bodyAbajo.setLayout(null);


        //Panel de dentro de panelArriba

        JPanel arribaContenido = new JPanel();
        arribaContenido.setPreferredSize(new Dimension(400,30));
        arribaContenido.setLayout(new BoxLayout(arribaContenido, BoxLayout.X_AXIS));
        arribaContenido.setBounds(300,40,300,30);

        JTextField buscadorTexto = new JTextField(30);
        TextPrompt placeHolder = new TextPrompt("Busca tu libro...", buscadorTexto);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        buscadorTexto.setPreferredSize(new Dimension(300,30));

        ImageIcon buscadorIcono = new ImageIcon("src/Libreria/imagenes/buscador.png");
        JLabel buscadorEtiqueta = new JLabel(buscadorIcono);
        buscadorEtiqueta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        buscadorEtiqueta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nombreLibro = buscadorTexto.getText();
                //buscadorEtiqueta(nombreLibro);
            }
        });


        //Panel dentro de panelAbajo

        JPanel abajoContenido = new JPanel();
        abajoContenido.setBounds(5,5,874,326);
        abajoContenido.setLayout(null);


        //Contenido de abajoContenido

        JPanel panelIzquerda = new JPanel();
        panelIzquerda.setLayout(null);
        panelIzquerda.setBounds(5,5,427,316);

        JPanel panelDerecha = new JPanel();
        panelDerecha.setLayout(null);
        panelDerecha.setBounds(440,5,427,316);

        //Añadir contenido

        bodyAbajo.add(abajoContenido);
        bodyArriba.add(arribaContenido,BorderLayout.NORTH);
        abajoContenido.add(panelIzquerda);
        abajoContenido.add(panelDerecha);
        panelIzquerda.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Resultados de búsqueda",
                TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
        panelDerecha.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Libros populares",
                TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));

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
        UserMainPage ver = new UserMainPage();
    }

}
