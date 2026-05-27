import dao.DaoAlumno;
import dao.DaoException;
import entidades.Alumno;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    DaoAlumno daoAlumno = new DaoAlumno();

    // 1. Crear un alumno
    Alumno alumno = new Alumno("Juan", "Perez", "juan@mail.com", "jperez", "1234", 3);
    Alumno alumno1 = new Alumno("Tomas", "Musso", "tomasmusso28@gmail.com", "tmusso", "1245", 5);

    /*
    // 2. Agregarlo a la base
    try {
      daoAlumno.agregar(alumno);
      daoAlumno.agregar(alumno1);
      System.out.println("Alumno agregado correctamente");
    } catch (DaoException e) {
      System.out.println("Error al agregar: " + e.getMessage());
      e.printStackTrace();
    }
    */

    // 3. Consultar todos
    try {
      ArrayList<Alumno> todos = daoAlumno.consultarTodos();
      for(Alumno a : todos){
        System.out.println("Alumno encontrado: " + a);
      }
    } catch (DaoException e) {
      System.out.println("Error: " + e.getMessage());
    }

    // 4. Consultar por ID
    try{
      Alumno encontrado = daoAlumno.consultar(alumno.getId());
      if(encontrado != null){
        System.out.println("Alumno encontrado: " + encontrado);
      }

    }
    catch (DaoException e){
      System.out.println("Error: " + e.getMessage());
    }
  }
}