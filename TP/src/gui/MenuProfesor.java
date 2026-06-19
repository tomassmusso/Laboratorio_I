package gui;

import entidades.Alumno;
import entidades.Profesor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuProfesor extends JPanel {
    private PanelManager panelManager;
    private JButton jButtonMisDatos;
    private JButton jButtonMisCursos;
    private JButton jButtonCerrarSesion;

    public MenuProfesor(PanelManager panelManager){
        this.panelManager = panelManager;
        armarMenu();
    }

    public void armarMenu(){
        Profesor profesor = (Profesor) panelManager.getUsuarioIniciado();

        JLabel titulo = new JLabel("Menu Profesor", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel labelNombre = new JLabel("Nombre: " + profesor.getNombre() + " " + profesor.getApellido(), SwingConstants.CENTER);
        JLabel labelMail = new JLabel("Mail: " + profesor.getMail(), SwingConstants.CENTER);
        JLabel labelUsuario = new JLabel("Usuario: " + profesor.getUsuario(), SwingConstants.CENTER);
        JLabel jLabelDepartamento = new JLabel("Departamento: " + profesor.getDepartamento(), SwingConstants.CENTER);

        jButtonMisDatos = new JButton("Modificar mis datos");
        jButtonMisCursos = new JButton("Mis Cursos");
        jButtonCerrarSesion = new JButton("Cerrar sesión");

        jButtonMisDatos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panelManager.setUsuarioSeleccionado(profesor);
                panelManager.mostrar(10);
            }
        });
        jButtonMisCursos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(11);
            }
        });
        jButtonCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.setUsuarioIniciado(null);
                panelManager.mostrar(1);
            }
        });

        setLayout(new GridLayout(8, 1));
        add(titulo);
        add(labelNombre);
        add(labelMail);
        add(labelUsuario);
        add(jLabelDepartamento);
        add(jButtonMisDatos);
        add(jButtonMisCursos);
        add(jButtonCerrarSesion);
    }
}