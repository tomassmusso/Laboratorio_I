import entidades.Empleado;
import entidades.EmpleadoContratado;
import entidades.EmpleadoEfectivo;
import entidades.Empresa;

public class Main {
    public static void main(String[] args) {
        Empleado empleado=new EmpleadoEfectivo("Juan",3500004,1000000,15);
        EmpleadoContratado cont=new EmpleadoContratado("Florencia", 39000000,10000);
        Empresa miEmpresa=new Empresa("Tres patitos");
        miEmpresa.contratarEmpleado(empleado);
        miEmpresa.contratarEmpleado(cont);
    }
}