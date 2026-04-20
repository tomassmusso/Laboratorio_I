package entidades;

public class CtaCorriente extends Cuenta{
    private double descubierto;

    public CtaCorriente(String titular) {
        super(titular);
        this.descubierto = 5000;
    }

    public CtaCorriente() {
        super();
    }

    public double getDescubierto() {
        return descubierto;
    }

    public void setDescubierto(double descubierto) {
        this.descubierto = descubierto;
    }

    @Override
    public String toString() {
        return super.toString() + " - Tipo Cuenta: Cta Corriente - Giro Descubierto: $" + descubierto;
    }

    @Override
    public void extraer(double monto) throws CuentaException{
        if(monto > (this.descubierto + saldo)){
            throw new CuentaException("No hay dinero suficiente en cuenta");
        }
        saldo -= monto;
    }

    @Override
    public void transferir(double monto, Cuenta destino) throws CuentaException{
        this.extraer(monto);
        destino.depositar(monto);
    }
}
