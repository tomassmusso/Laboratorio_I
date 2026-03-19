package ejercicios_auto;

public class Main {
    public static void main(String[] args) {
        // 1. Construimos el Motor [cite: 23, 25]
        Motor miMotor = new Motor("V8", 450, 5.0);

        // 2. Construimos la Caja de Velocidades [cite: 19, 21]
        Caja_de_Velocidades miCaja = new Caja_de_Velocidades("ZF", 6, "Corta");

        // 3. Construimos un arreglo de 4 Ruedas [cite: 16, 17]
        Rueda[] misRuedas = new Rueda[4];
        misRuedas[0] = new Rueda("Negro", 17.0, "Aleación");
        misRuedas[1] = new Rueda("Negro", 17.0, "Aleación");
        misRuedas[2] = new Rueda("Negro", 17.0, "Aleación");
        misRuedas[3] = new Rueda("Negro", 17.0, "Aleación");

        // 4. Armamos el Auto con todas sus partes
        Auto miAuto = new Auto("Ford", "Mustang", 2, miMotor, miCaja, misRuedas);

        // 5. Probamos comportamientos [cite: 17, 20, 24]
        System.out.println("--- Probando sistemas ---");
        miMotor.arrancar();
        miCaja.cambiarMarcha(1);
        misRuedas[0].girar();

        // 6. Imprimimos los valores significativos [cite: 31]
        System.out.println("\n" + miAuto.toString());
    }
}