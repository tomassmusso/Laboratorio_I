package gui;

import entidades.Administrador;
import entidades.Curso;
import entidades.Profesor;
import service.ServiceCurso;
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
    private ServiceCurso serviceCurso;
    private JTable jTable;
    private DefaultTableModel contenido;
    private JScrollPane jScrollPane;
    private JButton jButtonVerInscriptos;
    private JButton jButtonVerReporte;
    private JButton jButtonModificarCurso;
    private JButton jButtonVolver;

    public ListaCursoProfesor(PanelManager panelManager){
        this.panelManager = panelManager;
        armarLista();
    }

    public void armarLista(){
        serviceProfesor = new ServiceProfesor();
        serviceCurso = new ServiceCurso();
        Profesor profesor = null;
        boolean esAdmin = panelManager.getUsuarioIniciado() instanceof Administrador;
        if(esAdmin){
            profesor = (Profesor) panelManager.getUsuarioSeleccionado();
        }
        else{
            profesor = (Profesor) panelManager.getUsuarioIniciado();
        }

        contenido = new DefaultTableModel();
        jTable = new JTable(contenido);
        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(jTable);
        contenido.addColumn("ID Curso");
        contenido.addColumn("Nombre Curso");
        contenido.addColumn("Cupo");
        contenido.addColumn("Anotados");
        contenido.addColumn("Turno");
        contenido.addColumn("Cursada");
        contenido.addColumn("Cantidad Parciales");
        contenido.addColumn("Precio");
        contenido.addColumn("Nota Aprobación");
        contenido.addColumn("Nota Promoción");

        try{
            ArrayList<Curso> cursos = serviceProfesor.consultarCursos(profesor.getId());
            for(Curso curso:cursos){
                Object[] fila = new Object[10];
                fila[0] = curso.getIdCurso();
                fila[1] = curso.getNombre();
                fila[2] = curso.getCupo();
                fila[3] = serviceCurso.cantidadInscriptos(curso.getIdCurso());
                fila[4] = curso.getTurno();
                fila[5] = curso.getFechaInicio() + " - " + curso.getFechaFin();
                fila[6] = curso.getCantidadParciales();
                fila[7] = curso.getPrecioActual();
                fila[8] = curso.getNotaAprobacion();
                fila[9] = curso.getNotaPromocion();
                contenido.addRow(fila);
            }
        }
        catch(ServiceException ex){
            JOptionPane.showMessageDialog(null, "Error al cargar los cursos: " + ex.getMessage());
        }

        jButtonVerInscriptos = new JButton("Ver Inscriptos");
        jButtonModificarCurso = new JButton("Modificar Curso");
        jButtonVerReporte = new JButton("Ver Reporte Curso");
        jButtonVolver = new JButton("Volver");

        jButtonVerInscriptos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String input = JOptionPane.showInputDialog("Ingrese ID del curso:");
                    int id = Integer.parseInt(input);

                    Curso curso = serviceProfesor.consultarCurso(id);

                    panelManager.setCursoSeleccionado(curso);
                    panelManager.mostrar(18);
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        jButtonModificarCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String input = JOptionPane.showInputDialog("Ingrese ID del curso a modificar:");
                    int id = Integer.parseInt(input);

                    Curso curso = serviceProfesor.consultarCurso(id);

                    panelManager.setCursoSeleccionado(curso);
                    panelManager.mostrar(13);
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        jButtonVerReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String input = JOptionPane.showInputDialog("Ingrese ID del curso a ver reporte:");
                    int id = Integer.parseInt(input);

                    Curso curso = serviceProfesor.consultarCurso(id);

                    panelManager.setCursoSeleccionado(curso);
                    panelManager.mostrar(16);
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
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

        JLabel titulo = new JLabel("Cursos Dictados", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel panelBotones = new JPanel();

        if(esAdmin){
            panelBotones.setLayout(new GridLayout(1, 1));
        }
        else{
            panelBotones.setLayout(new GridLayout(1, 4));
            panelBotones.add(jButtonModificarCurso);
            panelBotones.add(jButtonVerInscriptos);
            panelBotones.add(jButtonVerReporte);
        }

        panelBotones.add(jButtonVolver);

        setLayout(new BorderLayout());
        add(titulo, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
}