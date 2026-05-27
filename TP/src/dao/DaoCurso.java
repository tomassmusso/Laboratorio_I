package dao;

import entidades.Curso;

import java.util.ArrayList;

public class DaoCurso implements Idao<Curso>{
    @Override
    public void agregar(Curso elemento) throws DaoException {

    }

    @Override
    public void eliminar(int id) throws DaoException {

    }

    @Override
    public void modificar(Curso elemento) throws DaoException {

    }

    @Override
    public Curso consultar(int id) throws DaoException {
        return null;
    }

    @Override
    public ArrayList<Curso> consultarTodos() throws DaoException {
        return null;
    }
}
