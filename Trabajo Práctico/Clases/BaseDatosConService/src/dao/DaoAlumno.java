package dao;

import entidades.Alumno;

import java.sql.*;
import java.util.ArrayList;

public class DaoAlumno implements IDAO<Alumno>{

    private String DB_JDBC_DRIVER="org.h2.Driver";
    //private String DB_URL="jdbc:h2:~/test;
    private String DB_URL="jdbc:h2:file:C:\\Users\\labp8\\Documents\\base\\miBase";

    private String DB_USER="sa";

    private String DB_PASSWORD="";

    @Override
    public void agregar(Alumno elemento) throws DaoException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            System.out.println("no hay driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("se conecto");
            preparedStatement = connection.prepareStatement("INSERT INTO Alumno VALUES(?,?,?)");
            preparedStatement.setInt(1, elemento.getId());
            preparedStatement.setString(2, elemento.getNombre());
            preparedStatement.setInt(3, elemento.getNota());
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error en agregar alumno");
        }
    }

    @Override
    public void eliminar(int id) throws DaoException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            System.out.println("no hay driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("se conecto");
            preparedStatement = connection.prepareStatement("DELETE from  Alumno  WHERE id=?");
            preparedStatement.setInt(1, id);
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error en agregar alumno");
        }
    }

    @Override
    public void modificar(Alumno elemento) throws DaoException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            System.out.println("no hay driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("se conecto");
            preparedStatement = connection.prepareStatement("UPDATE  Alumno SET(nombre=?,nota=?) WHERE id=?");
            preparedStatement.setString(1, elemento.getNombre());
            preparedStatement.setInt(2, elemento.getNota());
            preparedStatement.setInt(3, elemento.getId());
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error en agregar alumno");
        }
    }

    @Override
    public Alumno consultar(int id) throws DaoException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Alumno alumno=null;
        //Alumno alumno=new Alumno();
        try {
            Class.forName(DB_JDBC_DRIVER);
            System.out.println("no hay driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("se conecto");
            preparedStatement = connection.prepareStatement("SELECT * FROM  Alumno  WHERE id=?");

            preparedStatement.setInt(1,id);
            ResultSet rs=preparedStatement.executeQuery();
            if (rs.next())
            {
                /*alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setNota(rs.getInt("nota"));
                */

                String nombre=(rs.getString("nombre"));
                int nota=(rs.getInt("nota"));
                alumno=new Alumno(id, nombre);
                alumno.cambiarNota(nota);
            }

        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error en agregar alumno");
        }
        return alumno;
    }

    @Override
    public ArrayList<Alumno> consultarTodos() {
        return null;
    }
}
