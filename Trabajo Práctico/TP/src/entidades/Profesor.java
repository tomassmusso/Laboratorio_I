package entidades;

import java.util.ArrayList;

public class Profesor extends Usuario{
    private ArrayList<Curso> cursos;    // cursos que da el profesor

    public Profesor(String nombre, String apellido, String mail, String usuario, String contraseña) {
        super(nombre, apellido, mail, usuario, contraseña);
        cursos = new ArrayList<>();
    }

    public Profesor(){
        super();
        cursos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return super.toString() + " - Cursos: " + cursos;
    }
}
