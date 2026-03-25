package entidades;

public class Auto {
    private Rueda[] ruedas;
    private Motor motor;
    private CajaDeVelocidades caja;
    private String marca;
    private String modelo;
    private int cantidadPuertas;
    private String aire;

    public Auto(String marca, String modelo, int cantidadPuertas, String aire, Motor motor, CajaDeVelocidades caja, Rueda[] ruedas) {
        this.marca = marca;
        this.modelo = modelo;
        this.cantidadPuertas = cantidadPuertas;
        this.aire = aire;
        this.motor = motor;
        this.caja = caja;
        this.ruedas = ruedas;
    }

    public Auto(){}

    @Override
    public String toString() {
        return "Auto: \nMarca: " + marca + " Modelo: " + modelo +
                " Puertas: " + cantidadPuertas + " Aire: " + aire + "\n" +
                motor.toString() + "\n" + caja.toString();
    }
}
