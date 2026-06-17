package service;

import dao.*;
import entidades.*;

import java.util.ArrayList;

public class ServiceAlumno {
    private DaoAlumno daoAlumno;
    private DaoInscripcion daoInscripcion;

    public ServiceAlumno(){
        daoAlumno = new DaoAlumno();
        daoInscripcion = new DaoInscripcion();
    }

    public void modificarAlumno(Alumno alumno) throws ServiceException{
        try{
            daoAlumno.modificar(alumno);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public Alumno consultarAlumno(int id) throws ServiceException{
        try{
            return daoAlumno.consultar(id);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public ArrayList<Inscripcion> consultarInscripciones(int alumnoId) throws ServiceException{
        try{
            return daoInscripcion.consultarPorAlumno(alumnoId);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    public Inscripcion consultarInscripcion(int inscripcionId) throws ServiceException{
        try{
            return daoInscripcion.consultar(inscripcionId);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }
}
