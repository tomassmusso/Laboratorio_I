package dao;

import entidades.*;

import java.sql.*;
import java.util.ArrayList;

public class DaoCurso implements Idao<Curso>{
    private String DB_JDBC_DRIVER = "org.h2.Driver";
    private String DB_URL = "jdbc:h2:~/test";
    private String DB_USER = "sa";
    private String DB_PASSWORD = "";

    @Override
    public void agregar(Curso elemento) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO Curso(nombre, cupo, fechaInicio, fechaFin, precio, fechaInicioDescuento, fechaFinDescuento, precioDescuento, idProfesor, cantidadParciales, notaAprobacion, notaPromocion, turno) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)"
            );
            preparedStatement.setString(1, elemento.getNombre());
            preparedStatement.setInt(2, elemento.getCupo());
            preparedStatement.setDate(3, new java.sql.Date(elemento.getFechaInicio().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(elemento.getFechaFin().getTime()));
            preparedStatement.setDouble(5, elemento.getPrecio());
            preparedStatement.setDate(6, new java.sql.Date(elemento.getFechaInicioDescuento().getTime()));
            preparedStatement.setDate(7, new java.sql.Date(elemento.getFechaFinDescuento().getTime()));
            preparedStatement.setDouble(8, elemento.getPrecioDescuento());
            preparedStatement.setInt(9, elemento.getProfesor().getId());
            preparedStatement.setInt(10, elemento.getCantidadParciales());
            preparedStatement.setDouble(11, elemento.getNotaAprobacion());
            preparedStatement.setDouble(12, elemento.getNotaPromocion());
            preparedStatement.setString(13, elemento.getTurno());
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error en agregar curso" + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("DELETE FROM Curso WHERE id = ?");
            preparedStatement.setInt(1, id);
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error en eliminar curso" + e.getMessage());
        }
    }

    @Override
    public void modificar(Curso elemento) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement(
                    "UPDATE Curso SET nombre=?, cupo=?, fechaInicio=?, fechaFin=?, precio=?, fechaInicioDescuento=?, fechaFinDescuento=?, precioDescuento=?, idProfesor=?, cantidadParciales=?, notaAprobacion=?, notaPromocion=?, turno=? WHERE id=?"
            );
            preparedStatement.setString(1, elemento.getNombre());
            preparedStatement.setInt(2, elemento.getCupo());
            preparedStatement.setDate(3, new java.sql.Date(elemento.getFechaInicio().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(elemento.getFechaFin().getTime()));
            preparedStatement.setDouble(5, elemento.getPrecio());
            preparedStatement.setDate(6, new java.sql.Date(elemento.getFechaInicioDescuento().getTime()));
            preparedStatement.setDate(7, new java.sql.Date(elemento.getFechaFinDescuento().getTime()));
            preparedStatement.setDouble(8, elemento.getPrecioDescuento());
            preparedStatement.setInt(9, elemento.getProfesor().getId());
            preparedStatement.setInt(10, elemento.getCantidadParciales());
            preparedStatement.setDouble(11, elemento.getNotaAprobacion());
            preparedStatement.setDouble(12, elemento.getNotaPromocion());
            preparedStatement.setString(13, elemento.getTurno());
            preparedStatement.setInt(14, elemento.getIdCurso());
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error al modificar curso" + e.getMessage());
        }
    }

    @Override
    public Curso consultar(int id) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Curso curso = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Curso WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                int cupo = rs.getInt("cupo");
                Date fechaInicio = rs.getDate("fechaInicio");
                Date fechaFin = rs.getDate("fechaFin");
                double precio = rs.getDouble("precio");
                Date fechaInicioDescuento = rs.getDate("fechaInicioDescuento");
                Date fechaFinDescuento = rs.getDate("fechaFinDescuento");
                double precioDescuento = rs.getDouble("precioDescuento");
                String turno = rs.getString("turno");
                int cantidadParciales = rs.getInt("cantidadParciales");
                double notaAprobacion = rs.getDouble("notaAprobacion");
                double notaPromocion = rs.getDouble("notaPromocion");

                // Traer el objeto Profesor completo a partir del ID
                int idProfesor = rs.getInt("idProfesor");
                DaoProfesor daoProfesor = new DaoProfesor();
                Profesor profesor = daoProfesor.consultar(idProfesor);

                // Construir el curso con todos los datos
                curso = new Curso(nombre, cupo, fechaInicio, fechaFin, precio, fechaInicioDescuento, fechaFinDescuento, precioDescuento, profesor, turno, cantidadParciales, notaAprobacion, notaPromocion);
                curso.setIdCurso(rs.getInt("id"));
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al consultar curso" + e.getMessage());
        }
        return curso;
    }

    @Override
    public ArrayList<Curso> consultarTodos() throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Curso> cursos = new ArrayList<>();
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Curso");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int cupo = rs.getInt("cupo");
                Date fechaInicio = rs.getDate("fechaInicio");
                Date fechaFin = rs.getDate("fechaFin");
                double precio = rs.getDouble("precio");
                Date fechaInicioDescuento = rs.getDate("fechaInicioDescuento");
                Date fechaFinDescuento = rs.getDate("fechaFinDescuento");
                double precioDescuento = rs.getDouble("precioDescuento");
                String turno = rs.getString("turno");
                int cantidadParciales = rs.getInt("cantidadParciales");
                double notaAprobacion = rs.getDouble("notaAprobacion");
                double notaPromocion = rs.getDouble("notaPromocion");

                // Traer el objeto Profesor completo a partir del ID
                int idProfesor = rs.getInt("idProfesor");
                DaoProfesor daoProfesor = new DaoProfesor();
                Profesor profesor = daoProfesor.consultar(idProfesor);

                // Construir el curso con todos los datos
                Curso curso = new Curso(nombre, cupo, fechaInicio, fechaFin, precio, fechaInicioDescuento, fechaFinDescuento, precioDescuento, profesor, turno, cantidadParciales, notaAprobacion, notaPromocion);
                curso.setIdCurso(rs.getInt("id"));
                cursos.add(curso);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al consultar cursos" + e.getMessage());
        }
        return cursos;
    }

    public ArrayList<Curso> consultarPorProfesor(int profesorId) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Curso> cursos = new ArrayList<>();
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM Curso WHERE idProfesor = ?");
            preparedStatement.setInt(1, profesorId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int cupo = rs.getInt("cupo");
                Date fechaInicio = rs.getDate("fechaInicio");
                Date fechaFin = rs.getDate("fechaFin");
                double precio = rs.getDouble("precio");
                Date fechaInicioDescuento = rs.getDate("fechaInicioDescuento");
                Date fechaFinDescuento = rs.getDate("fechaFinDescuento");
                double precioDescuento = rs.getDouble("precioDescuento");
                String turno = rs.getString("turno");
                int cantidadParciales = rs.getInt("cantidadParciales");
                double notaAprobacion = rs.getDouble("notaAprobacion");
                double notaPromocion = rs.getDouble("notaPromocion");

                // Traer el objeto Profesor completo a partir del ID
                int idProfesor = rs.getInt("idProfesor");
                DaoProfesor daoProfesor = new DaoProfesor();
                Profesor profesor = daoProfesor.consultar(idProfesor);

                // Construir el curso con todos los datos
                Curso curso = new Curso(nombre, cupo, fechaInicio, fechaFin, precio, fechaInicioDescuento, fechaFinDescuento, precioDescuento, profesor, turno, cantidadParciales, notaAprobacion, notaPromocion);
                curso.setIdCurso(rs.getInt("id"));
                cursos.add(curso);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al consultar cursos por profesor" + e.getMessage());
        }
        return cursos;
    }
}
