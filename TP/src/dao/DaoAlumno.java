package dao;

import entidades.Alumno;

import java.sql.*;
import java.util.ArrayList;

public class DaoAlumno implements Idao<Alumno>{
    private String DB_JDBC_DRIVER = "org.h2.Driver";
    private String DB_URL = "jdbc:h2:~/test";
    private String DB_USER = "sa";
    private String DB_PASSWORD = "";

    @Override
    public void agregar(Alumno elemento) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("INSERT INTO Alumno(nombre, apellido, mail, usuario, contraseña, limiteCursos, deuda) VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setString(1, elemento.getNombre());
            preparedStatement.setString(2, elemento.getApellido());
            preparedStatement.setString(3, elemento.getMail());
            preparedStatement.setString(4, elemento.getUsuario());
            preparedStatement.setString(5, elemento.getContraseña());
            preparedStatement.setInt(6, elemento.getLimiteCursos());
            preparedStatement.setDouble(7, elemento.getDeuda());
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error en agregar alumno " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("DELETE FROM Alumno WHERE id = ?");
            preparedStatement.setInt(1, id);
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error en eliminar alumno" + e.getMessage());
        }
    }

    @Override
    public void modificar(Alumno elemento) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE Alumno SET nombre=?, apellido=?, mail=?, usuario=?, contraseña=?, limiteCursos=?, deuda=? WHERE id=?");
            preparedStatement.setString(1, elemento.getNombre());
            preparedStatement.setString(2, elemento.getApellido());
            preparedStatement.setString(3, elemento.getMail());
            preparedStatement.setString(4, elemento.getUsuario());
            preparedStatement.setString(5, elemento.getContraseña());
            preparedStatement.setInt(6, elemento.getLimiteCursos());
            preparedStatement.setDouble(7, elemento.getDeuda());
            preparedStatement.setInt(8, elemento.getId());
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error al modificar alumno" + e.getMessage());
        }
    }

    @Override
    public Alumno consultar(int id) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Alumno alumno = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Alumno WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String mail = rs.getString("mail");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                int limiteCursos = rs.getInt("limiteCursos");
                alumno = new Alumno(nombre, apellido, mail, usuario, contraseña, limiteCursos);
                alumno.setId(rs.getInt("id"));
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al consultar alumno" + e.getMessage());
        }
        return alumno;
    }

    @Override
    public ArrayList<Alumno> consultarTodos() throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Alumno");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String mail = rs.getString("mail");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                int limiteCursos = rs.getInt("limiteCursos");
                Alumno alumno = new Alumno(nombre, apellido, mail, usuario, contraseña, limiteCursos);
                alumno.setId(rs.getInt("id"));
                alumnos.add(alumno);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al consultar alumnos" + e.getMessage());
        }
        return alumnos;
    }

    public Alumno inicioSesion(String usuario, String contraseña) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Alumno alumno = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Alumno WHERE usuario = ? AND contraseña = ?"            );
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contraseña);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String mail = rs.getString("mail");
                String usuarioAlumno = rs.getString("usuario");
                String contraseñaAlumno = rs.getString("contraseña");
                int limiteCursos = rs.getInt("limiteCursos");
                alumno = new Alumno(nombre, apellido, mail, usuarioAlumno, contraseñaAlumno, limiteCursos);
                alumno.setId(rs.getInt("id"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error en login: " + e.getMessage());
        }
        return alumno;
    }
}
