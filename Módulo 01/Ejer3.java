import java.util.Scanner;

public class Ejer3 {

    public static void main(String[] args){
        int a, b, c;
        double r1, r2;
        Scanner lector;
        lector = new Scanner(System.in);
        // a
        System.out.println("Ingresar a: ");
        a = lector.nextInt();
        // b
        System.out.println("Ingresar b: ");
        b = lector.nextInt();
        // c
        System.out.println("Ingresar c: ");
        c = lector.nextInt();
        r1 = raiz1(a, b, c);
        System.out.println("Raiz 1: " + r1);
        r2 = raiz2(a, b, c);
        System.out.println("Raiz 2: " + r2);
    }

    public static double raiz1(int a, int b, int c){
        return (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
    }

    public static double raiz2(int a, int b, int c){
        return (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
    }
}
