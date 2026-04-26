package entidadaes;

public interface Itransferencia {
    public void transferir(double monto, Cuenta destino) throws CuentaException;
}
