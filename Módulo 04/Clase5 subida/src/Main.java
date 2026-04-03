import entidades.*;

public class Main {
    public static void main(String[] args) {
        Empleado empleado=new Empleado("Juan",3500004);
        EmpleadoEfectivo emp=new EmpleadoEfectivo("Juan",3500004,1000000,15);
        EmpleadoContratado cont=new EmpleadoContratado("Florencia", 39000000,10000);

        try {
            System.out.println(cont.cobrarSueldo());
        }
        catch (EmpleadoException error)
        {
            System.err.println("Ha ocurrido un error:" +error.getMessage());
        }
        Articulo art=new Articulo();
        
        if (!empleado.equals(art))
            System.out.println("No son el mismo, es un articulo");

        if(!empleado.equals(null))
            System.out.println("No son el mismo, esta en null");
        if(empleado.equals(emp))
            System.out.println("Son iguales");
        else
            System.out.println("No son iguales");


       /* int num1,num2;
        int res;
        num1=100;
        num2=0;

        res=num1/num2;

            System.out.println("No se puede dividir por cero");
*/

    }
}