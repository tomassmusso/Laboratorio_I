package service;

import dao.*;
import entidades.*;

import java.util.ArrayList;

public class ServiceAdministrador {
    private DaoAlumno daoAlumno;
    private DaoProfesor daoProfesor;
    private DaoCurso daoCurso;
    private DaoInscripcion daoInscripcion;

    public ServiceAdministrador() {
        daoAlumno = new DaoAlumno();
        daoProfesor = new DaoProfesor();
        daoCurso = new DaoCurso();
        daoInscripcion = new DaoInscripcion();
    }

    // ===== ALUMNO =====
    public void crearAlumno(Alumno alumno) throws ServiceException {
        try {
            daoAlumno.agregar(alumno);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void modificarAlumno(Alumno alumno) throws ServiceException {
        try {
            daoAlumno.modificar(alumno);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void eliminarAlumno(int id) throws ServiceException {
        try {
            daoAlumno.eliminar(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Alumno consultarAlumno(int id) throws ServiceException {
        try {
            return daoAlumno.consultar(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public ArrayList<Alumno> consultarTodosAlumnos() throws ServiceException {
        try {
            return daoAlumno.consultarTodos();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    // ===== PROFESOR =====
    public void crearProfesor(Profesor profesor) throws ServiceException {
        try {
            daoProfesor.agregar(profesor);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void modificarProfesor(Profesor profesor) throws ServiceException {
        try {
            daoProfesor.modificar(profesor);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void eliminarProfesor(int id) throws ServiceException {
        try {
            daoProfesor.eliminar(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Profesor consultarProfesor(int id) throws ServiceException {
        try {
            return daoProfesor.consultar(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public ArrayList<Profesor> consultarTodosProfesores() throws ServiceException {
        try {
            return daoProfesor.consultarTodos();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    // ===== CURSO =====
    public void crearCurso(Curso curso) throws ServiceException {
        try {
            daoCurso.agregar(curso);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void modificarCurso(Curso curso) throws ServiceException {
        try {
            daoCurso.modificar(curso);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void eliminarCurso(int id) throws ServiceException {
        try {
            daoInscripcion.eliminarPorCurso(id); // primero elimina inscripciones
            daoCurso.eliminar(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Curso consultarCurso(int id) throws ServiceException {
        try {
            return daoCurso.consultar(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public ArrayList<Curso> consultarTodosCursos() throws ServiceException {
        try {
            return daoCurso.consultarTodos();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    // ===== INSCRIPCION =====
    public void inscribirAlumno(int alumnoId, int cursoId) throws ServiceException {
        try {
            Alumno alumno = daoAlumno.consultar(alumnoId);
            Curso curso = daoCurso.consultar(cursoId);

            if(alumno == null){
                throw new ServiceException("No se encontró el alumno");
            }
            if(curso == null){
                throw new ServiceException("No se encontró el curso");
            }
            if(!alumno.puedeInscribirse()){
                throw new ServiceException("El alumno alcanzó su límite de cursos");
            }

            ArrayList<Inscripcion> inscripcionesCurso = daoInscripcion.consultarPorCurso(cursoId);
            int anotados = 0;
            for(Inscripcion i : inscripcionesCurso){ anotados++; }
            if(anotados >= curso.getCupo()){
                throw new ServiceException("El curso no tiene cupo disponible");
            }

            Inscripcion inscripcion = new Inscripcion(alumno, curso);
            daoInscripcion.agregar(inscripcion);
            alumno.inscribirseACurso(inscripcion);

        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}