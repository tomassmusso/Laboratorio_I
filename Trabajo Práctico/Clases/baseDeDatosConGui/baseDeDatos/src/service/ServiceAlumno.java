package service;

import DAO.DAOAlumno;
import DAO.DAOException;
import entidades.Alumno;

import java.util.ArrayList;

public class ServiceAlumno {
     private DAOAlumno daoAlumno;

    public ServiceAlumno() {
        this.daoAlumno = new DAOAlumno();
    }

    public void guardar(Alumno alumno) throws ServiceException
    {
        try {
            daoAlumno.guardar(alumno);
        }
        catch (DAOException d)
        {
            throw new ServiceException(d.getMessage());
        }
    }
    public void modificar(Alumno alumno) throws ServiceException
    {
        daoAlumno.modificar(alumno);
    }
    public void eliminar(int id) throws  ServiceException
    {
        daoAlumno.eliminar(id);
    }
   /* public Alumno buscar(int id) throws ServiceException
    {
        return daoAlumno.buscar(id);
    }*/
    public ArrayList<Alumno> buscarTodos() throws DAOException
    {
        return daoAlumno.buscarTodos();
    }
}
