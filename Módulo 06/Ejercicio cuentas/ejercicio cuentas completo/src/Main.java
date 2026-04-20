import entidades.*;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco");

        // Creo cuentas
        CajaAhorro ca = new CajaAhorro("Tomas Musso", 10);
        ca.depositar(50000);
        CtaCorriente cc = new CtaCorriente("Juan Perez");
        cc.depositar(10000); 

        // Agrego las cuentas al banco
        banco.agregarCuenta(ca);
        banco.agregarCuenta(cc);

        System.out.println("Saldo total del banco: $" + banco.totalCuentas());

        // Buscamos saldo por nro de cuenta
        double saldoIndividual = banco.consultarSaldoCuenta(125);
        System.out.println("\nSaldo de la cuenta 125: $" + saldoIndividual);

        // Ordenamos las cuentas
        banco.ordenar();

        // Borramos una cuenta
        banco.cerrarCuenta(126);

        // Me fijo si se borro
        System.out.println("Saldo final tras cierre: $" + banco.totalCuentas());
    }
}