package main.Model.ViewModel;

public class CostoJuegoVista {
    private String nombreJuego;
    private double precio;

    public CostoJuegoVista(String nombreJuego, double precio) {
        this.nombreJuego = nombreJuego;
        this.precio = precio;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
