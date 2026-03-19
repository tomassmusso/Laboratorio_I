import java.util.Scanner;

public class Ejer4{

    public static void main(String[] args) {
        int a, b, c, acum = 0, prod = 1, res;

        Scanner lector;
        lector = new Scanner(System.in);
        System.out.println("Ingrese el valor de a: ");
        a = lector.nextInt();
        System.out.println("Ingrese el valor de b: ");
        b = lector.nextInt();
        System.out.println("Ingrese el valor de c: ");
        c = lector.nextInt();

        acum = suma(a, b, c);
        System.out.println("La suma de a + b + c es: " + acum);
        prod = productoria(a, b);
        System.out.println("La productoria de a * b es: " + prod);
        res = cuenta(a, b);
        System.out.println("El resultado de la cuenta es: " + res);
    }

    public static int suma(int a, int b, int c){
        return a + b + c;
    }

    public static int productoria(int a, int b){
        return a * b;
    }

    public static int cuenta(int a, int b){
        int res;
        res = productoria(suma(productoria(a, b), productoria(b, 5), 2), suma(a, b, 1));
        return res;
    }
}