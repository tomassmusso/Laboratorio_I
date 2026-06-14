package gui;

import entidades.Alumno;
import service.ServiceAlumno;
import service.ServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarAlumno extends JPanel {
    private PanelManager panelManager;
    private ServiceAlumno serviceAlumno;
    private JLabel jLabelMail;
    private JLabel jLabelUsuario;
    private JLabel jLabelContraseña;
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
        Alumno alumno = (Alumno) panelManager.getUsuarioAModificar();

        JLabel titulo = new JLabel("Modificar Datos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        jTextFieldMail = new JTextField(alumno.getMail());
        jLabelMail = new JLabel("Mail:");
        jTextFieldUsuario = new JTextField(alumno.getUsuario());
        jLabelUsuario = new JLabel("Usuario:");
        jPasswordFieldContraseña = new JPasswordField(alumno.getContraseña());
        jLabelContraseña = new JLabel("Contraseña:");

        jButtonGuardar = new JButton("Guardar");
        jButtonVolver = new JButton("Volver");

        jButtonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alumno.setMail(jTextFieldMail.getText());
                alumno.setUsuario(jTextFieldUsuario.getText());
                alumno.setContraseña(new String(jPasswordFieldContraseña.getPassword()));
                try {
                    serviceAlumno.modificarAlumno(alumno);
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                    panelManager.mostrar(2);
                } catch (ServiceException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
                }
            }
        });

        jButtonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(2);
            }
        });

        setLayout(new GridLayout(9, 1));
        add(titulo);
        add(jLabelMail);
        add(jTextFieldMail);
        add(jLabelUsuario);
        add(jTextFieldUsuario);
        add(jLabelContraseña);
        add(jPasswordFieldContraseña);
        add(jButtonGuardar);
        add(jButtonVolver);
    }
}
