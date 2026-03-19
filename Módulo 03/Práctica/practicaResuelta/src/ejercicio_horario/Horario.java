package ejercicio_horario;

public class Horario {
    private int hora;
    private int minuto;
    private int segundo;

    public Horario(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public Horario(){}

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public String toString(){
        return hora + ":" + minuto + ":" + segundo;
    }

    public void sumarMinutos(){
        int minutos = this.minuto + 30;

        int horasExtra = minutos / 60;
        this.minuto = minutos % 60;
        this.hora = (this.hora + horasExtra) % 24;
    }
}
