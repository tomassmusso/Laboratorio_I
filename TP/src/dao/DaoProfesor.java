package dao;

import entidades.Alumno;
import entidades.Profesor;

import java.sql.*;
import java.util.ArrayList;

public class DaoProfesor implements Idao<Profesor>{
    private String DB_JDBC_DRIVER = "org.h2.Driver";
    private String DB_URL = "jdbc:h2:~/test";
    private String DB_USER = "sa";
    private String DB_PASSWORD = "";

    @Override
    public void agregar(Profesor elemento) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("INSERT INTO Profesor(nombre, apellido, mail, usuario, contraseña, departamento) VALUES(?,?,?,?,?,?)");
            preparedStatement.setString(1, elemento.getNombre());
            preparedStatement.setString(2, elemento.getApellido());
            preparedStatement.setString(3, elemento.getMail());
            preparedStatement.setString(4, elemento.getUsuario());
            preparedStatement.setString(5, elemento.getContraseña());
            preparedStatement.setString(6, elemento.getDepartamento());
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error en agregar profesor" + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("DELETE FROM Profesor WHERE id = ?");
            preparedStatement.setInt(1, id);
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error en eliminar profesor" + e.getMessage());
        }
    }

    @Override
    public void modificar(Profesor elemento) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE Profesor SET nombre=?, apellido=?, mail=?, usuario=?, contraseña=?, departamento=? WHERE id=?");
            preparedStatement.setString(1, elemento.getNombre());
            preparedStatement.setString(2, elemento.getApellido());
            preparedStatement.setString(3, elemento.getMail());
            preparedStatement.setString(4, elemento.getUsuario());
            preparedStatement.setString(5, elemento.getContraseña());
            preparedStatement.setString(6, elemento.getDepartamento());
            preparedStatement.setInt(7, elemento.getId());
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error al modificar profesor" + e.getMessage());
        }
    }

    @Override
    public Profesor consultar(int id) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Profesor profesor = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Profesor WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String mail = rs.getString("mail");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                String departamento = rs.getString("departamento");
                profesor = new Profesor(nombre, apellido, mail, usuario, contraseña, departamento);
                profesor.setId(rs.getInt("id"));
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al consultar profesor" + e.getMessage());
        }
        return profesor;
    }

    @Override
    public ArrayList<Profesor> consultarTodos() throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Profesor> profesores = new ArrayList<>();
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Profesor");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String mail = rs.getString("mail");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                String departamento = rs.getString("departamento");
                Profesor profesor = new Profesor(nombre, apellido, mail, usuario, contraseña, departamento);
                profesor.setId(rs.getInt("id"));
                profesores.add(profesor);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al consultar profesores" + e.getMessage());
        }
        return profesores;
    }

    public Profesor inicioSesion(String usuario, String contraseña) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Profesor profesor = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Profesor WHERE usuario = ? AND contraseña = ?"            );
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contraseña);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String mail = rs.getString("mail");
                String usuarioProfesor = rs.getString("usuario");
                String contraseñaProfesor = rs.getString("contraseña");
                String departamento = rs.getString("departamento");
                profesor = new Profesor(nombre, apellido, mail, usuarioProfesor, contraseñaProfesor, departamento);
                profesor.setId(rs.getInt("id"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error en login: " + e.getMessage());
        }
        return profesor;
    }
}
