package entidades;

public class Departamento extends Vivienda{
    private int cantidadHabitantes;

    public Departamento(int superficie, boolean tieneAislacion, int porcentajeDescuento, int cantidadHabitantes) {
        super(superficie, tieneAislacion, porcentajeDescuento);
        this.cantidadHabitantes = cantidadHabitantes;
    }

    public Departamento() {
        super();
    }

    public int getCantidadHabitantes() {
        return cantidadHabitantes;
    }

    public void setCantidadHabitantes(int cantidadHabitantes) {
        this.cantidadHabitantes = cantidadHabitantes;
    }

    @Override
    public int caloriasNecesarias() {
        int base = (500 * getSuperficie()) + (100 * cantidadHabitantes);
        return (int) (base - ((base * getPorcentajeDescuento()) / 100.0));
    }
}
