package Libreria.Paginas;

import Libreria.objetos.Libro;

import javax.swing.*;
import java.awt.*;

public class LibroInfo extends JPanel {
    private JLabel tituloLabel;
    private JLabel autorLabel;
    private JLabel isbnLabel;
    private JLabel editorialLabel;
    private JLabel imagenLabel; // Nuevo JLabel para la imagen
    // Agrega más etiquetas según los detalles que quieras mostrar

    public LibroInfo(Libro libro) {
        setLayout(new BorderLayout());

        JPanel detallesPanel = new JPanel(new GridLayout(4, 1));
        tituloLabel = new JLabel("Título: " + libro.getTitulo());
        autorLabel = new JLabel("Descripcion: " + libro.getDescripcion());
        isbnLabel = new JLabel("ISBN: " + libro.getIdEditorial());
        editorialLabel = new JLabel("Precio: " + libro.getPrecio());


        detallesPanel.add(tituloLabel);
        detallesPanel.add(autorLabel);
        detallesPanel.add(isbnLabel);
        detallesPanel.add(editorialLabel);

        imagenLabel = new JLabel();
        ImageIcon imagen = new ImageIcon(libro.getPortadaRuta());
        imagenLabel.setIcon(imagen);

        add(imagenLabel, BorderLayout.CENTER);
        add(detallesPanel, BorderLayout.SOUTH);

        setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Añade borde para resaltar la tarjeta
    }
}
