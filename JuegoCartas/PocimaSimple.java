package JuegoCartas;

import JuegoCartas.Efectos.Efecto;

public class PocimaSimple extends Pocima{
    private Efecto efecto;
    public PocimaSimple(String nombre, Efecto efecto){
        super(nombre);
        this.efecto = efecto;
    }
    public Efecto getEfecto() {
        return this.efecto;
    }
    @Override
    public void aplicar(Carta carta) {
        for(Atributo a: carta.getAtributos())
            this.efecto.aplicar(a);
    }
}
