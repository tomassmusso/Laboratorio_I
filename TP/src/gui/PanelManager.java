package gui;

import entidades.Usuario;

import javax.swing.*;
import java.awt.*;

public class PanelManager {
    private JFrame jFrame;
    private Usuario usuarioIniciado;
    private Usuario usuarioAModificar;
    private InicioSesion inicioSesion;
    private MenuAlumno menuAlumno;
    private MenuProfesor menuProfesor;
    private MenuAdministrador menuAdministrador;
    private ListaAlumno listaAlumno;
    private AltaAlumno altaAlumno;
    private ModificarAlumno modificarAlumno;
    private ListaProfesor listaProfesor;
    private AltaProfesor altaProfesor;
    private ModificarProfesor modificarProfesor;
    private ListaInscripcion listaInscripcion;
    private ListaCurso listaCurso;
    /*
    private AltaCurso altaCurso;
    private ModificarCurso modificarCurso;
    private AltaInscripcion altaInscripcion;
    private ReporteRecaudacion reporteRecaudacion;
    private ReporteCurso reporteCurso;
    private AltaNota altaNota;
     */

    public PanelManager(){
        jFrame = new JFrame("Sistema de Alumnos");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mostrar(1);
        jFrame.setSize(500, 700);
    }

    public Usuario getUsuarioAModificar() {
        return usuarioAModificar;
    }

    public void setUsuarioAModificar(Usuario usuarioAModificar) {
        this.usuarioAModificar = usuarioAModificar;
    }

    public Usuario getUsuarioIniciado() {
        return usuarioIniciado;
    }

    public void setUsuarioIniciado(Usuario usuarioIniciado) {
        this.usuarioIniciado = usuarioIniciado;
    }

    public void mostrar(JPanel panel){
        jFrame.getContentPane().removeAll();
        jFrame.getContentPane().add(BorderLayout.CENTER, panel);
        jFrame.getContentPane().validate();
        jFrame.getContentPane().repaint();
        jFrame.setVisible(true);
    }

    public void mostrar(int codigoPantalla){
        switch (codigoPantalla){
            case 1:
                inicioSesion = new InicioSesion(this);
                mostrar(inicioSesion);
                break;
            case 2:
                menuAlumno = new MenuAlumno(this);
                mostrar(menuAlumno);
                break;
            case 3:
                menuProfesor = new MenuProfesor(this);
                mostrar(menuProfesor);
                break;
            case 4:
                menuAdministrador = new MenuAdministrador(this);
                mostrar(menuAdministrador);
                break;
            case 5:
                listaAlumno = new ListaAlumno(this);
                mostrar(listaAlumno);
                break;
            case 6:
                altaAlumno = new AltaAlumno(this);
                mostrar(altaAlumno);
                break;
            case 7:
                modificarAlumno = new ModificarAlumno(this);
                mostrar(modificarAlumno);
                break;
            case 8:
                listaProfesor = new ListaProfesor(this);
                mostrar(listaProfesor);
                break;
            case 9:
                altaProfesor = new AltaProfesor(this);
                mostrar(altaProfesor);
                break;
            case 10:
                modificarProfesor = new ModificarProfesor(this);
                mostrar(modificarProfesor);
                break;
            case 11:
                listaCurso = new ListaCurso(this);
                mostrar(listaCurso);
                break;

            case 17:
                listaInscripcion = new ListaInscripcion(this);
                mostrar(listaInscripcion);
                break;
        }
    }
}