package entidades;

public class CajaAhorro extends Cuenta{
    private double interesMensual;

    public CajaAhorro(String titular, double interesMensual) {
        super(titular);
        this.interesMensual = interesMensual;
    }

    public CajaAhorro() {
        super();
    }

    public double getInteresMensual() {
        return interesMensual;
    }

    public void setInteresMensual(double interesMensual) {
        this.interesMensual = interesMensual;
    }

    @Override
    public String toString() {
        return super.toString() + " - Tipo Cuenta: Caja de Ahorro - Interés Mensual: " + interesMensual + "%";
    }

    public void sumarInteres(){
        double sumado = saldo * (this.interesMensual / 100);
        saldo += sumado;
    }

    @Override
    public void extraer(double monto) throws CuentaException{
        if((saldo - monto) < 0){
            throw new CuentaException("No hay dinero suficiente en cuenta");
        }
        saldo -= monto;
    }
}
