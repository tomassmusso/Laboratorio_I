package gui;

import entidades.Administrador;
import entidades.Profesor;
import service.ServiceProfesor;
import service.ServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarProfesor extends JPanel {
    private PanelManager panelManager;
    private ServiceProfesor serviceProfesor;
    private JTextField jTextFieldMail;
    private JTextField jTextFieldUsuario;
    private JPasswordField jPasswordFieldContraseña;
    private JTextField jTextFieldDepartamento;
    private JButton jButtonGuardar;
    private JButton jButtonVolver;

    public ModificarProfesor(PanelManager panelManager){
        this.panelManager = panelManager;
        armarFormulario();
    }

    public void armarFormulario(){
        serviceProfesor = new ServiceProfesor();
        Profesor profesor = (Profesor) panelManager.getUsuarioAModificar();
        boolean esAdmin = panelManager.getUsuarioIniciado() instanceof Administrador;

        JLabel titulo = new JLabel("Modificar Datos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        jTextFieldMail = new JTextField(profesor.getMail());
        jButtonGuardar = new JButton("Guardar");
        jButtonVolver = new JButton("Volver");

        // solo el profesor puede cambiar usuario y contraseña
        if(!esAdmin){
            jTextFieldUsuario = new JTextField(profesor.getUsuario());
            jPasswordFieldContraseña = new JPasswordField(profesor.getContraseña());
        }

        if(esAdmin){
            jTextFieldDepartamento = new JTextField(profesor.getDepartamento());
        }

        jButtonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profesor.setMail(jTextFieldMail.getText());
                if(!esAdmin){
                    profesor.setUsuario(jTextFieldUsuario.getText());
                    profesor.setContraseña(new String(jPasswordFieldContraseña.getPassword()));
                }
                if(esAdmin){
                    profesor.setDepartamento(jTextFieldDepartamento.getText());
                }
                try{
                    serviceProfesor.modificarProfesor(profesor);
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                    if(esAdmin){
                        panelManager.mostrar(8); // vuelve a lista profesores
                    }
                    else{
                        panelManager.mostrar(3); // vuelve al menu profesor
                    }
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
                }
            }
        });

        jButtonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(esAdmin){
                    panelManager.mostrar(8);
                }
                else{
                    panelManager.mostrar(3);
                }
            }
        });

        // GridLayout dinámico según el rol
        if(esAdmin){
            setLayout(new GridLayout(7, 1));
        }
        else{
            setLayout(new GridLayout(9, 1));
        }

        add(titulo);
        add(new JLabel("Mail:"));
        add(jTextFieldMail);

        if(!esAdmin){
            add(new JLabel("Usuario:"));
            add(jTextFieldUsuario);
            add(new JLabel("Contraseña:"));
            add(jPasswordFieldContraseña);
        }

        if(esAdmin){
            add(new JLabel("Departamento: "));
            add(jTextFieldDepartamento);
        }

        add(jButtonGuardar);
        add(jButtonVolver);
    }
}