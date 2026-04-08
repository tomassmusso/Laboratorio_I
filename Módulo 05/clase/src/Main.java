import entidades.Contratado;
import entidades.RelacionDeDependencia;

public class Main{

    public static void main(String[] args){

        RelacionDeDependencia r1 = new RelacionDeDependencia("Juan", "Perez", 45878656, 90000, 15);
        RelacionDeDependencia r2 = new RelacionDeDependencia("Tomás", "Musso", 46878262, 100000, 15);
        Contratado c1 = new Contratado("Tomas", "Musso", 46825695, 10000);

        System.out.println(r1);
        System.out.println(r2);

        if(r1.compareTo(r2) > 0){
            System.out.println("El legajo de " + r1.getNombre() + " es mayor");
        }
        if(r1.compareTo(r2) < 0){
            System.out.println("El legajo de " + r2.getNombre() + " es mayor");
        }
        else{
            System.out.println("los legajos son iguales");  // este caso es redundante en este ejemplo
        }
    }
}
