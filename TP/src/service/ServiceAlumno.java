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

    public void modiicarAlumno(Alumno alumno) throws ServiceException{
        try{
            daoAlumno.modificar(alumno);
        }
        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }
    }

    public Alumno consultarAlumno(int idAlumno) throws ServiceException{
        try{
            daoAlumno.consultar(idAlumno);
        }
        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }
        return null;
    }

    public ArrayList<Inscripcion> consultarInscripciones(int idAlumno) throws ServiceException{
        try{
            daoInscripcion.consultarInscripcion(idAlumno);
        }
        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }
        return null;
    }


}
