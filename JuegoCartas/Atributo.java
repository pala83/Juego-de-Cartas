package JuegoCartas;
public class Atributo {
    private String nombre;
    private double valor;

    public Atributo(String nombre, double valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "\"" + this.nombre + "\": " + this.valor;
    }
}
