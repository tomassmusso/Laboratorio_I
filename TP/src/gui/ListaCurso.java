package gui;

import entidades.Administrador;
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

public class ListaCurso extends JPanel {
    private PanelManager panelManager;
    private ServiceProfesor serviceProfesor;
    private JTable jTable;
    private DefaultTableModel contenido;
    private JScrollPane jScrollPane;
    private JButton jButtonVolver;
    private JButton jButtonReporte;

    public ListaCurso(PanelManager panelManager){
        this.panelManager = panelManager;
        armarLista();
    }

    public void armarLista(){
        serviceProfesor = new ServiceProfesor();
        Profesor profesor = (Profesor) panelManager.getUsuarioAModificar();
        boolean esAdmin = panelManager.getUsuarioIniciado() instanceof Administrador;

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
        catch(ServiceException e){
            JOptionPane.showMessageDialog(null, "Error al cargar los cursos: " + e.getMessage());
        }

        jButtonVolver = new JButton("Volver");
        jButtonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(esAdmin){
                    panelManager.mostrar(8); // vuelve a lista profesores
                } else {
                    panelManager.mostrar(3); // vuelve al menu profesor
                }
            }
        });

        JLabel titulo = new JLabel("Cursos Dictados", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel panelBotones = new JPanel();

        if(esAdmin){
            jButtonReporte = new JButton("Ver Reporte");
            jButtonReporte.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // pendiente
                }
            });
            panelBotones.setLayout(new GridLayout(1, 2));
            panelBotones.add(jButtonReporte);
        } else {
            panelBotones.setLayout(new GridLayout(1, 1));
        }

        panelBotones.add(jButtonVolver);

        setLayout(new BorderLayout());
        add(titulo, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
}