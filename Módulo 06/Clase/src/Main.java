import entidades.*;

public class Main {
    public static void main(String[] args) {
        // 1. Creamos la empresa
        Empresa miEmpresa = new Empresa("SoftData S.A.");

        // 2. Creamos algunos empleados
        // Efectivo: nombre, dni, sueldoBasico, porcentajeDescuento
        Empleado e1 = new RelacionDeDependencia("Juan", "Perez", 30123456, 500000, 15);

        // Contratados: nombre, dni, valorHora
        Contratado e2 = new Contratado("Florencia", "Gomez", 35123456, 10000);
        e2.asignarHoras(40); // Le cargamos horas para que no tire excepción

        Contratado e3 = new Contratado("Tomas", "Musso", 40123456, 12000);
        e3.asignarHoras(0); // Este va a tirar error al cobrar (0 horas)

        // 3. Los contratamos (los metemos a la List)
        miEmpresa.contratarEmpleado(e2);
        miEmpresa.contratarEmpleado(e3);
        miEmpresa.contratarEmpleado(e1);

        System.out.println("--- LISTA ORIGINAL ---");
        System.out.println(miEmpresa.imprimirRecibos());

        // 4. Probamos el ORDENAR (por legajo, según tu compareTo)
        // Como el legajo es estático, se asignan 100, 101, 102...
        miEmpresa.ordenar();
        System.out.println("\n--- LISTA ORDENADA POR LEGAJO ---");
        System.out.println(miEmpresa.imprimirRecibos());

        // 5. Verificamos el TOTAL de liquidaciones
        double total = miEmpresa.importeTotalLiquidaciones();
        System.out.println("\nTotal a pagar en sueldos: $" + total);

        // 6. Probamos el DESPEDIR (por legajo usando el Iterator)
        System.out.println("\n--- DESPIDIENDO AL LEGAJO 100 ---");
        miEmpresa.despedirEmpleado(100);

        // 7. Verificamos el TOTAL de liquidaciones
        // Ojo: acá el empleado con 0 horas va a sumar 0 pero no va a romper el programa
        double total2 = miEmpresa.importeTotalLiquidaciones();
        System.out.println("\nTotal a pagar en sueldos: $" + total2);

        // 8. Impresión final de recibos
        System.out.println("\n--- RECIBOS FINALES ---");
        System.out.println(miEmpresa.imprimirRecibos());
    }
}