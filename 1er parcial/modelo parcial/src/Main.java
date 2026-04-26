import entidades.*;

public class Main {
    public static void main(String[] args) {

        // =============================================
        // 1. CREACION DE ESTUFAS
        // =============================================
        System.out.println("=== ESTUFAS ===");
        Estufa estufa1 = new Estufa(4); // 4 quemadores = 1200 cal
        Estufa estufa2 = new Estufa(2); // 2 quemadores = 600 cal
        Estufa estufa3 = new Estufa(3); // 3 quemadores = 900 cal
        System.out.println("Estufa 1 (4 quemadores): " + estufa1.caloriasProvistas() + " cal");
        System.out.println("Estufa 2 (2 quemadores): " + estufa2.caloriasProvistas() + " cal");
        System.out.println("Estufa 3 (3 quemadores): " + estufa3.caloriasProvistas() + " cal");

        // =============================================
        // 2. CREACION DE VIVIENDAS
        // =============================================
        System.out.println("\n=== VIVIENDAS ===");

        // Casa: 50 m², con aislacion, 10% descuento
        // Calorías necesarias: 700 * 50 = 35000 - 10% = 31500
        Casa casa1 = new Casa(50, true, 10);
        casa1.agregarEstufa(estufa1); // +1200 cal cubiertas
        casa1.agregarEstufa(estufa2); // +600 cal cubiertas
        System.out.println("Casa 1:");
        System.out.println("  Calorias necesarias: " + casa1.caloriasNecesarias());
        System.out.println("  Calorias cubiertas : " + casa1.caloriasCubiertas());
        System.out.println("  Deficit            : " + (casa1.caloriasNecesarias() - casa1.caloriasCubiertas()));

        // Casa sin aislacion: 700 * 30 = 21000, sin descuento
        Casa casa2 = new Casa(30, false, 0);
        System.out.println("\nCasa 2 (sin aislacion, sin estufas):");
        System.out.println("  Calorias necesarias: " + casa2.caloriasNecesarias());
        System.out.println("  Calorias cubiertas : " + casa2.caloriasCubiertas());

        // Departamento: 40 m², 3 habitantes, 20% descuento
        // Calorías necesarias: (500*40 + 100*3) = 20300 - 20% = 16240
        Departamento depto1 = new Departamento(40, true, 20, 3);
        depto1.agregarEstufa(estufa3); // +900 cal cubiertas
        System.out.println("\nDepartamento 1:");
        System.out.println("  Calorias necesarias: " + depto1.caloriasNecesarias());
        System.out.println("  Calorias cubiertas : " + depto1.caloriasCubiertas());
        System.out.println("  Deficit            : " + (depto1.caloriasNecesarias() - depto1.caloriasCubiertas()));

        // =============================================
        // 3. CREACION DE CLIENTES
        // =============================================
        System.out.println("\n=== CLIENTES ===");

        Cliente cliente1 = new Cliente("Juan", "Perez", "1122334455");
        cliente1.setVivienda(casa1);

        Cliente cliente2 = new Cliente("Maria", "Lopez", "1199887766");
        cliente2.setVivienda(depto1);

        // Cliente sin vivienda asignada (caso borde)
        Cliente cliente3 = new Cliente("Carlos", "Gomez", "1155443322");

        System.out.println("Cliente 1: " + cliente1.getNombre() + " " + cliente1.getApellido());
        System.out.println("Cliente 2: " + cliente2.getNombre() + " " + cliente2.getApellido());
        System.out.println("Cliente 3: " + cliente3.getNombre() + " (sin vivienda asignada)");

        // =============================================
        // 4. COMERCIO
        // =============================================
        System.out.println("\n=== COMERCIO ===");

        Comercio comercio = new Comercio("ElectroHogar");
        comercio.agregarCliente(cliente1);
        comercio.agregarCliente(cliente2);
        comercio.agregarCliente(cliente3);

        // =============================================
        // 5. BUSCAR CLIENTE POR TELEFONO
        // =============================================
        System.out.println("\n--- Buscar cliente ---");

        Cliente encontrado = comercio.buscar("1122334455");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getNombre() + " " + encontrado.getApellido());
        } else {
            System.out.println("Cliente no encontrado.");
        }

        // Buscar uno que no existe
        Cliente noExiste = comercio.buscar("0000000000");
        if (noExiste != null) {
            System.out.println("Encontrado: " + noExiste.getNombre());
        } else {
            System.out.println("Telefono 0000000000: cliente no encontrado (correcto).");
        }

        // =============================================
        // 6. CONSULTAR NECESIDADES DE UN CLIENTE
        // =============================================
        System.out.println("\n--- Consultar necesidades de un cliente ---");
        comercio.consultarCliente("1122334455");
        comercio.consultarCliente("1199887766");

        // =============================================
        // 7. CALORIAS TOTALES DE TODOS LOS CLIENTES
        // =============================================
        System.out.println("\n--- Calorias totales necesarias del comercio ---");
        System.out.println("Total: " + comercio.caloriasTotalesNecesarias() + " cal");
        // cliente3 no tiene vivienda, debe ignorarse sin explotar
    }
}