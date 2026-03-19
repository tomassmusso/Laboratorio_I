package entidades;

import java.time.LocalDate;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;


    public Fecha(int dia, int mes, int anio){
        this.mes = mes;
        this.dia = dia;
        this.anio = anio;
    }

    public Fecha(){
        LocalDate fecha;
        fecha = LocalDate.now();
        dia = fecha.getDayOfMonth();
        mes = fecha.getMonthValue();
        anio = fecha.getYear();
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }

    public int diferenciaAnios(Fecha fecha){
        int dif;
        if (this.anio > fecha.anio){
            dif = this.anio - fecha.anio;
        }
        else {
            dif = fecha.anio - this.anio;
        }

        if(this.mes < fecha.mes){
            dif -= 1;
        }

        return dif;
    }
}
