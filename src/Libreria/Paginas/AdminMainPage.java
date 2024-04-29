package Libreria.Paginas;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class AdminMainPage {
    public AdminMainPage() {
        JFrame frame = new JFrame("Bibliopolis");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 600));

        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        //Panel del encabezado
        JPanel header = new JPanel();
        header.setBackground(Color.BLACK);
        header.setLayout(new BorderLayout());
        header.setPreferredSize(new Dimension(700, 100));

        //Icono del logo en el encabezado a la izquierda
        ImageIcon logo = new ImageIcon("src/Libreria/imagenes/logo_blanco.png");
        JLabel etiquetaFoto1 = new JLabel(logo);

        //Botones colocados en el encabezado en el centro
        JLabel ayuda = new JLabel("Ayuda con...");
        JLabel colecciones = new JLabel("Colecciones");
        JLabel eventosYNoticias = new JLabel("Eventos y Noticias");
        JLabel sobreNosotros = new JLabel("Visitas y Sobre nosotros");

        //Icono de del admin en el encabezado a la derecha
        ImageIcon userLogedIcon = new ImageIcon(("src/Libreria/imagenes/user_icon_white_resize.png"));
        JLabel inicioSesion = new JLabel(userLogedIcon);

        //Texto debajo del icono del admin
        JLabel underUser = new JLabel("Admin");

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

        //Panel donde se encuentran el icono del admin y el nombre del admin
        JPanel vertical = new JPanel();
        vertical.setLayout(new BoxLayout(vertical, BoxLayout.Y_AXIS));
        vertical.setLayout(new FlowLayout());
        vertical.setPreferredSize(new Dimension(50, 50));
        vertical.setBackground(Color.BLACK);
        vertical.add(inicioSesion);
        vertical.add(underUser);

        //Panel para agrupar los botones del encabezado
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
        grupoBotones.add(Box.createHorizontalStrut(70));
        grupoBotones.add(vertical);

        //Panel dentro del encabezado donde se mete todo el contenido, los paneles anteriores
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.BLACK);
        headerPanel.add(grupoBotones, BorderLayout.CENTER);
        headerPanel.add(etiquetaFoto1, BorderLayout.WEST);
        header.add(headerPanel, BorderLayout.CENTER);

        //Contenido que va dentro del panel "panelEdit"
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(50,50,200,30);
        JTextField direccion = new JTextField();
        direccion.setBounds(50,100,200,30);
        JTextField nombre = new JTextField();
        nombre.setBounds(50,150,200,30);
        JTextField apellido = new JTextField();
        apellido.setBounds(50,200,200,30);
        JTextField correo = new JTextField();
        correo.setBounds(50,250,200,30);
        JTextField contraseña = new JTextField();
        contraseña.setBounds(50,300,200,30);
        JLabel direccionEtiqueta = new JLabel("Dirección:");
        direccionEtiqueta.setBounds(50,77,150,30);
        JLabel nombreEtiqueta = new JLabel("Nombre:");
        nombreEtiqueta.setBounds(50,127,150,30);
        JLabel apellidoEtiqueta = new JLabel("Apellido:");
        apellidoEtiqueta.setBounds(50,177,150,30);
        JLabel correoEtiqueta = new JLabel("Correo:");
        correoEtiqueta.setBounds(50,227,150,30);
        JLabel contraseñaEtiqueta = new JLabel("Contraseña:");
        contraseñaEtiqueta.setBounds(50,277,150,30);
        JLabel aceptarEdit = new JLabel("Aceptar cambios");
        aceptarEdit.setBounds(100,350,150,30);

        //Formatos de las etiquetas
        direccionEtiqueta.setFont(new Font("Arial",Font.BOLD,14));
        nombreEtiqueta.setFont(new Font("Arial",Font.BOLD,14));
        apellidoEtiqueta.setFont(new Font("Arial",Font.BOLD,14));
        correoEtiqueta.setFont(new Font("Arial",Font.BOLD,14));
        contraseñaEtiqueta.setFont(new Font("Arial",Font.BOLD,14));
        aceptarEdit.setFont(new Font("Arial",Font.BOLD,14));
        aceptarEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //Panel de detro del panel "body"
        JPanel panelEdit = new JPanel();
        panelEdit.setBounds(300,25,300,400);
        panelEdit.setLayout(null);
        panelEdit.add(comboBox);
        panelEdit.add(correo);
        panelEdit.add(nombre);
        panelEdit.add(contraseña);
        panelEdit.add(aceptarEdit);
        panelEdit.add(apellido);
        panelEdit.add(direccion);
        panelEdit.add(direccionEtiqueta);
        panelEdit.add(nombreEtiqueta);
        panelEdit.add(apellidoEtiqueta);
        panelEdit.add(correoEtiqueta);
        panelEdit.add(contraseñaEtiqueta);


        //Panel del cuerpo
        JPanel body = new JPanel();
        body.setPreferredSize(new Dimension(700, 500));
        body.setLayout(null);
        body.add(panelEdit);

        //Lineas que rodean el panel "panelEdit"
        panelEdit.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Usuarios",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));

        frame.add(header, BorderLayout.NORTH);
        frame.add(body, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        AdminMainPage ver = new AdminMainPage();
    }
}
