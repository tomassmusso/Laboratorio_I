package ejercicios_auto;

public class Caja_de_Velocidades {
    private String fabricante;
    private int cantidad_marchas;
    private String relacion; // L, M o C [cite: 19]

    public Caja_de_Velocidades(String fabricante, int cantidad_marchas, String relacion) {
        this.fabricante = fabricante;
        this.cantidad_marchas = cantidad_marchas;
        this.relacion = relacion;
    }

    public void cambiarMarcha(int nuevaMarcha) { // [cite: 20]
        System.out.println("Cambiando a marcha " + nuevaMarcha + " en caja " + fabricante);
    }

    @Override
    public String toString() {
        return "Caja [Fabricante: " + fabricante + ", Marchas: " + cantidad_marchas + ", Relación: " + relacion + "]";
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getCantidad_marchas() {
        return cantidad_marchas;
    }

    public void setCantidad_marchas(int cantidad_marchas) {
        this.cantidad_marchas = cantidad_marchas;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

}
