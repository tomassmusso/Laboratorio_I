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

    public void pagarDeuda(int alumnoId, double monto) throws ServiceException {
        try{
            Alumno alumno = daoAlumno.consultar(alumnoId);

            if(alumno == null){
                throw new ServiceException("No se encontró el alumno");
            }
            if(monto <= 0){
                throw new ServiceException("El monto debe ser mayor a 0");
            }
            if(monto > alumno.getDeuda()){
                throw new ServiceException("El monto supera la deuda");
            }
            alumno.pagarDeuda(monto);
            daoAlumno.modificar(alumno);
        }
        catch(DaoException ex){
            throw new ServiceException(ex.getMessage());
        }
    }
}
