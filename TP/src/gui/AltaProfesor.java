package gui;

import entidades.Profesor;
import service.ServiceAdministrador;
import service.ServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaProfesor extends JPanel {
    private PanelManager panelManager;
    private ServiceAdministrador serviceAdministrador;
    private JTextField jTextFieldNombre;
    private JTextField jTextFieldApellido;
    private JTextField jTextFieldMail;
    private JTextField jTextFieldDepartamento;
    private JButton jButtonGuardar;
    private JButton jButtonVolver;

    public AltaProfesor(PanelManager panelManager){
        this.panelManager = panelManager;
        armarFormulario();
    }

    public void armarFormulario(){
        serviceAdministrador = new ServiceAdministrador();

        JLabel titulo = new JLabel("Alta Profesor", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        jTextFieldNombre = new JTextField();
        jTextFieldApellido = new JTextField();
        jTextFieldMail = new JTextField();
        jTextFieldDepartamento = new JTextField();

        jButtonGuardar = new JButton("Guardar");
        jButtonVolver = new JButton("Volver");

        jButtonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = jTextFieldNombre.getText();
                String apellido = jTextFieldApellido.getText();
                String mail = jTextFieldMail.getText();
                String departamento = jTextFieldDepartamento.getText();
                String usuario = nombre.toLowerCase() + "." + apellido.toLowerCase();
                String contraseña = "1234";

                Profesor profesor = new Profesor(nombre, apellido, mail, usuario, contraseña, departamento);
                try{
                    serviceAdministrador.crearProfesor(profesor);
                    JOptionPane.showMessageDialog(null, "Profesor creado correctamente. Usuario: " + usuario + " - Contraseña: " + contraseña);
                    panelManager.mostrar(8);
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
                }
            }
        });

        jButtonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(8);
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
        add(new JLabel("Departamento:"));
        add(jTextFieldDepartamento);
        add(jButtonGuardar);
        add(jButtonVolver);
    }
}
