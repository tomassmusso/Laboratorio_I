package entidades;

import java.util.ArrayList;

public class Profesor extends Usuario{
    private ArrayList<Curso> cursos;    // cursos que dicta el profesor
    private String departamento;

    // CONSTRUCTORES
    public Profesor(String nombre, String apellido, String mail, String usuario, String contraseña, String departamento) {
        super(nombre, apellido, mail, usuario, contraseña);
        this.departamento = departamento;
        cursos = new ArrayList<>();
    }

    public Profesor(){
        super();
        cursos = new ArrayList<>();
    }

    // GETTERS Y SETTERS
    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    // MÉTODOS
    public void agregarCurso(Curso curso){
        cursos.add(curso);
    }

    public int cantidadCursosDictados(){
        int cantidad = 0;
        for(Curso curso:cursos){
            cantidad++;
        }
        return cantidad;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
