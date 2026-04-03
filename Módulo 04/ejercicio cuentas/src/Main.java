import entidades.CajaDeAhorro;

public class Main{
    public static void main(String[] args){
        CajaDeAhorro ca1 = new CajaDeAhorro("Juan", 15);
        ca1.depositar(1000);
        ca1.acreditarInteres();
        System.out.println(ca1);





    }
}