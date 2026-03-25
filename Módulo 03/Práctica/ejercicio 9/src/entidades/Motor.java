package entidades;

public class Motor {
    private String marca;
    private double hp;
    private int cilindrada;

    public Motor(String marca, double hp, int cilindrada) {
        this.marca = marca;
        this.hp = hp;
        this.cilindrada = cilindrada;
    }

    public Motor(){}

    public String toString(){
        return "Motor: \nMarca: " + marca + " Cilindrada: " + cilindrada + " HP: " + hp;
    }

    public void arrancarMotor(){
        System.out.println("Arrancando...");
    }

    public void detenerMotor(){
        System.out.println("Deteniendo...");
    }
}
