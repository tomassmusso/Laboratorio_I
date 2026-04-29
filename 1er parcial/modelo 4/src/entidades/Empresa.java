package entidades;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private String CUIT;
    private List<Viaje> viajes;
    private List<Destino> destinos;

    public Empresa(String nombre, String CUIT) {
        this.nombre = nombre;
        this.CUIT = CUIT;
        viajes = new ArrayList<>();
        destinos = new ArrayList<>();
    }

    public Empresa(){
        viajes = new ArrayList<>();
        destinos = new ArrayList<>();
    }

    public void agregarDestino(Destino destino){
        destinos.add(destino);
    }

    public void venderViaje(Viaje viaje){
        if(viaje.getCantidadPasajeros() >= 3){
            viaje.setAplicaDescuento(true);
        }
        viajes.add(viaje);
    }

    public double totalRecaudado() {
        double total = 0;
        for (Viaje v : viajes) {
            total += v.costoViaje();
        }
        return total;
    }
}
