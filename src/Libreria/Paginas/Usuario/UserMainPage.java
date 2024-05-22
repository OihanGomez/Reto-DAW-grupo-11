package Libreria.Paginas.Usuario;

import Libreria.Acciones.BuscadorLibro;
import Libreria.Acciones.ConexionBD;
import Libreria.Paginas.TextPrompt;
import Libreria.objetos.Libro;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class UserMainPage {
    public UserMainPage(){
        JFrame frame = new JFrame("Bibliopolis");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        etiquetaFoto1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //Botones colocados en el encabezado en el centro
        JLabel ayuda = new JLabel("Ayuda con...");
        JLabel colecciones = new JLabel("Colecciones");
        JLabel eventosYNoticias = new JLabel("Eventos y Noticias");
        JLabel sobreNosotros = new JLabel("Visitas y Sobre nosotros");

        //Icono de del usuario en el encabezado a la derecha
        ImageIcon userLogedIcon = new ImageIcon(("src/Libreria/imagenes/user_icon_white_resize.png"));
        JLabel inicioSesion = new JLabel(userLogedIcon);

        //Texto debajo del icono del usuario
        JLabel underUser = new JLabel("User");

        //Cambio del color de los botones del encabezado
        ayuda.setForeground(Color.WHITE);
        colecciones.setForeground(Color.WHITE);
        eventosYNoticias.setForeground(Color.WHITE);
        sobreNosotros.setForeground(Color.WHITE);
        inicioSesion.setForeground(Color.WHITE);
        underUser.setForeground(Color.WHITE);

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
        etiquetaFoto1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //Panel donde se encuentran el icono del usuario y el nombre del usuario
        JPanel vertical= new JPanel();
        vertical.setLayout(new BoxLayout(vertical, BoxLayout.Y_AXIS));
        vertical.setLayout(new FlowLayout());
        vertical.setPreferredSize(new Dimension(50,50));
        vertical.setBackground(Color.BLACK);
        vertical.add(inicioSesion);
        vertical.add(underUser);

        //Panel para agrupar los botones del encabezado
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

        buscadorEtiqueta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nombreLibro = buscadorTexto.getText();
                //buscadorEtiqueta(nombreLibro);
            }
        });

        // Añadir MouseListeners a los JLabels
        ayuda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
        });

        colecciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
        });

        eventosYNoticias.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                EventosYnoticias eventosYnoticias = new EventosYnoticias();
            }
        });

        sobreNosotros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                VisitasYsobreNosotros visitasYsobreNosotros = new VisitasYsobreNosotros();
            }
        });

        etiquetaFoto1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                UserMainPage visitasYsobreNosotros = new UserMainPage();
            }
        });

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
                    panelIzquerda.removeAll();
                    panelIzquerda.setLayout(new BoxLayout(panelIzquerda, BoxLayout.Y_AXIS));

                    // Crear panel para la carta del libro
                    JPanel bookCard = new JPanel();
                    bookCard.setLayout(new BoxLayout(bookCard, BoxLayout.X_AXIS));
                    bookCard.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                    // Panel de información del libro
                    JPanel infoPanel = new JPanel();
                    infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

                    // Agregar etiquetas de información
                    JLabel titleLabel = new JLabel("Título: " + libro.getTitulo());
                    JLabel descriptionLabel = new JLabel("<html>Descripción: " + libro.getDescripcion() + "</html>");
                    JLabel priceLabel = new JLabel("Precio: " + libro.getPrecio());
                    JLabel editorialIdLabel = new JLabel("ID Editorial: " + libro.getIdEditorial());

                    infoPanel.add(titleLabel);
                    infoPanel.add(descriptionLabel);
                    infoPanel.add(priceLabel);
                    infoPanel.add(editorialIdLabel);

                    // Crear la etiqueta de la imagen del libro
                    String imagePath = libro.getPortadaRuta();
                    File imageFile = new File(imagePath);
                    if (!imageFile.isAbsolute()) {
                        imageFile = new File(System.getProperty("user.dir"), imagePath); // Construir ruta absoluta
                    }

                    // Cargar y redimensionar la imagen
                    ImageIcon originalIcon = new ImageIcon(imageFile.getAbsolutePath());
                    Image originalImage = originalIcon.getImage();
                    int newWidth = 100; // Ancho deseado
                    int newHeight = (originalIcon.getIconHeight() * newWidth) / originalIcon.getIconWidth(); // Mantener la relación de aspecto
                    Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                    ImageIcon resizedIcon = new ImageIcon(resizedImage);

                    JLabel coverLabel;
                    if (resizedIcon.getIconWidth() > 0) {
                        coverLabel = new JLabel(resizedIcon);
                    } else {
                        coverLabel = new JLabel("Imagen no disponible");
                    }

                    // Agregar panel de información y etiqueta de imagen al panel de la carta
                    bookCard.add(coverLabel);
                    bookCard.add(Box.createRigidArea(new Dimension(10, 0))); // Espacio entre imagen y texto
                    bookCard.add(infoPanel);

                    // Agregar la carta del libro al panel izquierdo
                    panelIzquerda.add(bookCard);

                    panelIzquerda.revalidate();
                    panelIzquerda.repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "El libro no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });




    }
    public static void main(String[] args){
        UserMainPage ver = new UserMainPage();
    }

}
