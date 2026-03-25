package entidades;

public class CajaAhorro extends Cuenta{

    public CajaAhorro(int nroCuenta, String titular, double saldo) {
        super(nroCuenta, titular, saldo);
    }

    public void depositar(double monto){
        if (monto > 0) {
            this.saldo += monto;
        }
    }
}
