package JuegoCartas;

public abstract class Pocima {
    private String nombre;
    public Pocima(String nombre){
        this.nombre = nombre;
    }
    public String getNombre() {
        return this.nombre;
    }
    public abstract void aplicar(Carta carta);
}
