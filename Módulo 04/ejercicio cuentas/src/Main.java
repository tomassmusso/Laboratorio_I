import entidades.CajaAhorro;
import entidades.CtaCorriente;
import entidades.CuentaException;

// puse con sout pq si no imprimia a destiempo los serr

public class Main {
    public static void main(String[] args){
        CajaAhorro c1 = new CajaAhorro("Tomás Musso", 15);
        CtaCorriente c2 = new CtaCorriente("Juan Pérez");

        // deposito 15000 en cada cuenta
        c1.depositar(15000);
        c2.depositar(15000);
        System.out.println("\nPRIMER VISTAZO A LAS CUENTAS");
        System.out.println(c1);
        System.out.println(c2);

        // sumo interes a la caja de ahorro
        System.out.println("\nINTERESES SUMADOS A CAJA DE AHORRO");
        c1.sumarInteres();
        System.out.println(c1);

        // extraigo de la caja de ahorro
        try{    // primer intento, tengo saldo disponible
            c1.extraer(12000);
            System.out.println("\nDINERO EXTRAIDO");
            System.out.println(c1);
        }
        catch (CuentaException err){
            System.out.println("\n");
            System.out.println(err.getMessage());
        }

        try{    // segundo intento, no tengo saldo disponible
            c1.extraer(12000);
            System.out.println("\nDINERO EXTRAIDO");
            System.out.println(c1);
        }
        catch (CuentaException err){
            System.out.println("ERROR EN LA EXTRACIÓN");
            System.out.println(err.getMessage());
        }

        try{
            c2.extraer(16000);
            System.out.println("\nDinero extraido");
        } catch (CuentaException e) {
            System.out.println(e.getMessage());
        }
    }
}