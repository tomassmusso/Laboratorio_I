package service;

import dao.*;
import entidades.*;

import java.util.ArrayList;

public class ServiceAdministrador {
    private DaoAlumno daoAlumno;
    private DaoProfesor daoProfesor;
    private DaoCurso daoCurso;
    private DaoInscripcion daoInscripcion;

    public ServiceAdministrador() {
        daoAlumno = new DaoAlumno();
        daoProfesor = new DaoProfesor();
        daoCurso = new DaoCurso();
        daoInscripcion = new DaoInscripcion();
    }

    public void crearAlumno(Alumno alumno) throws ServiceException {
        try{
            daoAlumno.agregar(alumno);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public void modificarAlumno(Alumno alumno) throws ServiceException {
        try{
            daoAlumno.modificar(alumno);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public void eliminarAlumno(int id) throws ServiceException {
        try{
            daoAlumno.eliminar(id);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public Alumno consultarAlumno(int id) throws ServiceException {
        try{
            return daoAlumno.consultar(id);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public ArrayList<Alumno> consultarTodosAlumnos() throws ServiceException {
        try{
            return daoAlumno.consultarTodos();
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public void crearProfesor(Profesor profesor) throws ServiceException {
        try{
            daoProfesor.agregar(profesor);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public void modificarProfesor(Profesor profesor) throws ServiceException {
        try{
            daoProfesor.modificar(profesor);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public void eliminarProfesor(int id) throws ServiceException {
        try{
            daoProfesor.eliminar(id);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public Profesor consultarProfesor(int id) throws ServiceException {
        try{
            return daoProfesor.consultar(id);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public ArrayList<Profesor> consultarTodosProfesores() throws ServiceException {
        try{
            return daoProfesor.consultarTodos();
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public void crearCurso(Curso curso) throws ServiceException {
        try{
            daoCurso.agregar(curso);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public void modificarCurso(Curso curso) throws ServiceException {
        try{
            daoCurso.modificar(curso);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public void eliminarCurso(int id) throws ServiceException {
        try{
            daoInscripcion.eliminarPorCurso(id);
            daoCurso.eliminar(id);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public Curso consultarCurso(int id) throws ServiceException {
        try{
            return daoCurso.consultar(id);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public ArrayList<Curso> consultarTodosCursos() throws ServiceException {
        try{
            return daoCurso.consultarTodos();
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public void inscribirAlumno(int alumnoId, int cursoId) throws ServiceException {
        try {
            Alumno alumno = daoAlumno.consultar(alumnoId);
            Curso curso = daoCurso.consultar(cursoId);

            if(alumno == null){
                throw new ServiceException("No se encontró el alumno");
            }
            if(curso == null){
                throw new ServiceException("No se encontró el curso");
            }

            ArrayList<Inscripcion> inscripcionesAlumno = daoInscripcion.consultarPorAlumno(alumnoId);
            int activas = 0;
            for(Inscripcion inscripcion:inscripcionesAlumno){
                if(inscripcion.getCurso().getIdCurso() == cursoId){
                    throw new ServiceException("El alumno ya está inscripto en este curso");
                }
                if(!inscripcion.isFinalizada()){
                    activas++;
                }
            }
            if(activas >= alumno.getLimiteCursos()){
                throw new ServiceException("El alumno alcanzó su límite de cursos");
            }

            ArrayList<Inscripcion> inscripcionesCurso = daoInscripcion.consultarPorCurso(cursoId);
            int anotados = 0;
            for(Inscripcion inscripcion:inscripcionesCurso){
                anotados++;
            }
            if(anotados >= curso.getCupo()){
                throw new ServiceException("El curso no tiene cupo disponible");
            }
            Inscripcion inscripcion = new Inscripcion(alumno, curso);
            daoInscripcion.agregar(inscripcion);
            alumno.setDeuda(alumno.getDeuda() + curso.getPrecioActual());
            daoAlumno.modificar(alumno);
            alumno.inscribirseACurso(inscripcion);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }
}