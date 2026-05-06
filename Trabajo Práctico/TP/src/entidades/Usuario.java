package entidades;

public abstract class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String mail;
    private String usuario;
    private String contraseña;
    private static int ultimoId = 145;

    public Usuario(String nombre, String apellido, String mail, String usuario, String contraseña) {
        this.id = ultimoId++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Usuario(){}

    @Override
    public String toString() {
        return "ID Usuario: " + id + " - Nombre Completo: " + nombre + " " + apellido + " - Correo: " + mail;
    }
}
