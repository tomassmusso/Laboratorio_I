package dao;

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
            preparedStatement = connection.prepareStatement("INSERT INTO Profesor VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, elemento.getId());
            preparedStatement.setString(2, elemento.getNombre());
            preparedStatement.setString(3, elemento.getApellido());
            preparedStatement.setString(4, elemento.getMail());
            preparedStatement.setString(5, elemento.getUsuario());
            preparedStatement.setString(6, elemento.getContraseña());
            preparedStatement.setString(7, elemento.getDepartamento());
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
                String departamento = rs.getString("Departamento");
                profesor = new Profesor(nombre, apellido, mail, usuario, contraseña, departamento);
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
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String mail = rs.getString("mail");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                String departamento = rs.getString("Departamento");
                Profesor profesor = new Profesor(nombre, apellido, mail, usuario, contraseña, departamento);
                profesores.add(profesor);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al consultar profesores" + e.getMessage());
        }
        return profesores;
    }
}
