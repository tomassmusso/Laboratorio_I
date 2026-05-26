package entidades;

public class Administrador extends Usuario{
    private String sector;

    public Administrador(String nombre, String apellido, String mail, String usuario, String contraseña, String sector) {
        super(nombre, apellido, mail, usuario, contraseña);
        this.sector = sector;
    }

    public Administrador(){
        super();
    }

    public String getSector() {
        return sector;
    }
}
