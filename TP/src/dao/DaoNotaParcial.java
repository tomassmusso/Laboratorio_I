package dao;

import entidades.NotaParcial;
import entidades.Profesor;

import java.sql.*;
import java.util.ArrayList;

public class DaoNotaParcial implements Idao<NotaParcial> {
    private String DB_JDBC_DRIVER = "org.h2.Driver";
    private String DB_URL = "jdbc:h2:~/test";
    private String DB_USER = "sa";
    private String DB_PASSWORD = "";

    @Override
    public void agregar(NotaParcial elemento) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("INSERT INTO NotaParcial(inscripcionId, nota) VALUES(?, ?)");
            preparedStatement.setInt(1, elemento.getInscripcionId());
            preparedStatement.setDouble(2, elemento.getNota());
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error en agregar nota" + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("DELETE FROM NotaParcial WHERE id = ?");
            preparedStatement.setInt(1, id);
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error en eliminar nota" + e.getMessage());
        }
    }

    @Override
    public void modificar(NotaParcial elemento) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE NotaParcial SET nota=? WHERE id=?");
            preparedStatement.setDouble(1, elemento.getNota());
            preparedStatement.setInt(2, elemento.getId());
            int resultado = preparedStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DaoException("Error al modificar nota" + e.getMessage());
        }
    }

    @Override
    public NotaParcial consultar(int id) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        NotaParcial notaParcial = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM NotaParcial WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                double nota = rs.getDouble("nota");
                int inscripcionId = rs.getInt("inscripcionId");
                notaParcial = new NotaParcial(inscripcionId, nota);
                notaParcial.setId(rs.getInt("id"));
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al consultar nota" + e.getMessage());
        }
        return notaParcial;
    }

    @Override
    public ArrayList<NotaParcial> consultarTodos() throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<NotaParcial> notasParcial = new ArrayList<>();
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM NotaParcial");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                double nota = rs.getDouble("nota");
                int inscripcionId = rs.getInt("inscripcionId");
                NotaParcial notaParcial = new NotaParcial(inscripcionId, nota);
                notaParcial.setId(rs.getInt("id"));
                notasParcial.add(notaParcial);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al consultar nota" + e.getMessage());
        }
        return notasParcial;
    }

    public ArrayList<NotaParcial> consultarPorInscripcion(int inscripcionId) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<NotaParcial> notas = new ArrayList<>();
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM NotaParcial WHERE inscripcionId = ?"
            );
            preparedStatement.setInt(1, inscripcionId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                double nota = rs.getDouble("nota");
                int idInscripcion = rs.getInt("inscripcionId");
                NotaParcial notaParcial = new NotaParcial(idInscripcion, nota);
                notaParcial.setId(rs.getInt("id"));
                notas.add(notaParcial);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Error al consultar notas por inscripcion: " + e.getMessage());
        }
        return notas;
    }
}
