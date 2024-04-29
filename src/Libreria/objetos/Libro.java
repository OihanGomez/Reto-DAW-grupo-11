package Libreria.objetos;

public class Libro {
    // Atributos
    private int idLibro;
    private String titulo;
    private String descripcion;
    private double precio;
    private int idEditorial;
    private String portadaRuta;

    // Constructor
    public Libro(int idLibro, String titulo, String descripcion, double precio, int idEditorial, String portadaRuta) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idEditorial = idEditorial;
        this.portadaRuta = portadaRuta;
    }

    // Métodos getters y setters
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getPortadaRuta() {
        return portadaRuta;
    }

    public void setPortadaRuta(String portadaRuta) {
        this.portadaRuta = portadaRuta;
    }

    // Método para imprimir información del libro
    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", idEditorial=" + idEditorial +
                ", portadaRuta='" + portadaRuta + '\'' +
                '}';
    }
}
