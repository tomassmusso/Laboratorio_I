package dao;

import java.util.ArrayList;

public interface IDAO<T>{

    public void agregar(T elemento) throws DaoException;
    public void eliminar(int id) throws DaoException;
    public void modificar(T elemento) throws DaoException;
    public T consultar(int id) throws DaoException;
    public ArrayList<T> consultarTodos();
}
