package JuegoCartas.Efectos;

import JuegoCartas.Atributo;

public class EfectoIgual extends Efecto{
    public EfectoIgual(double valor){
        super(valor);
    }
    @Override
    public void aplicar(Atributo atributo) {
        atributo.setValor(this.getValor());
    }
}
