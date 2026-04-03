import entidades.Contratado;
import entidades.Empleado;
import entidades.EmpleadosExceptions;
import entidades.RelacionDeDependencia;

public class Main{

    public static void main(String[] args){
        Empleado e1 = new Empleado("Juan", "Perez", 46878262);
        RelacionDeDependencia r1 = new RelacionDeDependencia("Juan", "Perez", 46878262, 100000, 15);;
        Contratado c1 = new Contratado("Tomas", "Musso", 46825695, 10000);;
        try{
            System.out.println(c1.cobrarSueldo());
        }
        catch (EmpleadosExceptions err){
            System.err.println("Ocurrio un error: " + err.getMessage());
        }
        /*
        if(!e1.equals(null)){
            System.out.println("No son el mismo");
        }
        */
        if(e1.equals(r1)){
            System.out.println("Son el mismo");
        }




    }
}
