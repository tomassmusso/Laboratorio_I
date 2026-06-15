package service;

import dao.DaoCurso;
import dao.DaoException;
import dao.DaoInscripcion;
import entidades.Curso;
import entidades.Inscripcion;

import java.util.ArrayList;

public class ServiceCurso {
    private DaoCurso daoCurso;
    private DaoInscripcion daoInscripcion;

    public ServiceCurso() {
        daoCurso = new DaoCurso();
        daoInscripcion = new DaoInscripcion();
    }

    public String reporteRecaudacionCurso(int cursoId) throws ServiceException {
        try {
            Curso curso = daoCurso.consultar(cursoId);
            if(curso == null){
                throw new ServiceException("No se encontró el curso");
            }
            ArrayList<Inscripcion> inscripciones = daoInscripcion.consultarPorCurso(cursoId);
            double recaudado = 0;
            for(Inscripcion inscripcion:inscripciones){
                recaudado += curso.getPrecioActual();
            }
            return "Curso: " + curso.getNombre() + " - Recaudado: $" + recaudado;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public String reporteRecaudacionTotal() throws ServiceException {
        try {
            ArrayList<Curso> cursos = daoCurso.consultarTodos();
            double recaudacionTotal = 0;
            for(Curso curso : cursos){
                ArrayList<Inscripcion> inscripciones = daoInscripcion.consultarPorCurso(curso.getIdCurso());
                double recaudacionCurso = 0;
                for(Inscripcion inscripcion : inscripciones){
                    recaudacionCurso += curso.getPrecioActual();
                }
                recaudacionTotal += recaudacionCurso;
            }
            return "Total Recaudado: " + recaudacionTotal;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public String reporteAnotadosAprobados(int cursoId) throws ServiceException {
        try {
            Curso curso = daoCurso.consultar(cursoId);
            if(curso == null){
                throw new ServiceException("No se encontró el curso");
            }
            ArrayList<Inscripcion> inscripciones = daoInscripcion.consultarPorCurso(cursoId);
            int anotados = 0;
            int aprobados = 0;
            double porcentajeAprobados = 0;
            for(Inscripcion inscripcion:inscripciones){
                anotados++;
                if(inscripcion.materiaAprobada()){
                    aprobados++;
                }
            }
            if(aprobados > 0){
                porcentajeAprobados = ((double) aprobados / anotados) * 100;
            }
            return "Curso: " + curso.getNombre() + " - Anotados: " + anotados + " - Aprobados: " + aprobados + " - Porcentaje Aprobación: " + porcentajeAprobados + "%";
        }
        catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}