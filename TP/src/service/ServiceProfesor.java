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

    public void modificarProfesor(Profesor profesor) throws ServiceException{
        try{
            daoProfesor.modificar(profesor);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public Profesor consultarProfesor(int profesorId) throws ServiceException{
        try{
            return daoProfesor.consultar(profesorId);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public void modificarCurso(Curso curso) throws ServiceException{
        try{
            daoCurso.modificar(curso);
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

    public ArrayList<Curso> consultarCursos(int profesorId) throws ServiceException{
        try{
            return daoCurso.consultarPorProfesor(profesorId);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public ArrayList<Inscripcion> consultarInscripciones(int cursoId) throws ServiceException{
        try{
            return daoInscripcion.consultarPorCurso(cursoId);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
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
            if(inscripcion.cantidadNotasCargadas() >= inscripcion.getCurso().getCantidadParciales()){
                throw new ServiceException("Ya se cargaron todos los parciales");
            }
            inscripcion.agregarNotaParcial(notaParcial);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
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
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }
}
