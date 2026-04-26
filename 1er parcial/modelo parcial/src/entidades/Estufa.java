package entidades;

public class Estufa {
    private int cantidadQuemadores;

    public Estufa(int cantidadQuemadores) {
        this.cantidadQuemadores = cantidadQuemadores;
    }

    public Estufa(){}

    public int getCantidadQuemadores() {
        return cantidadQuemadores;
    }

    public void setCantidadQuemadores(int cantidadQuemadores) {
        this.cantidadQuemadores = cantidadQuemadores;
    }

    public int caloriasProvistas(){
        return 300 * cantidadQuemadores;
    }
}
