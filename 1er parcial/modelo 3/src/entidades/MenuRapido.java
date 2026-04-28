package entidades;

public class MenuRapido extends Menu{
    private boolean conBebida;

    public MenuRapido(boolean conBebida) {
        super();
        this.conBebida = conBebida;
    }

    public MenuRapido() {
        super();
    }

    @Override
    public double calcularCosto() {
        double total = getCostoBase();
        if(!conBebida){
            total -= (getCostoBase() * 10) / 100;
        }
        return total;
    }
}
