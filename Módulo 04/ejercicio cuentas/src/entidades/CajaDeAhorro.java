package entidades;

public class CajaDeAhorro extends Cuenta{
    private double interes;

    public CajaDeAhorro(String titular, double interes) {
        super(titular);
        this.interes = interes;
    }

    public CajaDeAhorro() {
        super();
    }

    public void acreditarInteres(){
        double saldoActual = getSaldo();
        saldoActual += (this.getSaldo() * this.interes);
    }
}
