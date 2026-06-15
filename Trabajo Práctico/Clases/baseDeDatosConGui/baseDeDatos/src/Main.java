import DAO.DAOAlumno;
import DAO.DAOException;
import entidades.Alumno;
import gui.PanelManager;
import service.ServiceAlumno;
import service.ServiceException;

public class Main {
    public static void main(String[] args) {
        /*DAOAlumno tablaAlumno= new DAOAlumno();
        ServiceAlumno serviceAlumno= new ServiceAlumno();
        Alumno alumno=new Alumno(3,"Ana","Perez");
        try {
            serviceAlumno.guardar(alumno);
        }
        catch(ServiceException d)
        {
            System.out.println(d.getMessage());
        }*/
        PanelManager panel=new PanelManager(1);

    }
}