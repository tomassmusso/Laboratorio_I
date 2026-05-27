package entidades;

public class NotaParcial {
    private int id;
    private double nota;

    public NotaParcial(double nota){
        if(nota > 0 && nota < 10){
            this.nota = nota;
        }
    }

    public NotaParcial(){}

    public double getNota() {
        return nota;
    }
}
