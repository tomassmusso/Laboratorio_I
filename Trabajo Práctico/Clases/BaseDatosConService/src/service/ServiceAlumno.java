package service;

import dao.DaoAlumno;
import dao.DaoException;
import entidades.Alumno;

public class ServiceAlumno {
    private DaoAlumno daoAlumno;

    public ServiceAlumno() {
        daoAlumno=new DaoAlumno();
    }

    public  void insertarAlumno(Alumno elemento) throws ServiceException {
        try {
            daoAlumno.agregar(elemento);
        }
        catch (DaoException e)
        {
            throw  new ServiceException(e.getMessage());
        }
        ServiceInscripcion serviceInscripcion=new ServiceInscripcion();
        for(m:elemento.getMaterias())
        {   Inscripcion ins=new Inscripcion(m.getId(),elemento.getId(),hoy);
            serviceInscripcion.agregar(ins);
        }
    }
}
