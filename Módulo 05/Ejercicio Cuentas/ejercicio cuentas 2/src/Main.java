import entidades.CajaAhorro;
import entidades.CtaCorriente;
import entidades.CuentaException;


public class Main {
    public static void main(String[] args){
        CajaAhorro c1 = new CajaAhorro("Tomás Musso", 15);
        CtaCorriente c2 = new CtaCorriente("Juan Pérez");
        c1.depositar(13000);
        c2.depositar(13000);

        System.out.println("---PRIMER VISTAZO---");
        System.out.println(c1);
        System.out.println(c2);

        System.out.println("\n---CompareTo---");
        if(c1.compareTo(c2) > 0){
            System.out.println("El saldo o nro de cuenta de " + c1.getTitular() + " es mayor que el de " + c2.getTitular());
        }
        if(c1.compareTo(c2) < 0){
            System.out.println("El saldo o nro de cuenta de " + c2.getTitular() + " es mayor que el de " + c1.getTitular());
        }

        System.out.println("\n---TRANSFERENCIA---");
        try{
            c1.transferir(2000, c2);
            System.out.println("Transferencia exitosa\nDescripcion:\nOrigen: " + c1.getTitular() + " " + c1.getNroCuenta() + "\nDestino: " + c2.getTitular() + " " +  c2.getNroCuenta() + "\nMonto: $" + 2000);
        }
        catch (CuentaException err){
            System.err.println("Ocurrio un error " + err.getMessage());
        }

        System.out.println("\n---SEGUNDO VISTAZO---");
        System.out.println(c1);
        System.out.println(c2);
    }
}