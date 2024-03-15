package JuegoCartas;

import java.util.List;

public class Juego {
    private Jugador j1;
    private Jugador j2;

    public Juego(Jugador j1, Jugador j2){
        this.j1 = j1;
        this.j2 = j2;
    }

    public Jugador getJ1() {
        return this.j1;
    }
    public Jugador getJ2() {
        return this.j2;
    }

    public void repartirCartas(List<Carta> mazo){
        int permutador = 0;
        for(Carta c : mazo){
            if(permutador%2==0)
                this.j1.agregarCarta(c);
            else 
                this.j2.agregarCarta(c);
            permutador++;
        }
    }

    public void jugar(int ciclosMax){
        int ciclos = 0;
        String rojo = "\033[31m", verde = "\033[32m", amarillo = "\033[33m", azul = "\033[34m";
        while(!this.j1.getMazo().isEmpty() && !j2.getMazo().isEmpty() && ciclos <= ciclosMax){
            Carta cj1 = this.j1.sacarCarta();
            Carta cj2 = this.j2.sacarCarta();
            Atributo atrib;
            System.out.println("---------------------- RONDA " + ciclos + " ----------------------");
            if(ciclos%2==0){
                atrib = this.j1.aplicarEstrategia(cj1);
                System.out.println("El jugador " +this.colorear(this.j1.getNombre(), rojo)+ " selecciona competir por el atributo " +this.colorear(atrib.getNombre(),verde));
            }
            else{
                atrib = this.j2.aplicarEstrategia(cj2);
                System.out.println("El jugador " +this.colorear(this.j2.getNombre(), azul)+ " selecciona competir por el atributo " +this.colorear(atrib.getNombre(),verde));
            }
            Atributo atribj1 = cj1.getAtributoNombre(atrib.getNombre());
            System.out.println("La carta de " +this.colorear(this.j1.getNombre(), rojo)+ " es " + this.colorear(cj1.getPersonaje(), amarillo) + " con " + this.colorear(atribj1.getNombre() + " " + atribj1.getValor(), verde));
            Atributo atribj2 = cj2.getAtributoNombre(atrib.getNombre());
            System.out.println("La carta de " +this.colorear(this.j2.getNombre(), azul)+ " es " + this.colorear(cj2.getPersonaje(), amarillo) + " con " + this.colorear(atribj2.getNombre() + " " + atribj2.getValor(), verde));
            if(atribj1.getValor() > atribj2.getValor()){
                System.out.println("Gana la ronda " +this.colorear(this.j1.getNombre(), rojo));
                this.j1.agregarCarta(cj1);
                this.j1.agregarCarta(cj2);
            }
            else{
                if(atribj1.getValor() < atribj2.getValor()){
                    System.out.println("Gana la ronda " + this.colorear(this.j2.getNombre(), azul));
                    this.j2.agregarCarta(cj2);
                    this.j2.agregarCarta(cj1);
                }
                else{
                    System.out.println("¡Ronda empatada! ambos jugadores recuperan su carta");
                    this.j2.agregarCarta(cj2);
                    this.j1.agregarCarta(cj1);
                }
            }
            System.out.println(this.colorear(this.j1.getNombre(), rojo) + " posee ahora " + this.j1.getMazo().size() + " cartas y " +this.colorear(this.j2.getNombre(), azul)+ " posee ahora " + this.j2.getMazo().size() + " cartas.");
            ciclos++;
        }
    }

    protected String colorear(String palabra, String color){
        String retorno = "\033[1m"+color+palabra+"\033[0m";
        return retorno;
    }
}
