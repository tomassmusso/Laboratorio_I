package entidadaes;

public class CuentaException extends Exception {

    public CuentaException(){
        super();
    }

    public CuentaException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " Error: " + getMessage();
    }
}
