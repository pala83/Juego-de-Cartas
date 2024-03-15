package JuegoCartas.Estrategias;

import java.util.Random;

import JuegoCartas.Atributo;
import JuegoCartas.Carta;

public class Timbero implements Estrategia{
    @Override
    public Atributo atributoEstrategico(Carta c) {
        Random r = new Random();
        int atributoAleatorio = r.nextInt(c.getAtributos().size());
        return c.getAtributos().get(atributoAleatorio);
    }
}
