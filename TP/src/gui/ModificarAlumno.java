package gui;

import service.ServiceAlumno;

import javax.swing.*;

public class ModificarAlumno extends JPanel {
    private PanelManager panelManager;
    private ServiceAlumno serviceAlumno;
    private JTextField jTextFieldMail;
    private JTextField jTextFieldUsuario;
    private JPasswordField jPasswordFieldContraseña;
    private JButton jButtonGuardar;
    private JButton jButtonVolver;

    public ModificarAlumno(PanelManager panelManager){
        this.panelManager = panelManager;
        armarFormulario();
    }

    public void armarFormulario(){
        serviceAlumno = new ServiceAlumno();
        Alumno alumno = (Alumno) panelManager.getUsuarioSeleccionado();

        JLabel titulo = new JLabel("Modificar Datos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel formulario = new JPanel();
        formulario.setLayout(new GridLayout(5, 2, 10, 10));

        formulario.add(new JLabel("Mail:"));
        jTextFieldMail = new JTextField(alumno.getMail());
        formulario.add(jTextFieldMail);

        formulario.add(new JLabel("Usuario:"));
        jTextFieldUsuario = new JTextField(alumno.getUsuario());
        formulario.add(jTextFieldUsuario);

        formulario.add(new JLabel("Contraseña:"));
        jPasswordFieldContraseña = new JPasswordField(alumno.getContraseña());
        formulario.add(jPasswordFieldContraseña);

        jButtonGuardar = new JButton("Guardar");
        jButtonVolver = new JButton("Volver");
    }
}
