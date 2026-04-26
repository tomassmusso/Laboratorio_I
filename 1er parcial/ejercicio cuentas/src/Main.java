import entidadaes.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Creación de banco
        Banco miBanco = new Banco("Banco de Palermo");

        // 2. Creación de cuentas
        // Nota: Según tus constructores, pasamos titular, nro, saldo y ultimoNro.
        // El autoincremental en Cuenta.java asignará el ID real empezando en 125.
        CajaAhorro ca = new CajaAhorro("Tomas Musso", 10.5); // 10.5% interés
        CtaCorriente cc = new CtaCorriente("Juan Perez");

        // 3. Agregado de cuentas al grupo (banco)
        miBanco.agregarCuenta(ca);
        miBanco.agregarCuenta(cc);

        System.out.println("Cuentas creadas:");
        System.out.println("CA Nro: " + ca.getNroCuenta() + " - Titular: " + ca.getTitular());
        System.out.println("CC Nro: " + cc.getNroCuenta() + " - Titular: " + cc.getTitular());

        // 4. Try y catch con depositar y extraer
        System.out.println("\n--- Probando Depósitos y Extracciones ---");
        try {
            ca.depositar(2000); // Saldo CA: 2000
            System.out.println("Saldo CA tras depósito: $" + ca.getSaldo());

            System.out.println("Intentando extraer $3000 de CA...");
            ca.extraer(3000); // Esto lanzará excepción
        } catch (CuentaException e) {
            System.out.println("Error esperado en CA: " + e.getMessage());
        }

        try {
            cc.depositar(1000); // Saldo CC: 1000
            System.out.println("Saldo CC tras depósito: $" + cc.getSaldo());

            System.out.println("Extrayendo $5000 de CC (usa descubierto de $5000)...");
            cc.extraer(5000); // Queda en -4000
            System.out.println("Nuevo saldo CC: $" + cc.getSaldo());
        } catch (CuentaException e) {
            System.out.println("Error inesperado en CC: " + e.getMessage());
        }

        // 5. Try y catch con transferir
        System.out.println("\n--- Probando Transferencias ---");
        try {
            System.out.println("Transfiriendo $1000 de CA a CC...");
            ca.transferir(1000, cc); // CA tiene 2000, pasa a 1000. CC tiene -4000, pasa a -3000.
            System.out.println("Saldo CA: $" + ca.getSaldo());
            System.out.println("Saldo CC: $" + cc.getSaldo());

            System.out.println("Intentando transferir $10000 de CC a CA...");
            cc.transferir(10000, ca); // Supera límite (-3000 - 10000 = -13000 < -5000).
        } catch (CuentaException e) {
            System.out.println("Error en transferencia: " + e.getMessage());
        }

        // 6. Métodos de banco
        System.out.println("\n--- Métodos del Banco ---");

        // Sumar intereses antes de los reportes
        ca.sumarIntereses();
        System.out.println("Saldo CA tras aplicar intereses: $" + ca.getSaldo());

        // Consultar saldo por número
        System.out.println("Consulta Saldo Cuenta 125: $" + miBanco.consultarSaldoCuenta(125));

        // Total de dinero en el banco
        System.out.println("Total dinero en Banco: $" + miBanco.totalCuentas());

        // Ordenar cuentas
        System.out.println("Ordenando cuentas por saldo (Ascendente)...");
        miBanco.ordenar();
        System.out.println("Cuentas ordenadas correctamente.");
    }
}