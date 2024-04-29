package Libreria.Paginas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventosYnoticias {
    public EventosYnoticias(){
        // Creación del marco principal
        JFrame frame = new JFrame("Bibliopolis");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900,600));
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // Header
        JPanel header = new JPanel();
        header.setBackground(Color.BLACK);
        header.setLayout(new BorderLayout());
        header.setPreferredSize(new Dimension(700,100));

        // Logo
        ImageIcon logo = new ImageIcon("src/Libreria/imagenes/logo_blanco.png");
        JLabel etiquetaFoto1 = new JLabel(logo);
        etiquetaFoto1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Etiquetas del menú
        JLabel ayuda = new JLabel("Ayuda con...");
        JLabel colecciones = new JLabel("Colecciones");
        JLabel eventosYNoticias = new JLabel("Eventos y Noticias");
        JLabel sobreNosotros = new JLabel("Visitas y Sobre nosotros");

        // Poner la letra de la página seleccionada en blanco
        eventosYNoticias.setForeground(Color.WHITE);

        // Icono de usuario logueado
        ImageIcon userLogedIcon = new ImageIcon(("src/Libreria/imagenes/user_icon_white_resize.png"));
        JLabel inicioSesion = new JLabel(userLogedIcon);
        JLabel underUser = new JLabel("User");

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
        underUser.setFont(font);

        // Panel vertical para usuario logueado
        JPanel vertical = new JPanel();
        vertical.setLayout(new BoxLayout(vertical, BoxLayout.Y_AXIS));
        vertical.setLayout(new FlowLayout());
        vertical.setPreferredSize(new Dimension(50,50));
        vertical.setBackground(Color.BLACK);
        vertical.add(inicioSesion);
        vertical.add(underUser);

        // Panel de botones del menú
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

        // Panel de encabezado que contiene el logo y los botones del menú
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.BLACK);
        headerPanel.add(grupoBotones, BorderLayout.CENTER);
        headerPanel.add(etiquetaFoto1, BorderLayout.WEST);
        header.add(headerPanel, BorderLayout.CENTER);

        //============[ CUERPO PRINCIPAL ]=======================================================

        JPanel body = new JPanel(new GridLayout(1, 2));

        //----[ NOTICIAS ]-----------------------------------------------------------------------------
        //color
        int red = 210;
        int green = 210;
        int blue = 210;
        Color miColor = new Color(red, green, blue);


        JPanel noticiasPanel = new JPanel(new BorderLayout());
        noticiasPanel.setBackground(miColor);
        noticiasPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Añadir margen

        //titulo
        JLabel noticiasLabel = new JLabel("NOTICIAS");
        noticiasLabel.setHorizontalAlignment(SwingConstants.CENTER);
        noticiasLabel.setFont(new Font("Arial", Font.BOLD,24));
        noticiasPanel.add(noticiasLabel, BorderLayout.NORTH);

        // Subpanel para información de noticias
        JPanel noticiasInfoPanel = new JPanel();
        noticiasInfoPanel.setBackground(Color.WHITE);
        noticiasPanel.add(noticiasInfoPanel, BorderLayout.CENTER);

        // Subtitulo
        JLabel subtituloNoticias = new JLabel("~Ultimas noticias de todas nuestras bibliotecas~");
        subtituloNoticias.setHorizontalAlignment(SwingConstants.CENTER);
        subtituloNoticias.setFont(new Font("Centaur", Font.BOLD, 14));

        // Configuración de GridBagConstraints para el subtítulo
        GridBagConstraints gbcSubtitulo = new GridBagConstraints();
        gbcSubtitulo.gridx = 0;
        gbcSubtitulo.gridy = 0;
        gbcSubtitulo.anchor = GridBagConstraints.CENTER;
        gbcSubtitulo.insets = new Insets(0, 0, 10, 0); // Espacio inferior

        noticiasInfoPanel.add(subtituloNoticias, gbcSubtitulo);

        // Panel contenedor para noticias
        JPanel containerNoticias = new JPanel();
        containerNoticias.setBackground(Color.lightGray);
        containerNoticias.setPreferredSize(new Dimension(320, 350)); // Establecer tamaño inicial
        containerNoticias.setMinimumSize(new Dimension(320, 350)); // Establecer tamaño mínimo

        // Configuración de GridBagConstraints para el contenedor de noticias
        GridBagConstraints gbcContainerNoticias = new GridBagConstraints();
        gbcContainerNoticias.gridx = 0;
        gbcContainerNoticias.gridy = 1;
        gbcContainerNoticias.fill = GridBagConstraints.BOTH; // Rellenar horizontal y verticalmente
        gbcContainerNoticias.weightx = 1.0; // Peso horizontal para que se expanda
        gbcContainerNoticias.weighty = 1.0; // Peso vertical para que se expanda
        gbcContainerNoticias.anchor = GridBagConstraints.CENTER;


        noticiasInfoPanel.add(containerNoticias, gbcContainerNoticias);

// Crear un BoxLayout vertical para el contenedor de noticias
        containerNoticias.setLayout(new BoxLayout(containerNoticias, BoxLayout.Y_AXIS));

// Número de paneles a crear
        JPanel[] panels = new JPanel[4];

// Crear y agregar los paneles al contenedor
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
            panels[i].setBackground(miColor);
            panels[i].setBorder(BorderFactory.createBevelBorder(1,Color.white,Color.white));
            // No es necesario establecer los límites aquí
            containerNoticias.add(panels[i]);
        }




        body.add(noticiasPanel);

        //----[ NOTICIAS ]-----------------------------------------------------------------------------




        //----[ EVENTOS ]-----------------------------------------------------------------------------
        JPanel eventosPanel = new JPanel(new BorderLayout());
        eventosPanel.setBackground(miColor);
        eventosPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Añadir margen

// Título de eventos
        JLabel eventosLabel = new JLabel("PROXIMOS EVENTOS");
        eventosLabel.setHorizontalAlignment(SwingConstants.CENTER);
        eventosLabel.setFont(new Font("Arial", Font.BOLD, 24));
        eventosPanel.add(eventosLabel, BorderLayout.NORTH);

// Subpanel para información de eventos
        JPanel eventosInfoPanel = new JPanel();
        eventosInfoPanel.setBackground(Color.WHITE); // Color de fondo para distinguirlo
        eventosPanel.add(eventosInfoPanel, BorderLayout.CENTER); // Agregar el subpanel al panel de eventos

// Subtítulo de próximos eventos
        JLabel subtituloProximosEventos = new JLabel("~Proximos eventos en nuestras bibliotecas~");
        subtituloProximosEventos.setHorizontalAlignment(SwingConstants.CENTER);
        subtituloProximosEventos.setFont(new Font("Centaur", Font.BOLD, 14));
        eventosInfoPanel.add(subtituloProximosEventos, BorderLayout.NORTH);

// Configuración de GridBagConstraints para el subtítulo de eventos
        GridBagConstraints gbcSubtituloEventos = new GridBagConstraints();
        gbcSubtituloEventos.gridx = 0;
        gbcSubtituloEventos.gridy = 0;
        gbcSubtituloEventos.anchor = GridBagConstraints.CENTER;
        gbcSubtituloEventos.insets = new Insets(0, 0, 10, 0); // Espacio inferior

        eventosInfoPanel.add(subtituloProximosEventos, gbcSubtituloEventos);

// Panel contenedor para eventos
        JPanel containerEventos = new JPanel();
        containerEventos.setBackground(Color.LIGHT_GRAY);
        containerEventos.setPreferredSize(new Dimension(300, 350)); // Establecer tamaño inicial
        containerEventos.setMinimumSize(new Dimension(300, 350)); // Establecer tamaño mínimo

// Configuración de GridBagConstraints para el contenedor de eventos
        GridBagConstraints gbcContainerEventos = new GridBagConstraints();
        gbcContainerEventos.gridx = 0;
        gbcContainerEventos.gridy = 1;
        gbcContainerEventos.fill = GridBagConstraints.BOTH; // Rellenar horizontal y verticalmente
        gbcContainerEventos.weightx = 1.0; // Peso horizontal para que se expanda
        gbcContainerEventos.weighty = 1.0; // Peso vertical para que se expanda
        gbcContainerEventos.anchor = GridBagConstraints.CENTER;

        eventosInfoPanel.add(containerEventos, gbcContainerEventos);

// Crear un BoxLayout vertical para el contenedor de eventos
        containerEventos.setLayout(new BoxLayout(containerEventos, BoxLayout.Y_AXIS));

// Número de paneles a crear
        JPanel[] eventosPanels = new JPanel[4];

// Crear y agregar los paneles al contenedor de eventos
        for (int i = 0; i < eventosPanels.length; i++) {
            eventosPanels[i] = new JPanel();
            eventosPanels[i].setBackground(miColor);
            eventosPanels[i].setBorder(BorderFactory.createBevelBorder(1, Color.WHITE, Color.WHITE));
            // No es necesario establecer los límites aquí
            containerEventos.add(eventosPanels[i]);
        }

        body.add(eventosPanel);


        //----[ EVENTOS ]-----------------------------------------------------------------------------




        //========[ CUERPO PRINCIPAL ]=================================================================

        // Añadir componentes al marco principal
        frame.add(header, BorderLayout.NORTH);
        frame.add(body, BorderLayout.CENTER);

        // Hacer visible el marco principal
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        EventosYnoticias eventosYnoticias = new EventosYnoticias();
    }
}
