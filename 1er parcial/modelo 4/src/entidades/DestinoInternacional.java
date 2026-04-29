package entidades;

public class DestinoInternacional extends Destino{
    private double costoPasajePorPersona;
    private double adicionalSeguro;
    private double impuestos;
    private boolean necesitaVisa;
    private static double adicionalVisa = 50000;

    public DestinoInternacional(String pais, String ciudad, double costoPasajePorPersona, double adicionalSeguro, double impuestos, boolean necesitaVisa) {
        super(pais, ciudad);
        this.costoPasajePorPersona = costoPasajePorPersona;
        this.adicionalSeguro = adicionalSeguro;
        this.impuestos = impuestos;
        this.necesitaVisa = necesitaVisa;
    }

    public DestinoInternacional(){
        super();
    }

    @Override
    public double costoDestino() {
        double precio = costoPasajePorPersona + adicionalSeguro + impuestos;
        if(necesitaVisa){
            precio += adicionalVisa;
        }
        return precio;
    }
}
