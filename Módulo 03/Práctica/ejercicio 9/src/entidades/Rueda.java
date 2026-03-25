package entidades;

public class Rueda {
    private double radio;
    private String tipoMaterial;
    private String color;

    public Rueda(double radio, String tipoMaterial, String color) {
        this.radio = radio;
        this.tipoMaterial = tipoMaterial;
        this.color = color;
    }

    public Rueda(){}

    @Override
    public String toString() {
        return "Rueda: \nMaterial: " + tipoMaterial + " Radio: " + radio;
    }

    public void girar(){
        System.out.println("La rueda está girando...");
    }
}
