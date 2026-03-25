package entidades;

public class MainPruebas {
    public static void main(String[] args){
        Rueda r1 = new Rueda(15, "Acero", "Negro");
        r1.girar();
        System.out.println(r1);

        Motor m1 = new Motor("FIAT", 130.0, 1747);
        m1.arrancarMotor();
        System.out.println(m1);
        m1.detenerMotor();

        CajaDeVelocidades c1 = new CajaDeVelocidades("Aisin", 6, "C", 1);
        c1.cambiarMarcha();
        System.out.println(c1);
    }
}
