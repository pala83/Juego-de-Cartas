package JuegoCartas.Estrategias;

import JuegoCartas.Atributo;
import JuegoCartas.Carta;

public class Ambicioso implements Estrategia{
    public Ambicioso(){}
    @Override
    public Atributo atributoEstrategico(Carta c) {
        Atributo retorno = new Atributo("Este error no deberia ocurrir", -999999);
        for(Atributo a: c.getAtributos())
            if(a.getValor()>=retorno.getValor())
                retorno = a;
        return retorno;
    }
    
}
