package ejercicios_empleados;
// ejercicios 2 y 4

public class Main {
    public static void main(String[] args){
        // variables
        Empleado e1, e2, e3;
        e1 = new Empleado("Tomas", "Musso");
        e2 = new Empleado("Lucas", "Teje");
        e3 = new Empleado("Nico", "Ocampo");
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println("Nombre: " + e1.getNombre() + " Apellido: " + e1.getApellido() + " Legajo: " + e1.getLegajo());
        System.out.println("Nombre: " + e2.getNombre() + " Apellido: " + e2.getApellido() + " Legajo: " + e2.getLegajo());
        System.out.println("Nombre: " + e3.getNombre() + " Apellido: " + e3.getApellido() + " Legajo: " + e3.getLegajo());
    }
}
