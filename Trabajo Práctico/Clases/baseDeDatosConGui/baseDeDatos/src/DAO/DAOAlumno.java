package DAO;

import entidades.Alumno;

import java.sql.*;
import java.util.ArrayList;

public class DAOAlumno implements IDAO<Alumno>{
    private String DB_JDBC_DRIVER="org.h2.Driver";
    //private String DB_URL="jdbc:h2:~/test;
    private String DB_URL="jdbc:h2:file:C:\\Users\\labp8\\Documents\\base\\miBase";

    private String DB_USER="sa";

    private String DB_PASSWORD="";

    @Override
    public void guardar(Alumno elemento) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement= connection.prepareStatement("INSERT INTO Alumno VALUES(?,?,?)");
            preparedStatement.setInt(1,elemento.getId());
            preparedStatement.setString(2, elemento.getNombre());
            preparedStatement.setString(3, elemento.getApellido());
            int resultado=preparedStatement.executeUpdate();
            System.out.println("Se agrego " + resultado);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException("Error al insertar");
        }

    }

    @Override
    public void modificar(Alumno elemento) {

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Alumno buscar(int id) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Alumno alumno=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Alumno WHERE ID=?");
            preparedStatement.setInt(1,id);
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next())
            {
                alumno=new Alumno();
                alumno.setId(rs.getInt("ID"));
                alumno.setApellido(rs.getString("APELLIDO"));
                alumno.setNombre(rs.getString("NOMBRE"));
            }
        }
        catch (ClassNotFoundException | SQLException s)
        {
            throw  new DAOException("No se encuentra el alumno");
        }
        finally {
            try {
                preparedStatement.close();
            }
            catch (SQLException s)
            {
                throw  new DAOException("No se pudo conectar");
            }
        }
        return alumno;
    }

    @Override
    public ArrayList<Alumno> buscarTodos() throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Alumno alumno= null;
        ArrayList<Alumno> alumnos=new ArrayList<>();
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Alumno");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                alumno=new Alumno();
                alumno.setId(rs.getInt("ID"));
                alumno.setApellido(rs.getString("APELLIDO"));
                alumno.setNombre(rs.getString("NOMBRE"));
                alumnos.add(alumno);

            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException("Ocurrio un error en la base de datos");
        }
        return alumnos;
    }
}
