package JuegoCartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JuegoConPocimas extends Juego {
    private List<Pocima> pocimas;

    public JuegoConPocimas(Jugador j1, Jugador j2, List<Pocima> pocimas){
        super(j1, j2);
        this.pocimas = pocimas;
    }
    private List<Carta> aplicarPocimas(List<Carta> mazo){
        List<Carta> retorno = new ArrayList<>();
        for(int i=0; i<mazo.size(); i++){
            Pocima p = i<this.pocimas.size() ? this.pocimas.get(i) : null;
            Carta c = mazo.get(i);
            c.setPocima(p);
            retorno.add(c);
        }
        Collections.shuffle(retorno);
        return retorno;
    }

    @Override
    public void repartirCartas(List<Carta> mazo) {
        List<Carta> mazoConPocimas = aplicarPocimas(mazo);
        super.repartirCartas(mazoConPocimas);
    }

    @Override
    public void jugar(int ciclosMax) {
        int ciclos = 0;
        String rojo = "\033[31m", verde = "\033[32m", amarillo = "\033[33m", azul = "\033[34m", violeta = "\033[35m";
        while(!this.getJ1().getMazo().isEmpty() && !getJ2().getMazo().isEmpty() && ciclos <= ciclosMax){
            Carta cj1 = this.getJ1().sacarCarta();
            Carta cj2 = this.getJ2().sacarCarta();
            Atributo atrib;
            System.out.println("---------------------- RONDA " + ciclos + " ----------------------");
            if(ciclos%2==0){
                atrib = this.getJ1().aplicarEstrategia(cj1);
                System.out.println("El jugador " +this.colorear(this.getJ1().getNombre(), rojo)+ " selecciona competir por el atributo " +this.colorear(atrib.getNombre(),verde));
            }
            else{
                atrib = this.getJ2().aplicarEstrategia(cj2);
                System.out.println("El jugador " +this.colorear(this.getJ2().getNombre(), azul)+ " selecciona competir por el atributo " +this.colorear(atrib.getNombre(),verde));
            }
            Atributo atribj1 = cj1.getAtributoNombre(atrib.getNombre());
            System.out.println("La carta de " +this.colorear(this.getJ1().getNombre(), rojo)+ " es " + this.colorear(cj1.getPersonaje(), amarillo) + " con " + this.colorear(atribj1.getNombre() + " " + atribj1.getValor(), verde));
            if(cj1.getPocima()!=null){
                String pocima = cj1.getPocima().getNombre();
                cj1.aplicarPocima();
                atribj1 = cj1.getAtributoNombre(atrib.getNombre());
                System.out.println("|---> Se aplicó la pócima " + colorear(pocima, violeta) + " valor resultante " + this.colorear(String.valueOf(atribj1.getValor()), violeta));
            }
            Atributo atribj2 = cj2.getAtributoNombre(atrib.getNombre());
            System.out.println("La carta de " +this.colorear(this.getJ2().getNombre(), azul)+ " es " + this.colorear(cj2.getPersonaje(), amarillo) + " con " + this.colorear(atribj2.getNombre() + " " + atribj2.getValor(), verde));
            if(cj2.getPocima()!=null){
                String pocima = cj2.getPocima().getNombre();
                cj2.aplicarPocima();
                atribj2 = cj2.getAtributoNombre(atrib.getNombre());
                System.out.println("|---> Se aplicó la pócima " + colorear(pocima, violeta) + " valor resultante " + this.colorear(String.valueOf(atribj2.getValor()), violeta));
            }
            if(atribj1.getValor() > atribj2.getValor()){
                System.out.println("Gana la ronda " +this.colorear(this.getJ1().getNombre(), rojo));
                this.getJ1().agregarCarta(cj1);
                this.getJ1().agregarCarta(cj2);
            }
            else{
                if(atribj1.getValor() < atribj2.getValor()){
                    System.out.println("Gana la ronda " + this.colorear(this.getJ2().getNombre(), azul));
                    this.getJ2().agregarCarta(cj2);
                    this.getJ2().agregarCarta(cj1);
                }
                else{
                    System.out.println("¡Ronda empatada! ambos jugadores recuperan su carta");
                    this.getJ2().agregarCarta(cj2);
                    this.getJ1().agregarCarta(cj1);
                }
            }
            System.out.println(this.colorear(this.getJ1().getNombre(), rojo) + " posee ahora " + this.getJ1().getMazo().size() + " cartas y " +this.colorear(this.getJ2().getNombre(), azul)+ " posee ahora " + this.getJ2().getMazo().size() + " cartas.");
            ciclos++;
        }
    }    
}
