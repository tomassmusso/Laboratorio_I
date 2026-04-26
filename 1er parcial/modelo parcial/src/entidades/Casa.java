package entidades;

public class Casa extends Vivienda{

    public Casa(int superficie, boolean tieneAislacion, int porcentajeDescuento) {
        super(superficie, tieneAislacion, porcentajeDescuento);
    }

    public Casa(){
        super();
    }

    @Override
    public int caloriasNecesarias() {
        int base = 700 * getSuperficie();
        return (int) (base - ((base * getPorcentajeDescuento()) / 100.0));
    }
}
