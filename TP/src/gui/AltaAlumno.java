package gui;

import entidades.Alumno;
import service.ServiceAdministrador;
import service.ServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaAlumno extends JPanel {
    private PanelManager panelManager;
    private ServiceAdministrador serviceAdministrador;
    private JTextField jTextFieldNombre;
    private JTextField jTextFieldApellido;
    private JTextField jTextFieldMail;
    private JTextField jTextFieldLimiteCursos;
    private JButton jButtonGuardar;
    private JButton jButtonVolver;

    public AltaAlumno(PanelManager panelManager){
        this.panelManager = panelManager;
        armarFormulario();
    }

    public void armarFormulario(){
        serviceAdministrador = new ServiceAdministrador();

        JLabel titulo = new JLabel("Alta Alumno", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        jTextFieldNombre = new JTextField();
        jTextFieldApellido = new JTextField();
        jTextFieldMail = new JTextField();
        jTextFieldLimiteCursos = new JTextField();

        jButtonGuardar = new JButton("Guardar");
        jButtonVolver = new JButton("Volver");

        jButtonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = jTextFieldNombre.getText();
                String apellido = jTextFieldApellido.getText();
                String mail = jTextFieldMail.getText();
                int limiteCursos = Integer.parseInt(jTextFieldLimiteCursos.getText());

                // usuario y contraseña generados automaticamente
                String usuario = nombre.toLowerCase() + "." + apellido.toLowerCase();
                String contraseña = "1234";

                Alumno alumno = new Alumno(nombre, apellido, mail, usuario, contraseña, limiteCursos);
                try {
                    serviceAdministrador.crearAlumno(alumno);
                    JOptionPane.showMessageDialog(null, "Alumno creado correctamente. Usuario: " + usuario + " - Contraseña: " + contraseña);
                    panelManager.mostrar(5);
                } catch (ServiceException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
                }
            }
        });

        jButtonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(5);
            }
        });

        setLayout(new GridLayout(11, 1));
        add(titulo);
        add(new JLabel("Nombre:"));
        add(jTextFieldNombre);
        add(new JLabel("Apellido:"));
        add(jTextFieldApellido);
        add(new JLabel("Mail:"));
        add(jTextFieldMail);
        add(new JLabel("Límite de cursos:"));
        add(jTextFieldLimiteCursos);
        add(jButtonGuardar);
        add(jButtonVolver);
    }
}