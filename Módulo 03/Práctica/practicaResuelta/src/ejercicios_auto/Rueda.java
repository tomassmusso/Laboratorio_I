package ejercicios_auto;

public class Rueda {
    private String color;
    private double radio;
    private String material;

    public Rueda(String color, double radio, String material) {
        this.color = color;
        this.radio = radio;
        this.material = material;
    }

    public Rueda(){}

    public void girar() {
        System.out.println("La rueda está girando...");
    }

    @Override
    public String toString() {
        return "Rueda [Color: " + color + ", Radio: " + radio + ", Material: " + material + "]";
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

}
