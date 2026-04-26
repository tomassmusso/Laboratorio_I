package entidadaes;

public class CtaCorriente extends Cuenta{
    private double descubierto;

    public CtaCorriente(String titular) {
        super(titular);
        this.descubierto = 5000;
    }

    @Override
    public void extraer(double monto) throws CuentaException {
        double saldoDescubierto = this.saldo + descubierto;
        if(saldoDescubierto - monto < 0){
            throw new CuentaException("No hay suficiente saldo disponible, se excede el monto descubierto");
        }
        this.saldo -= monto;
    }

    @Override
    public void transferir(double monto, Cuenta destino) throws CuentaException {
        extraer(monto);
        destino.depositar(monto);
    }
}
