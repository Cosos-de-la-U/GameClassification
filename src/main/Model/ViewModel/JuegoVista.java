package main.Model.ViewModel;

public class JuegoVista {
    private int idJuego;
    private String nombreJuego;
    private String nombreCategoria;
    private String clasificacion;
    private double precio;
    private String existencias;


    public JuegoVista(String nombreJuego, String nombreCategoria, String clasificacion, double precio, String existencias) {
        this.nombreJuego = nombreJuego;
        this.nombreCategoria = nombreCategoria;
        this.clasificacion = clasificacion;
        this.precio = precio;
        this.existencias = existencias;
    }

    public JuegoVista(int idJuego, String nombreJuego, String nombreCategoria, String clasificacion, double precio, String existencias) {
        this.idJuego = idJuego;
        this.nombreJuego = nombreJuego;
        this.nombreCategoria = nombreCategoria;
        this.clasificacion = clasificacion;
        this.precio = precio;
        this.existencias = existencias;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getExistencias() {
        return existencias;
    }

    public void setExistencias(String existencias) {
        this.existencias = existencias;
    }
}
