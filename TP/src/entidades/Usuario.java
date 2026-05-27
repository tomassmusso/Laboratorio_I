package entidades;

public abstract class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String mail;
    private String usuario;
    private String contraseña;

    public Usuario(String nombre, String apellido, String mail, String usuario, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Usuario(){}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMail() {
        return mail;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    @Override
    public String toString() {
        return "ID Usuario: " + id + " - Nombre Completo: " + nombre + " " + apellido + " - Correo: " + mail;
    }
}
