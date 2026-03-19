package entidades;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha(){
        dia = 1;
        mes = 1;
        anio = 2000;
    }

    public int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getAnio(){
        return anio;
    }

    public void setDia(int dia){
        this.dia = dia;
    }

    public void setMes(int mes){
        this.mes = mes;
    }

    public void setAnio(int anio){
        this.anio = anio;
    }

    public String toString(){
        return dia + "/" + mes + "/" + anio;
    }

    public Fecha(int dia, int mes, int anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public void sumarDias(int dias) {
        dia += dias;
        mes += dia / 30;
        dia = dia % 30;

    }

    public int diferenciaAnios(Fecha fecha){
        // if (fecha.anio es mayor a this.anio)
        return (fecha.anio - this.anio);
    }
}
