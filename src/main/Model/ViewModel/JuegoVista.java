package main.Model.ViewModel;

public class JuegoVista {
    private int idJuego;
    private String nombreJuego;
    private String nombreCategoria;
    private double precio;

    public JuegoVista(String nombreJuego, String nombreCategoria, double precio) {
        this.nombreJuego = nombreJuego;
        this.nombreCategoria = nombreCategoria;
        this.precio = precio;
    }

    public JuegoVista(int idJuego, String nombreJuego, String nombreCategoria, double precio) {
        this.idJuego = idJuego;
        this.nombreJuego = nombreJuego;
        this.nombreCategoria = nombreCategoria;
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

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setIdCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
