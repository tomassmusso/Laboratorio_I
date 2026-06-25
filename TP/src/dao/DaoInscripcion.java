package dao;

import entidades.*;

import java.sql.*;
import java.util.ArrayList;

public class DaoInscripcion implements Idao<Inscripcion>{
    private String DB_JDBC_DRIVER = "org.h2.Driver";
    private String DB_URL = "jdbc:h2:~/test";
    private String DB_USER = "sa";
    private String DB_PASSWORD = "";

    @Override
    public void agregar(Inscripcion elemento) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("INSERT INTO Inscripcion(alumnoId, cursoId) VALUES(?,?)");
            preparedStatement.setInt(1, elemento.getAlumnoId());
            preparedStatement.setInt(2, elemento.getCursoId());
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error al agregar inscripcion " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("DELETE FROM Inscripcion WHERE id = ?");
            preparedStatement.setInt(1, id);
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error al eliminar inscripcion " + e.getMessage());
        }
    }

    @Override
    public void modificar(Inscripcion elemento) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE Inscripcion SET notaFinal=?, finalizada=? WHERE id=?");
            preparedStatement.setDouble(1, elemento.getNotaFinal());
            preparedStatement.setBoolean(2, elemento.isFinalizada());
            preparedStatement.setInt(3, elemento.getInscripcionId());
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error al agregar nota final " + e.getMessage());
        }
    }

    @Override
    public Inscripcion consultar(int id) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Inscripcion inscripcion = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Inscripcion WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int alumnoId = rs.getInt("alumnoId");
                int cursoId = rs.getInt("cursoId");
                DaoAlumno daoAlumno = new DaoAlumno();
                DaoCurso daoCurso = new DaoCurso();
                Alumno alumno = daoAlumno.consultar(alumnoId);
                Curso curso = daoCurso.consultar(cursoId);

                inscripcion = new Inscripcion(alumno, curso);
                inscripcion.setInscripcionId(rs.getInt("id"));

                double notaFinal = rs.getDouble("notaFinal");
                if(!rs.wasNull()){
                    inscripcion.setNotaFinal(notaFinal);
                }
                inscripcion.setFinalizada(rs.getBoolean("finalizada"));

                DaoNotaParcial daoNotaParcial = new DaoNotaParcial();
                ArrayList<NotaParcial> notas = daoNotaParcial.consultarPorInscripcion(inscripcion.getInscripcionId());
                for(NotaParcial nota : notas){
                    inscripcion.agregarNotaParcial(nota);
                }
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al consultar inscripcion " + e.getMessage());
        }
        return inscripcion;
    }

    @Override
    public ArrayList<Inscripcion> consultarTodos() throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Inscripcion");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int alumnoId = rs.getInt("alumnoId");
                int cursoId = rs.getInt("cursoId");

                DaoAlumno daoAlumno = new DaoAlumno();
                DaoCurso daoCurso = new DaoCurso();
                Alumno alumno = daoAlumno.consultar(alumnoId);
                Curso curso = daoCurso.consultar(cursoId);

                Inscripcion inscripcion = new Inscripcion(alumno, curso);
                inscripcion.setInscripcionId(rs.getInt("id"));

                double notaFinal = rs.getDouble("notaFinal");
                if(!rs.wasNull()){
                    inscripcion.setNotaFinal(notaFinal);
                }
                inscripcion.setFinalizada(rs.getBoolean("finalizada"));

                DaoNotaParcial daoNotaParcial = new DaoNotaParcial();
                ArrayList<NotaParcial> notas = daoNotaParcial.consultarPorInscripcion(inscripcion.getInscripcionId());
                for(NotaParcial nota : notas){
                    inscripcion.agregarNotaParcial(nota);
                }

                inscripciones.add(inscripcion);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al consultar inscripciones: " + e.getMessage());
        }
        return inscripciones;
    }

    public ArrayList<Inscripcion> consultarPorAlumno(int alumnoId) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Inscripcion WHERE alumnoId = ?");
            preparedStatement.setInt(1, alumnoId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int cursoId = rs.getInt("cursoId");
                DaoAlumno daoAlumno = new DaoAlumno();
                DaoCurso daoCurso = new DaoCurso();
                Alumno alumno = daoAlumno.consultar(alumnoId);
                Curso curso = daoCurso.consultar(cursoId);
                Inscripcion inscripcion = new Inscripcion(alumno, curso);
                inscripcion.setInscripcionId(rs.getInt("id"));
                double notaFinal = rs.getDouble("notaFinal");
                if(!rs.wasNull()){
                    inscripcion.setNotaFinal(notaFinal);
                }
                inscripcion.setFinalizada(rs.getBoolean("finalizada"));

                DaoNotaParcial daoNotaParcial = new DaoNotaParcial();
                ArrayList<NotaParcial> notas = daoNotaParcial.consultarPorInscripcion(inscripcion.getInscripcionId());
                for(NotaParcial nota:notas){
                    inscripcion.agregarNotaParcial(nota);
                }
                inscripciones.add(inscripcion);
            }
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error al consultar inscripción por alumno: " + e.getMessage());
        }
        return inscripciones;
    }

    public ArrayList<Inscripcion> consultarPorCurso(int cursoId) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Inscripcion WHERE cursoId = ?");
            preparedStatement.setInt(1, cursoId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int alumnoId = rs.getInt("alumnoId");
                DaoAlumno daoAlumno = new DaoAlumno();
                DaoCurso daoCurso = new DaoCurso();
                Alumno alumno = daoAlumno.consultar(alumnoId);
                Curso curso = daoCurso.consultar(cursoId);
                Inscripcion inscripcion = new Inscripcion(alumno, curso);
                inscripcion.setInscripcionId(rs.getInt("id"));
                double notaFinal = rs.getDouble("notaFinal");
                if(!rs.wasNull()){
                    inscripcion.setNotaFinal(notaFinal);
                }
                inscripcion.setFinalizada(rs.getBoolean("finalizada"));

                DaoNotaParcial daoNotaParcial = new DaoNotaParcial();
                ArrayList<NotaParcial> notas = daoNotaParcial.consultarPorInscripcion(inscripcion.getInscripcionId());
                for(NotaParcial nota:notas){
                    inscripcion.agregarNotaParcial(nota);
                }
                inscripciones.add(inscripcion);
            }
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error al consultar inscripción por alumno: " + e.getMessage());
        }
        return inscripciones;
    }

    public void eliminarPorCurso(int cursoId) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM Inscripcion WHERE cursoId = ?"
            );
            preparedStatement.setInt(1, cursoId);
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al eliminar inscripciones por curso: " + e.getMessage());
        }
    }
}
