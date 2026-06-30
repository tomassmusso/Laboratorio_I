package gui;

import entidades.Alumno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAlumno extends JPanel {
    private PanelManager panelManager;
    private JButton jButtonMisDatos;
    private JButton jButtonMisInscripciones;
    private JButton jButtonAranceles;
    private JButton jButtonCerrarSesion;

    public MenuAlumno(PanelManager panelManager){
        this.panelManager = panelManager;
        armarMenu();
    }

    public void armarMenu(){
        Alumno alumno = (Alumno) panelManager.getUsuarioIniciado();

        JLabel titulo = new JLabel("Menu Alumno", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel labelNombre = new JLabel("Nombre: " + alumno.getNombre() + " " + alumno.getApellido(), SwingConstants.CENTER);
        JLabel labelMail = new JLabel("Mail: " + alumno.getMail(), SwingConstants.CENTER);
        JLabel labelUsuario = new JLabel("Usuario: " + alumno.getUsuario(), SwingConstants.CENTER);
        JLabel labelLimite = new JLabel("Límite de cursos: " + alumno.getLimiteCursos(), SwingConstants.CENTER);
        JLabel labelDeuda = new JLabel("Deuda: $" + alumno.getDeuda(), SwingConstants.CENTER);

        jButtonMisDatos = new JButton("Modificar mis datos");
        jButtonMisInscripciones = new JButton("Mis inscripciones");
        jButtonCerrarSesion = new JButton("Cerrar sesión");
        jButtonAranceles = new JButton("Aranceles");

        jButtonMisDatos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panelManager.setUsuarioSeleccionado(alumno);
                panelManager.mostrar(7);
            }
        });
        jButtonMisInscripciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(17);
            }
        });
        jButtonAranceles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(19);
            }
        });
        jButtonCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.setUsuarioIniciado(null);
                panelManager.mostrar(1);
            }
        });

        setLayout(new GridLayout(10, 1));
        add(titulo);
        add(labelNombre);
        add(labelMail);
        add(labelUsuario);
        add(labelLimite);
        add(labelDeuda);
        add(jButtonMisDatos);
        add(jButtonMisInscripciones);
        add(jButtonAranceles);
        add(jButtonCerrarSesion);
    }
}