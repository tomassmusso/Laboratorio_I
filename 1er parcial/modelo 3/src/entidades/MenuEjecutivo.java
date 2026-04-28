package entidades;

public class MenuEjecutivo extends Menu{
    private boolean conCafe;

    public MenuEjecutivo(boolean conCafe) {
        super();
        this.conCafe = conCafe;
    }

    public MenuEjecutivo() {
        super();
    }

    @Override
    public double calcularCosto() {
        double total = getCostoBase();
        if(conCafe){
            total += (getCostoBase() * 5) / 100;
        }
        return total;
    }
}
