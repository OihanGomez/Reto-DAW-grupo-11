package Libreria.Paginas;

import Libreria.Acciones.BuscadorLibro;
import Libreria.Acciones.ConexionBD;
import Libreria.objetos.Libro;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal {
    public Principal(){
        JFrame frame = new JFrame("Bibliopolis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900,600));

        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        //Panel del encabezado
        JPanel header = new JPanel();
        header.setBackground(Color.BLACK);
        header.setLayout(new BorderLayout());
        header.setPreferredSize(new Dimension(700,100));

        //Icono del logo en el encabezado a la izquierda
        ImageIcon logo = new ImageIcon("src/Libreria/imagenes/logo_blanco.png");
        JLabel etiquetaFoto1 = new JLabel(logo);

        //Botones colocados en el encabezado en el centro
        JLabel ayuda = new JLabel("Ayuda con...");
        JLabel colecciones = new JLabel("Colecciones");
        JLabel eventosYNoticias = new JLabel("Eventos y Noticias");
        JLabel sobreNosotros = new JLabel("Visitas y Sobre nosotros");
        JLabel inicioSesion = new JLabel("inicioSesion");

        //Cambio del color de los botones del encabezado
        ayuda.setForeground(Color.WHITE);
        colecciones.setForeground(Color.WHITE);
        eventosYNoticias.setForeground(Color.WHITE);
        sobreNosotros.setForeground(Color.WHITE);
        inicioSesion.setForeground(Color.WHITE);

        //Formatos de texto de los botones del encabezado
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

        //Panel para agrupar los botones del encabezado
        JPanel grupoBotones = new JPanel();
        grupoBotones.setBackground(Color.BLACK);
        grupoBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        grupoBotones.setPreferredSize(new Dimension(700,100));
        grupoBotones.add(ayuda);
        grupoBotones.add(colecciones);
        grupoBotones.add(eventosYNoticias);
        grupoBotones.add(sobreNosotros);
        grupoBotones.add(inicioSesion);

        //Panel dentro del encabezado donde se mete todo el contenido, los paneles anteriores
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.BLACK);
        headerPanel.add(grupoBotones, BorderLayout.CENTER);
        headerPanel.add(etiquetaFoto1, BorderLayout.WEST);
        header.add(headerPanel, BorderLayout.CENTER);

        //Panel del cuerpo
        JPanel body = new JPanel();
        body.setPreferredSize(new Dimension(700,500));
        body.setLayout(new BorderLayout());

        //Panel de la parte superior del cuerpo
        JPanel bodyArriba = new JPanel();
        bodyArriba.setPreferredSize(new Dimension(700,125));
        bodyArriba.setLayout(null);

        //Panel de la parte inferior del cuerpo
        JPanel bodyAbajo = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bodyAbajo.setPreferredSize(new Dimension(700,300));
        bodyAbajo.setLayout(null);


        //Panel del contenido de dentro del "panelArriba"
        JPanel arribaContenido = new JPanel();
        arribaContenido.setPreferredSize(new Dimension(400,30));
        arribaContenido.setLayout(new BoxLayout(arribaContenido, BoxLayout.X_AXIS));
        arribaContenido.setBounds(300,40,300,30);

        //Area de texto del buscador
        JTextField buscadorTexto = new JTextField(30);
        TextPrompt placeHolder = new TextPrompt("Busca tu libro...", buscadorTexto);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        buscadorTexto.setPreferredSize(new Dimension(300,30));

        //Boton del buscador
        ImageIcon buscadorIcono = new ImageIcon("src/Libreria/imagenes/buscador.png");
        JLabel buscadorEtiqueta = new JLabel(buscadorIcono);
        buscadorEtiqueta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        //Panel del contenido de dentro del "panelAbajo"
        JPanel abajoContenido = new JPanel();
        abajoContenido.setBounds(5,5,874,326);
        abajoContenido.setLayout(null);

        //Panel del "Resultados de búsquedas"
        JPanel panelIzquerda = new JPanel();
        panelIzquerda.setLayout(null);
        panelIzquerda.setBounds(5,5,427,316);

        //Panel de "Libros populares"
        JPanel panelDerecha = new JPanel();
        panelDerecha.setLayout(null);
        panelDerecha.setBounds(440,5,427,316);

        //Adición del buscador de libros
        bodyArriba.add(arribaContenido,BorderLayout.NORTH);

        //Adición de "Resultado de búsqueda" y "Libros populares"
        bodyAbajo.add(abajoContenido);
        abajoContenido.add(panelIzquerda);
        abajoContenido.add(panelDerecha);

        //Lineas de alrededor de "Resultado de búsqueda" y "Libros populares"
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
        buscadorEtiqueta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nombreLibro = buscadorTexto.getText();
                ConexionBD conexion = new ConexionBD();
                BuscadorLibro buscadorLibro = new BuscadorLibro(conexion);

                Libro libro = buscadorLibro.buscarLibro(nombreLibro);

                if (libro != null) {
                    LibroInfo libroInfo = new LibroInfo(libro);
                    System.out.println("Instancia de LibroInfo creada correctamente.");
                    panelIzquerda.removeAll(); // Limpiar cualquier componente existente en el panel
                    panelIzquerda.add(libroInfo);
                    panelIzquerda.revalidate(); // Actualizar el panel para mostrar la nueva tarjeta del libro
                } else {
                    // Si el libro no se encuentra, mostrar un mensaje
                    JOptionPane.showMessageDialog(null, "El libro no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

    }

    public static void main(String[] args){
        Principal ver = new Principal();
    }
}
