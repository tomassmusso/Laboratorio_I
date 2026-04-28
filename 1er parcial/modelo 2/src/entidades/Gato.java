package entidades;

public class Gato extends Animal{
    private double costoBase;
    private boolean esDelInterior;
    private double porcentajeDescuento;

    public Gato(String nombre, double peso, boolean esDelInterior) {
        super(nombre, peso);
        this.costoBase = 4000;
        this.esDelInterior = esDelInterior;
        this.porcentajeDescuento = 15;
    }

    public Gato(){
        super();
    }

    @Override
    public double costoConsulta() {
        double costo = costoBase;
        if(esDelInterior){
            costo -= (costo * porcentajeDescuento) / 100;
        }
        for(Tratamiento tratamiento:tratamientos){
            costo += tratamiento.getCosto();
        }
        return costo;
    }
}