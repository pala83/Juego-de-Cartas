package JuegoCartas.Estrategias;

import java.util.Random;

import JuegoCartas.Atributo;
import JuegoCartas.Carta;

public class Obstinado implements Estrategia{
    private String atributo;
    public Obstinado(Carta c){
        Random r = new Random();
        int i = r.nextInt(c.getAtributos().size());
        this.atributo = c.getAtributos().get(i).getNombre();
    }
    public String getAtributo() {
        return this.atributo;
    }
    @Override
    public Atributo atributoEstrategico(Carta c) {
        return c.getAtributoNombre(this.atributo);
    }
}
