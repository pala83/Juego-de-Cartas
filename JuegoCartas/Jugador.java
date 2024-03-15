package JuegoCartas;

import java.util.ArrayList;
import java.util.List;

import JuegoCartas.Estrategias.Estrategia;

public class Jugador {
    private String nombre;
    private List<Carta> mazo;
    private Estrategia estrategia;

    public Jugador(String nombre, Estrategia estrategia){
        this.nombre = nombre;
        this.mazo = new ArrayList<>();
        this.estrategia = estrategia;
    }

    public String getNombre() {
        return this.nombre;
    }
    public List<Carta> getMazo() {
        return List.copyOf(this.mazo);
    }
    public Estrategia getEstrategia() {
        return this.estrategia;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setMazo(List<Carta> mazo) {
        this.mazo = mazo;
    }
    public void agregarCarta(Carta c){
        this.mazo.add(c);
    }
    public Carta sacarCarta(){
        return !this.mazo.isEmpty() ? this.mazo.remove(0) : null;
    }
    public Atributo aplicarEstrategia(Carta c){
        return this.estrategia.atributoEstrategico(c);
    }

}
