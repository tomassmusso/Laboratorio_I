package gui;

import entidades.Usuario;
import service.ServiceException;
import service.ServiceUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioSesion extends JPanel {
    private PanelManager panelManager;
    private ServiceUsuario serviceUsuario;
    private JPanel formulario;
    private JLabel jLabelUsuario;
    private JLabel jLabelContraseña;
    private JTextField jTextFieldUsuario;
    private JPasswordField jPasswordFieldContraseña;
    private JButton jButtonIngresar;

    public InicioSesion(PanelManager panelManager) {
        this.panelManager = panelManager;
        armarFormulario();
    }

    public void armarFormulario() {
        serviceUsuario = new ServiceUsuario();
        formulario = new JPanel();
        formulario.setLayout(new GridLayout(3, 2));

        jLabelUsuario = new JLabel("Usuario:");
        jTextFieldUsuario = new JTextField(20);
        jLabelContraseña = new JLabel("Contraseña:");
        jPasswordFieldContraseña = new JPasswordField(20);
        jButtonIngresar = new JButton("Ingresar");

        formulario.add(jLabelUsuario);
        formulario.add(jTextFieldUsuario);
        formulario.add(jLabelContraseña);
        formulario.add(jPasswordFieldContraseña);
        formulario.add(new JLabel()); // celda vacía para alinear el botón
        formulario.add(jButtonIngresar);

        jButtonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String usuario = jTextFieldUsuario.getText();
                String contraseña = new String(jPasswordFieldContraseña.getPassword());
                try {
                    Usuario logueado = serviceUsuario.inicioSesion(usuario, contraseña);
                    panelManager.setUsuarioIniciado(logueado);
                    // redirige según el rol
                    if(logueado instanceof entidades.Alumno){
                        panelManager.mostrar(2); // menuAlumno
                    }
                    else if(logueado instanceof entidades.Profesor){
                        panelManager.mostrar(3); // menuProfesor
                    }
                    else if(logueado instanceof entidades.Administrador){
                        panelManager.mostrar(4); // menuAdmin
                    }
                } catch (ServiceException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });

        setLayout(new BorderLayout());
        JLabel titulo = new JLabel("Sistema de Alumnos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(titulo, BorderLayout.NORTH);
        add(formulario, BorderLayout.CENTER);
    }
}