package entidades;

public class Vendedor extends RelacionDeDependencia{
    private double comision;
    private int ventasMes;


    public Vendedor(String nombre, String apellido, int dni, double sueldoBasico, double procentajeDescuento, double comision){
        super(nombre, apellido, dni, sueldoBasico, procentajeDescuento);
        this.comision = comision;
    }

    public Vendedor(){
        super();
    }

    public void asignarVentas(int ventas){
        ventasMes = ventas;
    }

}
