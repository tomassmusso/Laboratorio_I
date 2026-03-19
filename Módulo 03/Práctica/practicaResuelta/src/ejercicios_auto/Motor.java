package ejercicios_auto;

public class Motor {
    private String marca;
    private int hp;
    private double cilindrada;

    public Motor(String marca, int hp, double cilindrada) {
        this.marca = marca;
        this.hp = hp;
        this.cilindrada = cilindrada;
    }

    public void arrancar() { // [cite: 24]
        System.out.println("Motor " + marca + " arrancado... Brum brum!");
    }

    @Override
    public String toString() {
        return "Motor [Marca: " + marca + ", HP: " + hp + ", Cilindrada: " + cilindrada + "]";
    }

    public Motor() {
        super();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }
}

