package entidades;

public class Viaje {
    private int codigoViaje;
    private int cantidadPasajeros;
    private int cantidadDias;
    private boolean aplicaDescuento;
    private static int ultimoCodigoViaje = 49;
    private Destino destino;

    public Viaje(int cantidadPasajeros, int cantidadDias, Destino destino) {
        this.codigoViaje = ultimoCodigoViaje++;
        this.cantidadPasajeros = cantidadPasajeros;
        this.cantidadDias = cantidadDias;
        this.destino = destino;
    }

    public Viaje(){}

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public boolean isAplicaDescuento() {
        return aplicaDescuento;
    }

    public void setAplicaDescuento(boolean aplicaDescuento) {
        this.aplicaDescuento = aplicaDescuento;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public double costoViaje(){
        double total = cantidadPasajeros * destino.costoDestino();
        if(aplicaDescuento){
            total -= (total * 10) / 100;
        }
        return total;
    }


}
