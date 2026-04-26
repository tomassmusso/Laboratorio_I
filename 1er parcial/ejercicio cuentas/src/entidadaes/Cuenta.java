package entidadaes;

public abstract class Cuenta implements Itransferencia, Comparable<Cuenta>{
    private String titular;
    private int nroCuenta;
    protected double saldo;
    private static int ultimoNroCuenta = 125;

    public Cuenta(String titular) {
        this.titular = titular;
        this.nroCuenta = ultimoNroCuenta++;
        this.saldo = 0;
    }

    public Cuenta() {}

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto){
        this.saldo += monto;
    }

    public abstract void extraer(double monto) throws CuentaException;

    public abstract void transferir(double monto, Cuenta destino) throws CuentaException;

    public int compareTo(Cuenta cuenta){
        if(this.saldo > cuenta.saldo){
            return 1;
        }
        if(this.saldo < cuenta.saldo){
            return -1;
        }
        else{
            if(this.nroCuenta > cuenta.nroCuenta){
                return 1;
            }
            if(this.nroCuenta < cuenta.nroCuenta){
                return -1;
            }
        }
        return 0;
    }

}
