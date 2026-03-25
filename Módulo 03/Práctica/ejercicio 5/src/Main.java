import entidades.CajaAhorro;


public class Main{
    public static void main(String[] args){
        CajaAhorro miCaja = new CajaAhorro(457815, "Tomás Musso", 5000.0);

        System.out.println("ESTADO INICIAL");
        System.out.println(miCaja);
        miCaja.depositar(2500.0);

        System.out.println("ESTADO FINAL");
        System.out.println(miCaja);

    }
}