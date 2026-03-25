import entidades.Auto;
import entidades.CajaDeVelocidades;
import entidades.Motor;
import entidades.Rueda;

public class Main{
    public static void main(String[] args){
        Motor motor = new Motor("FIAT", 130, 1747);
        CajaDeVelocidades caja = new CajaDeVelocidades("Aisin", 6, "C", 0);

        Rueda[] ruedas = new Rueda[4];
        for (int i = 0; i < ruedas.length; i++) {
            ruedas[i] = new Rueda(15, "Acero", "Negro");
        }

        Auto auto = new Auto("FIAT", "Cronos", 5, "Si", motor, caja, ruedas);

        System.out.println(auto.toString());
    }
}
