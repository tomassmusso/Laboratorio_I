package gui;

import entidades.Curso;
import entidades.Profesor;
import service.ServiceException;
import service.ServiceProfesor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaCursoProfesor extends JPanel {
    private PanelManager panelManager;
    private ServiceProfesor serviceProfesor;
    private JTable jTable;
    private DefaultTableModel contenido;
    private JScrollPane jScrollPane;
    private JButton jButtonVolver;

    public ListaCursoProfesor(PanelManager panelManager){
        this.panelManager = panelManager;
        armarLista();
    }

    public void armarLista(){
        serviceProfesor = new ServiceProfesor();
        Profesor profesor = (Profesor) panelManager.getUsuarioSeleccionado();

        contenido = new DefaultTableModel();
        jTable = new JTable(contenido);
        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(jTable);
        contenido.addColumn("ID Curso");
        contenido.addColumn("Nombre Curso");
        contenido.addColumn("Cupo");
        contenido.addColumn("Turno");
        contenido.addColumn("Cursada");
        contenido.addColumn("Cantidad Parciales");
        contenido.addColumn("Precio");

        try{
            ArrayList<Curso> cursos = serviceProfesor.consultarCursos(profesor.getId());
            for(Curso curso:cursos){
                Object[] fila = new Object[7];
                fila[0] = curso.getIdCurso();
                fila[1] = curso.getNombre();
                fila[2] = curso.getCupo();
                fila[3] = curso.getTurno();
                fila[4] = curso.getFechaInicio() + " - " + curso.getFechaFin();
                fila[5] = curso.getCantidadParciales();
                fila[6] = curso.getPrecioActual();
                contenido.addRow(fila);
            }
        }
        catch(ServiceException ex){
            JOptionPane.showMessageDialog(null, "Error al cargar los cursos: " + ex.getMessage());
        }

        jButtonVolver = new JButton("Volver");
        jButtonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(8);
            }
        });

        JLabel titulo = new JLabel("Cursos Dictados", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        setLayout(new BorderLayout());
        add(titulo, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
        add(jButtonVolver, BorderLayout.SOUTH);
    }
}