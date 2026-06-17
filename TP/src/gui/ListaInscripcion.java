package gui;

import entidades.Alumno;
import entidades.Inscripcion;
import service.ServiceAlumno;
import service.ServiceException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ListaInscripcion extends JPanel {
    private PanelManager panelManager;
    private ServiceAlumno serviceAlumno;
    private JTable jTable;
    private DefaultTableModel contenido;
    private JScrollPane jScrollPane;
    private JButton jButtonVolver;

    public ListaInscripcion(PanelManager panelManager){
        this.panelManager = panelManager;
        armarLista();
    }

    public void armarLista(){
        serviceAlumno = new ServiceAlumno();
        Alumno alumno = (Alumno) panelManager.getUsuarioIniciado();

        contenido = new DefaultTableModel();
        jTable = new JTable(contenido);
        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(jTable);
        contenido.addColumn("ID Inscripcion");
        contenido.addColumn("Curso");
        contenido.addColumn("Profesor");
        contenido.addColumn("Notas Parciales");
        contenido.addColumn("Nota Final");

        try{
            ArrayList<Inscripcion> inscripciones = serviceAlumno.consultarInscripciones(alumno.getId());
            for(Inscripcion inscripcion:inscripciones){
                Object[] fila = new Object[5];
                fila[0] = inscripcion.getInscripcionId();
                fila[1] = inscripcion.getCurso().getNombre();
                fila[2] = inscripcion.getCurso().getProfesor().getNombre() + " " + inscripcion.getCurso().getProfesor().getApellido();
                fila[3] = inscripcion.getNotasParciales().toString();
                fila[4] = inscripcion.getNotaFinal() != null ? inscripcion.getNotaFinal() : "Sin nota";
                contenido.addRow(fila);
            }
        }
        catch(ServiceException ex){
            JOptionPane.showMessageDialog(null, "Error al cargar inscripciones: " + ex.getMessage());
        }

        jButtonVolver = new JButton("Volver");
        jButtonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(2);
            }
        });

        JLabel titulo = new JLabel("Mis Inscripciones", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        setLayout(new BorderLayout());
        add(titulo, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
        add(jButtonVolver, BorderLayout.SOUTH);
    }
}