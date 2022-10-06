package main.Model;

public class Juego {
    private int idJuego;
    private String nombreJuego;
    private int idCategoria;
    private double precio;

    public Juego(String nombreJuego, int idCategoria, double precio) {
        this.nombreJuego = nombreJuego;
        this.idCategoria = idCategoria;
        this.precio = precio;
    }

    public Juego(int idJuego, String nombreJuego, int idCategoria, double precio) {
        this.idJuego = idJuego;
        this.nombreJuego = nombreJuego;
        this.idCategoria = idCategoria;
        this.precio = precio;
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
}
