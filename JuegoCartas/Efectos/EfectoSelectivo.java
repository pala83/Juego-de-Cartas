package JuegoCartas.Efectos;

import JuegoCartas.Atributo;

public class EfectoSelectivo extends EfectoSuma {
    private String atributo;
    public EfectoSelectivo(double valor, String atributo){
        super(valor);
        this.atributo = atributo;
    }
    public String getAtributo() {
        return this.atributo;
    }
    @Override
    public void aplicar(Atributo atributo) {
        if(atributo.getNombre().equals(this.atributo))
            super.aplicar(atributo);
    }
}
