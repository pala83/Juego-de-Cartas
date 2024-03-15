package JuegoCartas;
import java.util.ArrayList;
import java.util.List;

public class Carta {
    private String personaje;
    private final List<Atributo> atributos;
    private Pocima pocima;

    public Carta(String personaje){
        this.personaje = personaje;
        this.atributos = new ArrayList<Atributo>();
        this.pocima = null;
    }
    public Pocima getPocima() {
        return this.pocima;
    }
    public void setPocima(Pocima pocima){
        this.pocima = pocima;
    }
    public double getValorAributo(String atributo){
        for(Atributo atr: this.atributos)
            if(atr.getNombre().equals(atributo))
                return atr.getValor();
        return -1;
    }
    public List<Atributo> getAtributos() {
        return List.copyOf(this.atributos);
    }
    public void addAtributo(Atributo a){
        this.atributos.add(a);
    }
    public String getPersonaje() {
        return personaje;
    }
    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public Atributo getAtributoNombre(String nombre){
        for(Atributo a : this.atributos)
            if(a.getNombre().equals(nombre))
                return a;
        return null;
    }
    public void aplicarPocima(){
        if(this.pocima!=null)
            this.pocima.aplicar(this);
        this.pocima = null;
    }
    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("\"").append(personaje).append("\": {\n");
        for(Atributo atr: this.atributos)
            retorno.append("\t").append(atr).append(",\n");
        retorno.append("},\n");
        return retorno.toString();
    }
}
