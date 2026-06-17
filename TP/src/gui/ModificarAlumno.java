package gui;

import entidades.Administrador;
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
    private JTextField jTextFieldMail;
    private JTextField jTextFieldUsuario;
    private JPasswordField jPasswordFieldContraseña;
    private JTextField jTextFieldLimiteCurso;
    private JButton jButtonGuardar;
    private JButton jButtonVolver;

    public ModificarAlumno(PanelManager panelManager){
        this.panelManager = panelManager;
        armarFormulario();
    }

    public void armarFormulario(){
        serviceAlumno = new ServiceAlumno();
        Alumno alumno = (Alumno) panelManager.getUsuarioSeleccionado();
        boolean esAdmin = panelManager.getUsuarioIniciado() instanceof Administrador;

        JLabel titulo = new JLabel("Modificar Datos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        jTextFieldMail = new JTextField(alumno.getMail());
        jButtonGuardar = new JButton("Guardar");
        jButtonVolver = new JButton("Volver");

        if(!esAdmin){
            jTextFieldUsuario = new JTextField(alumno.getUsuario());
            jPasswordFieldContraseña = new JPasswordField(alumno.getContraseña());
        }

        if(esAdmin){
            jTextFieldLimiteCurso = new JTextField(String.valueOf(alumno.getLimiteCursos()));
        }

        jButtonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alumno.setMail(jTextFieldMail.getText());
                if(!esAdmin){
                    alumno.setUsuario(jTextFieldUsuario.getText());
                    alumno.setContraseña(new String(jPasswordFieldContraseña.getPassword()));
                }
                if(esAdmin){
                    alumno.setLimiteCursos(Integer.parseInt(jTextFieldLimiteCurso.getText()));
                }
                try{
                    serviceAlumno.modificarAlumno(alumno);
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                    if(esAdmin){
                        panelManager.mostrar(5);
                    }
                    else{
                        panelManager.mostrar(2);
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
                    panelManager.mostrar(5);
                }
                else{
                    panelManager.mostrar(2);
                }
            }
        });

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
            add(new JLabel("Límite Cursos: "));
            add(jTextFieldLimiteCurso);
        }

        add(jButtonGuardar);
        add(jButtonVolver);
    }
}