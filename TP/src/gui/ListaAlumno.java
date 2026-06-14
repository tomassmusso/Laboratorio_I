package gui;

import entidades.Alumno;
import service.ServiceAdministrador;
import service.ServiceException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaAlumno extends JPanel {
    private PanelManager panelManager;
    private ServiceAdministrador serviceAdministrador;
    private JTable jTable;
    private DefaultTableModel contenido;
    private JScrollPane jScrollPane;
    private JButton jButtonAltaAlumno;
    private JButton jButtonModificarAlumno;
    private JButton jButtonEliminarAlumno;
    private JButton jButtonVolver;

    public ListaAlumno(PanelManager panelManager){
        this.panelManager = panelManager;
        armarLista();
    }

    public void armarLista(){
        serviceAdministrador = new ServiceAdministrador();

        contenido = new DefaultTableModel();
        jTable = new JTable(contenido);
        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(jTable);
        contenido.addColumn("ID");
        contenido.addColumn("Nombre");
        contenido.addColumn("Apellido");
        contenido.addColumn("Mail");

        try {
            ArrayList<Alumno> alumnos = serviceAdministrador.consultarTodosAlumnos();
            for(Alumno alumno : alumnos){
                Object[] fila = new Object[4];
                fila[0] = alumno.getId();
                fila[1] = alumno.getNombre();
                fila[2] = alumno.getApellido();
                fila[3] = alumno.getMail();
                contenido.addRow(fila);
            }
        } catch(ServiceException e){
            JOptionPane.showMessageDialog(null, "Error al cargar alumnos: " + e.getMessage());
        }

        jButtonAltaAlumno = new JButton("Alta Alumno");
        jButtonModificarAlumno = new JButton("Modificar Alumno");
        jButtonEliminarAlumno = new JButton("Eliminar Alumno");
        jButtonVolver = new JButton("Volver");

        jButtonAltaAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(6);
            }
        });

        jButtonModificarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el ID del alumno a modificar:");
                try {
                    int id = Integer.parseInt(input);
                    Alumno alumno = serviceAdministrador.consultarAlumno(id);
                    if(alumno != null){
                        panelManager.setUsuarioAModificar(alumno);
                        panelManager.mostrar(7);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el alumno");
                    }
                } catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        jButtonEliminarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el ID del alumno a eliminar:");
                try {
                    int id = Integer.parseInt(input);
                    serviceAdministrador.eliminarAlumno(id);
                    JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente");
                    panelManager.mostrar(5); // refresca la lista
                } catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        jButtonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(4);
            }
        });

        JLabel titulo = new JLabel("Lista de Alumnos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 4));
        panelBotones.add(jButtonAltaAlumno);
        panelBotones.add(jButtonModificarAlumno);
        panelBotones.add(jButtonEliminarAlumno);
        panelBotones.add(jButtonVolver);

        setLayout(new BorderLayout());
        add(titulo, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
}