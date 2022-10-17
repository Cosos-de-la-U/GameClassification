package main.Model;

public class Juego {
    private int idJuego;
    private String nombreJuego;
    private int idCategoria;
    private String clasificacion;
    private double precio;
    private int existencias;

    public Juego(String nombreJuego, int idCategoria, String clasificacion, double precio, int existencias) {
        this.nombreJuego = nombreJuego;
        this.idCategoria = idCategoria;
        this.clasificacion = clasificacion;
        this.precio = precio;
        this.existencias = existencias;
    }

    public Juego(int idJuego, String nombreJuego, int idCategoria, String clasificacion, double precio, int existencias) {
        this.idJuego = idJuego;
        this.nombreJuego = nombreJuego;
        this.idCategoria = idCategoria;
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

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getClasificaion() {
        return clasificacion;
    }

    public void setClasificaion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
}
