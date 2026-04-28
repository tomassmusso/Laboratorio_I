package entidades;

public class MenuInfantil extends Menu{
    private int cantidadSorpresas;
    private double valorAdicional;

    public MenuInfantil(int cantidadSorpresas) {
        super();
        this.cantidadSorpresas = cantidadSorpresas;
        this.valorAdicional = 1500;
    }

    public MenuInfantil(){
        super();
    }

    @Override
    public double calcularCosto() {
        return getCostoBase() + (cantidadSorpresas * valorAdicional);
    }
}
