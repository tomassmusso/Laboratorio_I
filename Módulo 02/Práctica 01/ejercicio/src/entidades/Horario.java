package entidades;

public class Horario {
    private int horas;
    private int minutos;
    private int segundos;

    public Horario(){
        // por defecto
    }

    public int getHoras(){
        return this.horas;
    }

    public int getMinutos(){
        return this.minutos;
    }

    public int getSegundos(){
        return this.segundos;
    }

    public void setHoras(int horas){
        this.horas = horas;
    }

    public void setMinutos(int minutos){
        this.minutos = minutos;
    }

    public void setSegundos(int segundos){
        this.segundos = segundos;
    }

    public String toString(){
        return this.horas + ":" + this.minutos + ":" + this.segundos;
    }

    public Horario(int horas, int minutos, int segundos){
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int sumarMinutos(Horario horario){
        return this.minutos + horario.minutos;
    }

    public int intevaloTiempoEnMinutos(Horario horario){
        int horaActual, horaParametro, res;
        horaActual = (this.horas * 60) + this.minutos;
        horaParametro = (horario.horas * 60) + horario.minutos;

        if (horaParametro < horaActual){
            res = horaActual - horaParametro;
        }
        else {
            res = horaParametro - horaActual;
        }
        return res;
    }

    public int cuantoFalta(Horario h) {
        int actualTotal = (this.horas * 60) + this.minutos;
        int destinoTotal = (h.getHoras() * 60) + h.getMinutos();

        int diferencia = destinoTotal - actualTotal;

        if (diferencia < 0) {
            // Sumamos los minutos de un día completo (24 * 60 = 1440)
            diferencia += 1440;
        }

        return diferencia;
    }
}
