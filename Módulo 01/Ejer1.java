import java.util.Scanner;

public class Ejer1 {

    public static void main(String[] args){
        // declaro variables
        double valorF, valorC, res;
        int op;

        // creo el input
        Scanner lector;
        lector = new Scanner(System.in);
        do{
            menu();
            System.out.println("Elegir opcion: ");
            op = lector.nextInt();

            switch (op){
                case 1:
                    System.out.println("Grados en F°: ");
                    valorF = lector.nextDouble();
                    res = farACel(valorF);
                    System.out.println("Grados en C°: " + res);
                    break;
                case 2:
                    System.out.println("Grados en C°: ");
                    valorC = lector.nextDouble();
                    res = CelAFar(valorC);
                    System.out.println("Grados en F°: " + res);
                    break;
                case 3:
                    System.out.println("Hasta luego!!");
                    break;
            }
        }while (op != 3);
    }

    public static void menu(){
        System.out.println("1. Pasar F a C");
        System.out.println("2. Pasar C a F");
        System.out.println("3. Salir");
    }

    public static double farACel(double valorF){
        double res;
        res = ((valorF - 32) / 9) * 5;
        return res;
    }

    public static double CelAFar(double valorC){
        double res;
        res = ((valorC / 5) * 9) + 32;
        return res;
    }
}