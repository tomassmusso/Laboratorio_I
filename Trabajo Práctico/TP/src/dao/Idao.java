package dao;

import java.util.ArrayList;

public interface Idao <T>{
    public void agregar(T elemento);
    public void eliminar(int id);
    public void modificar(T elemento);
    public T consultar(int id);
    public ArrayList<T> consultarTodos();
}
