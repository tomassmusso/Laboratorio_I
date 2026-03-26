import entidades.Contratado;
import entidades.Empleado;
import entidades.RelacionDeDependencia;

public class Main{

    public static void main(String[] args){
        RelacionDeDependencia r1 = new RelacionDeDependencia("Juan", "Perez", 46878262, 100000, 15);;
        Contratado c1 = new Contratado("Tomas", "Musso", 46825695, 10000);;
        c1.asignarHoras(5);

        Empleado empleados[];
        empleados = new Empleado[2];
        empleados[0] = r1;
        empleados[1] = c1;

        // en estos ifs pregunto si los indexados son del tipo COntratado, si lo son, entonces ahi aplica el cambio
        if(empleados[0] instanceof Contratado){
            Contratado aux1 = (Contratado) empleados[0];
            aux1.asignarHoras(7);
        }

        if(empleados[1] instanceof Contratado){
            Contratado aux1 = (Contratado) empleados[1];
            aux1.asignarHoras(7);
        }

        for(int i = 0; i < empleados.length; i++){
            // System.out.println(empleados[i].cobrarSueldo());
            System.out.println(empleados[i]);
        }

    }
}
