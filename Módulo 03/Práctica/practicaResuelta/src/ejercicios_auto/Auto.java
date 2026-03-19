package ejercicios_auto;

public class Auto {
    // Atributos básicos [cite: 27, 29]
    private String marca;
    private String modelo;
    private int cantidad_puertas;

    private Motor motor;
    private Caja_de_Velocidades caja;
    private Rueda[] ruedas; // Arreglo tradicional de Ruedas

    // Constructor que recibe las partes ya creadas
    public Auto(String marca, String modelo, int puertas, Motor motor, Caja_de_Velocidades caja, Rueda[] ruedas) {
        this.marca = marca;
        this.modelo = modelo;
        this.cantidad_puertas = puertas;
        this.motor = motor;
        this.caja = caja;
        this.ruedas = ruedas;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getCantidad_puertas() { return cantidad_puertas; }
    public void setCantidad_puertas(int cantidad_puertas) { this.cantidad_puertas = cantidad_puertas; }

    @Override
    public String toString() {
        return "=== DATOS DEL AUTO ===\n" +
                "Marca: " + marca + " | Modelo: " + modelo + " | Puertas: " + cantidad_puertas + "\n" +
                "--- Componentes ---\n" +
                motor.toString() + "\n" +
                caja.toString() + "\n" +
                "Ruedas: " + ruedas.length + " instaladas.";
    }
}