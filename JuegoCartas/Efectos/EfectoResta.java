package JuegoCartas.Efectos;

import JuegoCartas.Atributo;

public class EfectoResta extends Efecto{
    public EfectoResta(double valor){
        super(valor);
    }
    @Override
    public void aplicar(Atributo atributo) {
        atributo.setValor(atributo.getValor()-atributo.getValor()*this.getValor());
    }
   
}
