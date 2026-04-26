package entidadaes;

public class CajaAhorro extends Cuenta{
    private double interesMensual;

    public CajaAhorro(String titular, double interesMensual) {
        super(titular);
        this.interesMensual = interesMensual;
    }

    public CajaAhorro(){
        super();
    }

    public void sumarIntereses(){
        this.saldo += ((getSaldo() * interesMensual) / 100);
    }

    @Override
    public void extraer(double monto) throws CuentaException{
        double prueba = this.saldo - monto;
        if(prueba < 0){
            throw new CuentaException("No hay suficiente saldo disponible");
        }
        this.saldo -= monto;
    }

    @Override
    public void transferir(double monto, Cuenta destino) throws CuentaException {
        extraer(monto);
        destino.depositar(monto);
    }

}
