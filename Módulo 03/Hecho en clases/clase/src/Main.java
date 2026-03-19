import entidades.Empleado;
import entidades.Fecha;
import entidades.Persona;

public class Main{
    public static void main(String[] args){
        // creacion variables a utilizar
        Persona persona = new Persona("Juan",new Fecha(15, 7, 1985));
        Persona persona1 = new Persona("Tomas", new Fecha(28, 6, 2005));
        Fecha fechaHoy = new Fecha();
        Empleado empleado = new Empleado("Lucas", 46858696, new Fecha(1, 10, 2004));

        // prints de persona y fecha
        int dif = fechaHoy.diferenciaAnios(new Fecha(1, 10, 1985));
        System.out.println("Datos: " + persona + " Edad: " + dif);
        System.out.println(persona1);
        System.out.println("Edad: " + persona1.edad());

        // prints de empleado
        System.out.println(empleado);
    }
}

