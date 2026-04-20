package entidades;

public class CuentaException extends Exception{
    public CuentaException(){
        super();
    }

    public CuentaException(String mensaje){
        super(mensaje);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "Error: " + getMessage();
    }
}
