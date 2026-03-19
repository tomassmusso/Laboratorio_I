import entidades.Persona;

public class Main {

    public static void main(String[] args) {
        Persona persona1, persona2, persona3;
        persona1 = new Persona("Tomas", 46878262);
        System.out.println(persona1.toString());
        persona2 = new Persona();   // datos del constructor por defecto
        System.out.println(persona2.toString());
        persona3 = new Persona("Juan", 444444);
        System.out.println(persona3);
    }
}