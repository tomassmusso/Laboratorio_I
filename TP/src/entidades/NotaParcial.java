package entidades;

public class NotaParcial {
    private int id;
    private int inscripcionId;
    private double nota;

    public NotaParcial(int inscripcionId, double nota){
        this.inscripcionId = inscripcionId;
        if(nota >= 0 && nota <= 10){
            this.nota = nota;
        }
    }

    public NotaParcial(){}

    public int getInscripcionId() {
        return inscripcionId;
    }

    public void setInscripcionId(int inscripcionId) {
        this.inscripcionId = inscripcionId;
    }

    public double getNota() {
        return nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
