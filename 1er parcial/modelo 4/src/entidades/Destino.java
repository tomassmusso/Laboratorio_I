package entidades;

public abstract class Destino {
    private int codigoDestino;
    private String pais;
    private String ciudad;
    private static int ultimoCodigoDestino = 199;

    public Destino(String pais, String ciudad) {
        this.codigoDestino = ultimoCodigoDestino++;
        this.pais = pais;
        this.ciudad = ciudad;
    }

    public Destino(){}

    public int getCodigoDestino() {
        return codigoDestino;
    }

    public void setCodigoDestino(int codigoDestino) {
        this.codigoDestino = codigoDestino;
    }

    public abstract double costoDestino();
}
