package Libreria.Paginas.NoLogUsuario;

import Libreria.Paginas.TextPrompt;
import Libreria.Paginas.Usuario.EventosYnoticias;
import Libreria.Paginas.Usuario.UserMainPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VisitasYsobreNosotrosUserNoLog {

    public VisitasYsobreNosotrosUserNoLog() {
        // Creación del marco principal
        JFrame frame = new JFrame("Bibliopolis");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 600));
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // Header
        JPanel header = new JPanel();
        header.setBackground(Color.BLACK);
        header.setLayout(new BorderLayout());
        header.setPreferredSize(new Dimension(700, 100));

        // Logo
        ImageIcon logo = new ImageIcon("src/Libreria/imagenes/logo_blanco.png");
        JLabel etiquetaFoto1 = new JLabel(logo);
        etiquetaFoto1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Etiquetas del menú
        JLabel ayuda = new JLabel("Ayuda con...");
        JLabel colecciones = new JLabel("Colecciones");
        JLabel eventosYNoticias = new JLabel("Eventos y Noticias");
        JLabel sobreNosotros = new JLabel("Visitas y Sobre nosotros");
        JLabel inicioSesion = new JLabel("inicioSesion");


        //Panel donde se encuentran el icono del usuario y el nombre del usuario
        JPanel vertical= new JPanel();
        vertical.setLayout(new BoxLayout(vertical, BoxLayout.Y_AXIS));
        vertical.setLayout(new FlowLayout());
        vertical.setPreferredSize(new Dimension(50,50));
        vertical.setBackground(Color.BLACK);
        vertical.add(inicioSesion);


        // Poner la letra de la página seleccionada en blanco
        sobreNosotros.setForeground(Color.WHITE);

        // Configuración de fuentes y cursores
        Font font = new Font("Arial", Font.BOLD, 14);
        Cursor handCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        ayuda.setFont(font);
        ayuda.setCursor(handCursor);
        colecciones.setFont(font);
        colecciones.setCursor(handCursor);
        eventosYNoticias.setFont(font);
        eventosYNoticias.setCursor(handCursor);
        sobreNosotros.setFont(font);
        sobreNosotros.setCursor(handCursor);
        inicioSesion.setFont(font);
        inicioSesion.setCursor(handCursor);

        // Panel de botones del menú
        JPanel grupoBotones = new JPanel();
        grupoBotones.setBackground(Color.BLACK);
        grupoBotones.setLayout(new BoxLayout(grupoBotones, BoxLayout.X_AXIS));
        grupoBotones.setPreferredSize(new Dimension(200, 100));
        grupoBotones.add(Box.createHorizontalStrut(40));
        grupoBotones.add(ayuda);
        grupoBotones.add(Box.createHorizontalStrut(40));
        grupoBotones.add(colecciones);
        grupoBotones.add(Box.createHorizontalStrut(40));
        grupoBotones.add(eventosYNoticias);
        grupoBotones.add(Box.createHorizontalStrut(40));
        grupoBotones.add(sobreNosotros);
        grupoBotones.add(Box.createHorizontalStrut(40));
        grupoBotones.add(inicioSesion);


        // Panel de encabezado que contiene el logo y los botones del menú
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.BLACK);
        headerPanel.add(grupoBotones, BorderLayout.CENTER);
        headerPanel.add(etiquetaFoto1, BorderLayout.WEST);
        header.add(headerPanel, BorderLayout.CENTER);

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
                EventosYnoticiasUserNoLog eventosYnoticias = new EventosYnoticiasUserNoLog();
            }
        });

        sobreNosotros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                VisitasYsobreNosotrosUserNoLog visitasYsobreNosotros = new VisitasYsobreNosotrosUserNoLog();
            }
        });

        etiquetaFoto1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                UserNoLogMainPage visitasYsobreNosotros = new UserNoLogMainPage();
            }
        });

        //============[ CUERPO PRINCIPAL ]=======================================================

        JPanel body = new JPanel(new GridLayout(2, 1));

        //----[ Programar Visita ]-----------------------------------------------------------------------------
        //color
        int red = 210;
        int green = 210;
        int blue = 210;
        Color miColor = new Color(red, green, blue);

        JPanel ProgramarVisita = new JPanel(new BorderLayout());
        ProgramarVisita.setBackground(miColor);
        // Ajuste de los márgenes a 30 píxeles
        ProgramarVisita.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Subpanel para contenido de ProgramarVisita
        JPanel subPanel = new JPanel(new BorderLayout());
        subPanel.setBackground(Color.WHITE);
        ProgramarVisita.add(subPanel, BorderLayout.CENTER);

        // Subpanel para información de noticias
        JPanel noticiasInfoPanel = new JPanel(new GridLayout(0, 1)); // GridLayout para organizar los componentes verticalmente
        subPanel.add(noticiasInfoPanel, BorderLayout.CENTER);

        //titulo
        JLabel tituloProgramarVisita = new JLabel("Programar una visita");
        tituloProgramarVisita.setHorizontalAlignment(SwingConstants.CENTER);
        tituloProgramarVisita.setFont(new Font("Arial", Font.BOLD, 28));
        // Ajuste de los márgenes laterales a 30 píxeles
        tituloProgramarVisita.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        noticiasInfoPanel.add(tituloProgramarVisita);

        // Etiquetas del busqueda y programacion de una visita
        JLabel fechaLabel = new JLabel("Correo electrónico:");
        noticiasInfoPanel.add(fechaLabel);

        // Área de texto del usuario y la contraseña
        JTextField fechaText = new JTextField(10);
        TextPrompt placeholder1 = new TextPrompt("example@gmail.com", fechaText);
        placeholder1.changeAlpha(0.75f);
        placeholder1.changeStyle(Font.ITALIC);
        noticiasInfoPanel.add(fechaText);

        JLabel DNILabel = new JLabel("Fecha:");
        noticiasInfoPanel.add(DNILabel);

        JTextField DNIText = new JTextField(10);
        TextPrompt placeholder2 = new TextPrompt("Fecha formato AAAA/MM/DD ", DNIText);
        placeholder2.changeAlpha(0.75f);
        placeholder2.changeStyle(Font.ITALIC);
        noticiasInfoPanel.add(DNIText);

        // Botón de busqueda
        JButton buscarButton = new JButton("Buscar posibles visitas");
        buscarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        noticiasInfoPanel.add(buscarButton);

        body.add(ProgramarVisita);

        //----[ PANEL ADICIONAL ]---------------------------------------------------------------------
        JPanel panelAdicional = new JPanel(new BorderLayout());
        panelAdicional.setBackground(miColor);
        panelAdicional.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30)); // Añadir margen

        // Título del panel adicional
        JLabel tituloPanelAdicional = new JLabel("Sobre nosotros");
        tituloPanelAdicional.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPanelAdicional.setFont(new Font("Arial", Font.BOLD, 28));
        panelAdicional.add(tituloPanelAdicional, BorderLayout.NORTH);

        // Subpanel para contenido del panel adicional
        JPanel contenidoPanelAdicional = new JPanel();
        contenidoPanelAdicional.setBackground(Color.WHITE); // Color de fondo para distinguirlo
        panelAdicional.add(contenidoPanelAdicional, BorderLayout.CENTER); // Agregar el subpanel al panel adicional

        // Subtítulo del panel adicional
        JLabel subtituloPanelAdicional = new JLabel("<html><div style='text-align: center; width: 300px;'>Bibliopolis es una innovadora aplicación diseñada para satisfacer las necesidades de bibliotecas y librerías de todo el mundo. Con una interfaz intuitiva y funciones avanzadas, Bibliopolis simplifica la gestión de libros, préstamos, eventos y más. Desde pequeñas bibliotecas comunitarias hasta grandes librerías, nuestra plataforma ofrece soluciones adaptadas a cada necesidad. ¡Únete a nosotros y lleva tu biblioteca al siguiente nivel con Bibliopolis!</div></html>");
        subtituloPanelAdicional.setHorizontalAlignment(SwingConstants.CENTER);
        subtituloPanelAdicional.setFont(new Font("Centaur", Font.BOLD, 14));
        contenidoPanelAdicional.add(subtituloPanelAdicional, BorderLayout.NORTH);


        // Panel contenedor para contenido adicional
        JPanel containerPanelAdicional = new JPanel();
        containerPanelAdicional.setBackground(Color.LIGHT_GRAY);
        containerPanelAdicional.setPreferredSize(new Dimension(300, 350)); // Establecer tamaño inicial
        containerPanelAdicional.setMinimumSize(new Dimension(300, 350)); // Establecer tamaño mínimo

        containerPanelAdicional.setLayout(new BoxLayout(containerPanelAdicional, BoxLayout.Y_AXIS));

        // Número de paneles a crear
        JPanel[] panelAdicionalPanels = new JPanel[4];

        // Crear y agregar los paneles al contenedor del panel adicional
        for (int i = 0; i < panelAdicionalPanels.length; i++) {
            panelAdicionalPanels[i] = new JPanel();
            panelAdicionalPanels[i].setBackground(miColor);
            panelAdicionalPanels[i].setBorder(BorderFactory.createBevelBorder(1, Color.WHITE, Color.WHITE));
            containerPanelAdicional.add(panelAdicionalPanels[i]);
        }

        body.add(panelAdicional);

        //========[ CUERPO PRINCIPAL ]=================================================================

        // Añadir el panel body al marco principal
        frame.add(body, BorderLayout.CENTER);

        // Añadir el panel header al marco principal
        frame.add(header, BorderLayout.NORTH);

        // Hacer visible el marco principal
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        VisitasYsobreNosotrosUserNoLog visitasYsobreNosotros = new VisitasYsobreNosotrosUserNoLog();
    }
}
