package entidades;

public class DestinoNacional extends Destino{
    private String tipoViaje;
    private double costoTransportePorPersona;

    public DestinoNacional(String pais, String ciudad, String tipoViaje, double costoTransportePorPersona) {
        super(pais, ciudad);
        this.tipoViaje = tipoViaje;
        this.costoTransportePorPersona = costoTransportePorPersona;
    }

    public DestinoNacional(){
        super();
    }

    @Override
    public double costoDestino() {
        return costoTransportePorPersona;
    }
}
