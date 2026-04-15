package entidades;

public class EmpleadoException extends Exception{
    public EmpleadoException() {
        super();
    }

    public EmpleadoException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Ocurrio: " + this.getClass().getName() + " Error: " + getMessage();
    }
}
