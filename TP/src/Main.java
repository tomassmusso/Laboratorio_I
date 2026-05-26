import dao.DaoAlumno;
import dao.DaoException;
import entidades.Alumno;

public class Main {
  public static void main(String[] args) {

    DaoAlumno daoAlumno = new DaoAlumno();

    // 1. Crear un alumno
    Alumno alumno = new Alumno("Juan", "Perez", "juan@mail.com", "jperez", "1234", 3);

    // 2. Agregarlo a la base
    try {
      daoAlumno.agregar(alumno);
      System.out.println("Alumno agregado correctamente");
    } catch (DaoException e) {
      System.out.println("Error al agregar: " + e.getMessage());
      e.printStackTrace();
    }

    // 3. Consultarlo por ID para verificar que se guardó
    try {
      Alumno encontrado = daoAlumno.consultar(alumno.getId());
      if(encontrado != null){
        System.out.println("Alumno encontrado: " + encontrado);
      } else {
        System.out.println("No se encontró el alumno");
      }
    } catch (DaoException e) {
      System.out.println("Error al consultar: " + e.getMessage());
      e.printStackTrace();
    }
  }
}