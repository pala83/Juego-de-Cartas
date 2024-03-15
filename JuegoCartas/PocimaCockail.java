package JuegoCartas;

import java.util.ArrayList;
import java.util.List;

public class PocimaCockail extends Pocima {
    private final List<Pocima> cocktail;
    public PocimaCockail(String nombre){
        super(nombre);
        this.cocktail = new ArrayList<>();
    }
    public void agregarPocima(Pocima p){
        cocktail.add(p);
    }
    @Override
    public void aplicar(Carta carta) {
        for(Pocima p: this.cocktail)
            p.aplicar(carta);
    }
}
