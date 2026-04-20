package entidades;

public class EmpleadosExceptions extends Exception{
    public EmpleadosExceptions() {
        super();
    }

    public EmpleadosExceptions(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Ocurrio" + this.getClass().getName() + "Error";
    }
}
