package entidades;

public class CajaDeVelocidades {
    private String fabricante;
    private int cantMarchas;
    private String relacion;
    private int marchaActual = 0;

    public CajaDeVelocidades(String fabricante, int cantMarchas, String relacion, int marchaActual) {
        this.fabricante = fabricante;
        this.cantMarchas = cantMarchas;
        this.relacion = relacion;
        this.marchaActual = marchaActual;
    }

    public CajaDeVelocidades(){}

    @Override
    public String toString(){
        return "Caja: \nFabricante: " + fabricante + " Cantidad de Marchas: " + cantMarchas + " Relacion: " + relacion + " Marcha actual: " + marchaActual;
    }

    public void cambiarMarcha(){
        System.out.println("Cambiando marcha...");
        marchaActual++;
    }
}
