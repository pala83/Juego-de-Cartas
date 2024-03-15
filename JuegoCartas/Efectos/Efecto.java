package JuegoCartas.Efectos;

import JuegoCartas.Atributo;

public abstract class Efecto {
    private double valor;
    public Efecto(double valor){
        this.valor = valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public double getValor() {
        return this.valor;
    }
    public abstract void aplicar(Atributo atributo);
}
