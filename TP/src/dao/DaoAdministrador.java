package dao;

import entidades.Administrador;

import java.sql.*;
import java.util.ArrayList;

public class DaoAdministrador implements Idao<Administrador>{
    private String DB_JDBC_DRIVER = "org.h2.Driver";
    private String DB_URL = "jdbc:h2:~/test";
    private String DB_USER = "sa";
    private String DB_PASSWORD = "";

    @Override
    public void agregar(Administrador elemento) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("INSERT INTO Administrador(nombre, apellido, mail, usuario, contraseña, sector) VALUES(?,?,?,?,?,?)");
            preparedStatement.setString(1, elemento.getNombre());
            preparedStatement.setString(2, elemento.getApellido());
            preparedStatement.setString(3, elemento.getMail());
            preparedStatement.setString(4, elemento.getUsuario());
            preparedStatement.setString(5, elemento.getContraseña());
            preparedStatement.setString(6, elemento.getSector());
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error en agregar administrador" + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("DELETE FROM Administrador WHERE id = ?");
            preparedStatement.setInt(1, id);
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error en eliminar administrador" + e.getMessage());
        }
    }

    @Override
    public void modificar(Administrador elemento) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE Administrador SET nombre=?, apellido=?, mail=?, usuario=?, contraseña=?, sector=? WHERE id=?");
            preparedStatement.setString(1, elemento.getNombre());
            preparedStatement.setString(2, elemento.getApellido());
            preparedStatement.setString(3, elemento.getMail());
            preparedStatement.setString(4, elemento.getUsuario());
            preparedStatement.setString(5, elemento.getContraseña());
            preparedStatement.setString(6, elemento.getSector());
            preparedStatement.setInt(7, elemento.getId());
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error al modificar administrador" + e.getMessage());
        }
    }

    @Override
    public Administrador consultar(int id) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Administrador administrador = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Administrador WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String mail = rs.getString("mail");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                String sector = rs.getString("sector");
                administrador = new Administrador(nombre, apellido, mail, usuario, contraseña, sector);
                administrador.setId(rs.getInt("id"));
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al consultar administrador" + e.getMessage());
        }
        return administrador;
    }

    @Override
    public ArrayList<Administrador> consultarTodos() throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Administrador> administradores = new ArrayList<>();
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Administrador");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String mail = rs.getString("mail");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                String sector = rs.getString("Sector");
                Administrador administrador = new Administrador(nombre, apellido, mail, usuario, contraseña, sector);
                administrador.setId(rs.getInt("id"));
                administradores.add(administrador);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al consultar administradores");
        }
        return administradores;
    }
}
