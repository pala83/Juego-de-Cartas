package JuegoCartas;

import java.util.ArrayList;
import java.util.List;

public class Mazo {
    private List<Carta> cartas = new ArrayList<>();

    public Mazo(List<Carta> cartas){
        this.cartas = cartas;
    }
    public void agregarCarta(Carta c){
        this.cartas.add(c);
    }
    public Carta sacarCarta(){
        return !this.cartas.isEmpty() ? this.cartas.remove(0) : null;
    }
}
