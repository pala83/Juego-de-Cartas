package JuegoCartas.Efectos;

import JuegoCartas.Atributo;

public class EfectoSuma extends Efecto {
    public EfectoSuma(double valor){
        super(valor);
    }
    @Override
    public void aplicar(Atributo atributo) {
        atributo.setValor(atributo.getValor()+atributo.getValor()*this.getValor());
    }
}
