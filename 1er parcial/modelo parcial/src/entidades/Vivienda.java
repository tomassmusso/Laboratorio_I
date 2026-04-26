package entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Vivienda {
    private int superficie;
    private boolean tieneAislacion;
    private int porcentajeDescuento;
    private List<Estufa> estufas;

    public Vivienda(int superficie, boolean tieneAislacion, int porcentajeDescuento) {
        this.superficie = superficie;
        this.tieneAislacion = tieneAislacion;
        if(tieneAislacion){
            this.porcentajeDescuento = porcentajeDescuento;
        }
        estufas = new ArrayList<Estufa>();
    }

    public Vivienda(){
        estufas = new ArrayList<Estufa>();
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public boolean isTieneAislacion() {
        return tieneAislacion;
    }

    public void setTieneAislacion(boolean tieneAislacion) {
        this.tieneAislacion = tieneAislacion;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public abstract int caloriasNecesarias();

    public int caloriasCubiertas(){
        int total = 0;
        for(Estufa estufa:estufas){
            total += estufa.caloriasProvistas();
        }
        return total;
    }

    public void agregarEstufa(Estufa estufa){
        estufas.add(estufa);
    }
}
