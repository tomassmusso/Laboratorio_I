package service;

import dao.DaoAdministrador;
import dao.DaoAlumno;
import dao.DaoException;
import dao.DaoProfesor;
import entidades.Administrador;
import entidades.Alumno;
import entidades.Profesor;
import entidades.Usuario;

public class ServiceUsuario {
    private DaoAdministrador daoAdministrador;
    private DaoAlumno daoAlumno;
    private DaoProfesor daoProfesor;

    public ServiceUsuario(){
        daoAdministrador = new DaoAdministrador();
        daoAlumno = new DaoAlumno();
        daoProfesor = new DaoProfesor();
    }

    public Usuario inicioSesion(String usuario, String contraseña) throws ServiceException{
        try{
            Alumno alumno = daoAlumno.inicioSesion(usuario, contraseña);
            if(alumno != null){
                return alumno;
            }
            Profesor profesor = daoProfesor.inicioSesion(usuario, contraseña);
            if(profesor != null){
                return profesor;
            }
            Administrador administrador = daoAdministrador.inicioSesion(usuario, contraseña);
            if(administrador != null){
                return administrador;
            }
            throw new ServiceException("Usuario o contraseña incorrectas");
        }
        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }
    }
}
