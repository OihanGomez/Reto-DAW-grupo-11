package Libreria.Paginas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VisitasYsobreNosotros {

    public VisitasYsobreNosotros() {
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

        // Etiquetas del menú
        JLabel ayuda = new JLabel("Ayuda con...");
        JLabel colecciones = new JLabel("Colecciones");
        JLabel eventosYNoticias = new JLabel("Eventos y Noticias");
        JLabel sobreNosotros = new JLabel("Visitas y Sobre nosotros");

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

        //============[ CUERPO PRINCIPAL ]=======================================================

        JPanel body = new JPanel(new GridLayout(2, 1));

        //----[ NOTICIAS ]-----------------------------------------------------------------------------
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

        //----[ NOTICIAS ]-----------------------------------------------------------------------------

        // Añadir el panel body al marco principal
        frame.add(body, BorderLayout.CENTER);

        // Añadir el panel header al marco principal
        frame.add(header, BorderLayout.NORTH);

        // Hacer visible el marco principal
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        VisitasYsobreNosotros visitasYsobreNosotros = new VisitasYsobreNosotros();
    }
}
