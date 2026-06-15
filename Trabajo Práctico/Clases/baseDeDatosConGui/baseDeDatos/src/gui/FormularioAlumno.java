package gui;

import entidades.Alumno;
import service.ServiceAlumno;
import service.ServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioAlumno extends JPanel {
    ServiceAlumno serviceAlumno;
    PanelManager panel;
    JPanel formularioAlumno;
    JLabel jLabelnombre;
    JLabel jLabelApellido;
    JTextField jTextFieldNombre;
    JTextField jTextFieldApellido;
    JButton jButtonGrabar;
    JButton jButtonReporte;

    public FormularioAlumno(PanelManager panel)
    {
        this.panel=panel;
        armarFormulario();
    }
    public void armarFormulario()
    {
        serviceAlumno=new ServiceAlumno();
        formularioAlumno=new JPanel();
        formularioAlumno.setLayout(new GridLayout(3,2));
        jLabelnombre=new JLabel("Nombre");
        jTextFieldNombre=new JTextField(20);
        jLabelApellido=new JLabel("Apellido");
        jTextFieldApellido=new JTextField(20);
        jButtonGrabar=new JButton("Grabar");
        jButtonReporte=new JButton("Ver reporte");

        formularioAlumno.add(jLabelnombre);

        formularioAlumno.add(jTextFieldNombre);
        formularioAlumno.add(jLabelApellido);
        formularioAlumno.add(jTextFieldApellido);
        formularioAlumno.add(jButtonGrabar);
        formularioAlumno.add(jButtonReporte);


        jButtonGrabar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Alumno alumno=new Alumno();
                alumno.setNombre(jTextFieldNombre.getText());
                //int edad=Integer.parseInt(jTextFieldApellido.getText());
                try {
                    serviceAlumno.guardar(alumno);
                }
                catch (ServiceException s)
                {
                    JOptionPane.showMessageDialog(null,"No se pudo guardar");
                }

            }
        });

        jButtonReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.mostrar(2);
            }
        });
        setLayout(new BorderLayout());
        add(formularioAlumno,BorderLayout.CENTER);
    }
}
