package entidades;

public class Cuenta {
    private String titular;
    private int nroCuenta;
    private double saldo;
    private static int ultimoNro = 100;

    public Cuenta(String titular) {
        this.nroCuenta = ultimoNro;
        this.saldo = 0;
        this.titular = titular;
        ultimoNro++;
    }

    public Cuenta() {
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

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "titular='" + titular + '\'' +
                ", nroCuenta=" + nroCuenta +
                ", saldo=" + saldo +
                '}';
    }

    public void depositar(double monto){
        this.saldo += monto;
    }

    public void extraer(double monto){
        return;
    }
}
