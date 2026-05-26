package entidades;

import java.util.ArrayList;

public class Profesor extends Usuario{
    private ArrayList<Curso> cursos;    // cursos que da el profesor
    private String departamento;

    public Profesor(String nombre, String apellido, String mail, String usuario, String contraseña, String departamento) {
        super(nombre, apellido, mail, usuario, contraseña);
        this.departamento = departamento;
        cursos = new ArrayList<>();
    }

    public Profesor(){
        super();
        cursos = new ArrayList<>();
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void agregarCurso(Curso curso){
        cursos.add(curso);
    }

    @Override
    public String toString() {
        return super.toString() + " - Cursos: " + cursos;
    }
}
