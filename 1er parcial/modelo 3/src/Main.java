import entidades.*;

public class Main {
    public static void main(String[] args) {

        // === MENUS ===
        MenuRapido mrConBebida   = new MenuRapido(true);   // $10.000
        MenuRapido mrSinBebida   = new MenuRapido(false);  // $9.000
        MenuInfantil mi2         = new MenuInfantil(2);    // $13.000
        MenuInfantil mi0         = new MenuInfantil(0);    // $10.000
        MenuEjecutivo meConCafe  = new MenuEjecutivo(true); // $10.500
        MenuEjecutivo meSinCafe  = new MenuEjecutivo(false);// $10.000

        System.out.println("=== COSTOS DE MENUS ===");
        System.out.println("MenuRapido con bebida  : $" + mrConBebida.calcularCosto());   // 10000.0
        System.out.println("MenuRapido sin bebida  : $" + mrSinBebida.calcularCosto());   // 9000.0
        System.out.println("MenuInfantil 2 sorpresa: $" + mi2.calcularCosto());           // 13000.0
        System.out.println("MenuInfantil 0 sorpresa: $" + mi0.calcularCosto());           // 10000.0
        System.out.println("MenuEjecutivo con cafe : $" + meConCafe.calcularCosto());     // 10500.0
        System.out.println("MenuEjecutivo sin cafe : $" + meSinCafe.calcularCosto());     // 10000.0

        // === CARRITOS ===
        Carrito carrito1 = new Carrito("Juan Perez");    // codigo 100
        carrito1.agregarProducto(mrConBebida);
        carrito1.agregarProducto(mi2);

        Carrito carrito2 = new Carrito("Maria Lopez");   // codigo 101
        carrito2.agregarProducto(mrSinBebida);
        carrito2.agregarProducto(meConCafe);

        System.out.println("\n=== CARRITOS ===");
        System.out.println("Carrito 1 (Juan Perez) : $" + carrito1.calcularCostoCarrito());  // 23000.0
        System.out.println("Carrito 2 (Maria Lopez): $" + carrito2.calcularCostoCarrito());  // 19500.0

        // === COMIDA RAPIDA ===
        ComidaRapida comaya = new ComidaRapida("ComaYa");
        comaya.nuevoCarrito(carrito1);
        comaya.nuevoCarrito(carrito2);

        System.out.println("\n=== COMIDA RAPIDA ===");
        System.out.println("Costo carrito 100      : $" + comaya.costoCarrito(100));  // 23000.0
        System.out.println("Costo carrito 101      : $" + comaya.costoCarrito(101));  // 19500.0

        // Buscar carrito que no existe
        System.out.println("Costo carrito 999      : $" + comaya.costoCarrito(999));  // 0.0

        System.out.println("Total recaudado        : $" + comaya.totalRecaudado());   // 42500.0
    }
}