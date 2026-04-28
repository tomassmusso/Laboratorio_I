package entidades;

public class Perro extends Animal{
    private double costoBase;
    private boolean esRaza;
    private double porcentajeRecargo;

    public Perro(String nombre, double peso, boolean esRaza) {
        super(nombre, peso);
        this.costoBase = 5000;
        this.esRaza = esRaza;
        this.porcentajeRecargo = 20;
    }

    public Perro(){
        super();
    }

    @Override
    public double costoConsulta() {
        double costo = costoBase;
        if(esRaza){
            costo += ((costo * porcentajeRecargo) / 100);
        }
        for(Tratamiento tratamiento:tratamientos){
            costo += tratamiento.getCosto();
        }
        return costo;
    }
}