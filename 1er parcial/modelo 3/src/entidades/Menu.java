package entidades;

public abstract class Menu {
    private int codigoMenu;
    private double costoBase;
    private static int ultimoCodigo = 1;

    public Menu() {
        this.codigoMenu = ultimoCodigo++;
        this.costoBase = 10000;
    }

    public int getCodigoMenu() {
        return codigoMenu;
    }

    public void setCodigoMenu(int codigoMenu) {
        this.codigoMenu = codigoMenu;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public abstract double calcularCosto();
}
