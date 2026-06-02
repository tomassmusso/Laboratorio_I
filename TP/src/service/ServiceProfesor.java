package service;

import dao.*;
import entidades.Curso;
import entidades.Inscripcion;
import entidades.NotaParcial;
import entidades.Profesor;

import java.util.ArrayList;

public class ServiceProfesor {
    DaoProfesor daoProfesor;
    DaoCurso daoCurso;
    DaoInscripcion daoInscripcion;
    DaoNotaParcial daoNotaParcial;

    public ServiceProfesor() {
        daoProfesor = new DaoProfesor();
        daoNotaParcial = new DaoNotaParcial();
        daoInscripcion = new DaoInscripcion();
        daoCurso = new DaoCurso();
    }

    public void ModificarProfesor(Profesor profesor) throws ServiceException{
        try{
            daoProfesor.modificar(profesor);
        }
        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }
    }

    public Profesor consultarProfesor(int profesorId) throws ServiceException{
        try{
            return daoProfesor.consultar(profesorId);
        }
        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }
    }

    public void modificarCurso(Curso curso) throws ServiceException{
        try{
            daoCurso.modificar(curso);
        }
        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }
    }

    public ArrayList<Curso> consultarCursos(int profesorId) throws ServiceException{
        try{
            return daoCurso.consultarPorProfesor(profesorId);
        }
        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }
    }

    public ArrayList<Inscripcion> consultarAlumnos(int cursoId) throws ServiceException{
        try{
            return daoInscripcion.consultarPorCurso(cursoId);
        }
        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }
    }

    public void agregarNotaParcial(int inscripcionId, double nota) throws ServiceException{
        try{
            Inscripcion inscripcion = daoInscripcion.consultar(inscripcionId);
            if(inscripcion == null){
                throw new ServiceException("No se encontró la inscripción");
            }
            NotaParcial notaParcial = new NotaParcial(inscripcionId, nota);
            daoNotaParcial.agregar(notaParcial);
            inscripcion.agregarNotaParcial(notaParcial);
        }
        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }
    }

    public void agregarNotaFinal(int inscripcionId, double nota) throws ServiceException{
        try{
            Inscripcion inscripcion = daoInscripcion.consultar(inscripcionId);
            if(inscripcion == null){
                throw new ServiceException("No se encontró la inscripción");
            }
            inscripcion.setNotaFinal(nota);
            if(inscripcion.getNotaFinal() == null){
                throw new ServiceException("No se pudo cargar la nota final");
            }
            daoInscripcion.modificar(inscripcion);
        }
        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }
    }
}
