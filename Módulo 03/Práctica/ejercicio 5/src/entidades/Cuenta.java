package entidades;

public class Cuenta {
    private int nroCuenta;
    private String titular;
    protected double saldo;

    public Cuenta(){}

    public Cuenta(int nroCuenta, String titular, double saldo) {
        this.nroCuenta = nroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return " Saldo: $" + saldo;
    }
}
