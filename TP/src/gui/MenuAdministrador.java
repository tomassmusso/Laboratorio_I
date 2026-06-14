package gui;

import entidades.Administrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdministrador extends JPanel {
    private PanelManager panelManager;
    private JButton jButtonVerAlumnos;
    private JButton jButtonVerProfesores;
    private JButton jButtonVerCursos;
    private JButton jButtonCerrarSesion;

    public MenuAdministrador(PanelManager panelManager){
        this.panelManager = panelManager;
        armarMenu();
    }

    public void armarMenu(){
        setLayout(new GridLayout(7, 1));

        Administrador admin = (Administrador) panelManager.getUsuarioIniciado();
        JLabel titulo = new JLabel("Menu Administrador", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel labelNombre = new JLabel("Bienvenido: " + admin.getNombre() + " " + admin.getApellido(), SwingConstants.CENTER);
        JLabel labelSector = new JLabel("Sector: " + admin.getSector(), SwingConstants.CENTER);

        jButtonVerAlumnos = new JButton("Ver Alumnos");
        jButtonVerProfesores = new JButton("Ver Profesores");
        jButtonVerCursos = new JButton("Ver Cursos");
        jButtonCerrarSesion = new JButton("Cerrar Sesión");

        jButtonVerAlumnos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(11);
            }
        });
        jButtonVerProfesores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(12);
            }
        });
        jButtonVerCursos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(13);
            }
        });
        jButtonCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.setUsuarioIniciado(null);
                panelManager.mostrar(1);
            }
        });

        add(titulo);
        add(labelNombre);
        add(labelSector);
        add(jButtonVerAlumnos);
        add(jButtonVerProfesores);
        add(jButtonVerCursos);
        add(jButtonCerrarSesion);
    }
}