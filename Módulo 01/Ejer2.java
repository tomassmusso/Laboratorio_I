import java.util.Scanner;

public class Ejer2 {

    public static void main(String[] args){
        int anio;
        String res;
        Scanner lector;
        lector = new Scanner(System.in);
        System.out.println("Ingresar un año: ");
        anio = lector.nextInt();
        res = esBisiesto(anio);
        System.out.println("El año " + anio + " " + res);
    }

    public static String esBisiesto(int anio){
        String res;
        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)){
            res = "es bisiesto";
        }
        else{
            res = "no es bisiesto";
        }
        return res;
    }
}
