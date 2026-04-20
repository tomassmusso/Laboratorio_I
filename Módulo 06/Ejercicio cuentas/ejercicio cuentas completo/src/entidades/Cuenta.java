package entidades;

public abstract class Cuenta implements Itransferencia, Comparable<Cuenta>{
    private String titular;
    private int nroCuenta;
    private static int ultNroCuenta = 125;
    protected double saldo;

    public Cuenta(String titular){
        this.titular = titular;
        this.nroCuenta = ultNroCuenta;
        this.saldo = 0;
        ultNroCuenta++;
    }

    public Cuenta(){}

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta nro " + nroCuenta + "\nTitular: " + titular + " - Saldo: $" + saldo;
    }

    public void depositar(double monto){
        this.saldo += monto;
    }

    public abstract void extraer(double monto) throws CuentaException;

    public int compareTo (Cuenta c){
        return this.nroCuenta - c.nroCuenta;
    }
}
