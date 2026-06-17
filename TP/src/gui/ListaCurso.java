package gui;

import entidades.Curso;
import entidades.Administrador;
import service.ServiceAdministrador;
import service.ServiceCurso;
import service.ServiceException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaCurso extends JPanel {
    private PanelManager panelManager;
    private ServiceAdministrador serviceAdministrador;
    private ServiceCurso serviceCurso;
    private JTable jTable;
    private DefaultTableModel contenido;
    private JScrollPane jScrollPane;
    private JButton jButtonAltaCurso;
    private JButton jButtonModificarCurso;
    private JButton jButtonEliminarCurso;
    private JButton jButtonVerReporteAprobados;
    private JButton jButtonVerReporteRecaudacion;
    private JButton jButtonVolver;

    public ListaCurso(PanelManager panelManager){
        this.panelManager = panelManager;
        armarLista();
    }

    public void armarLista(){
        serviceAdministrador = new ServiceAdministrador();
        serviceCurso = new ServiceCurso();
        boolean esAdmin = panelManager.getUsuarioIniciado() instanceof Administrador;

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

        try{
            ArrayList<Curso> cursos = serviceAdministrador.consultarTodosCursos();
            for(Curso curso:cursos){
                Object[] fila = new Object[8];
                fila[0] = curso.getIdCurso();
                fila[1] = curso.getNombre();
                fila[2] = curso.getCupo();
                fila[3] = serviceCurso.cantidadInscriptos(curso.getIdCurso());
                fila[4] = curso.getTurno();
                fila[5] = curso.getFechaInicio() + " - " + curso.getFechaFin();
                fila[6] = curso.getCantidadParciales();
                fila[7] = curso.getPrecioActual();
                contenido.addRow(fila);
            }
        }
        catch(ServiceException ex){
            JOptionPane.showMessageDialog(null, "Error al cargar los cursos: " + ex.getMessage());
        }

        jButtonAltaCurso = new JButton("Alta Curso");
        jButtonModificarCurso = new JButton("Modificar Curso");
        jButtonEliminarCurso = new JButton("Eliminar Curso");
        jButtonVerReporteAprobados = new JButton("Ver Reporte Aprobados");
        jButtonVerReporteRecaudacion = new JButton("Ver Reporte Recaudación");
        jButtonVolver = new JButton("Volver");

        jButtonAltaCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(12);
            }
        });
        jButtonModificarCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el ID del curso a modificar:");
                try{
                    int id = Integer.parseInt(input);
                    Curso curso = serviceAdministrador.consultarCurso(id);
                    if(curso != null){
                        panelManager.setCursoSeleccionado(curso);
                        panelManager.mostrar(13);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No se encontró el alumno");
                    }
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        jButtonEliminarCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el ID del curso a eliminar:");
                try{
                    int id = Integer.parseInt(input);
                    serviceAdministrador.eliminarCurso(id);
                    JOptionPane.showMessageDialog(null, "Curso eliminado correctamente");
                    panelManager.mostrar(14);
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        jButtonVerReporteRecaudacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String input = JOptionPane.showInputDialog("Ingrese ID del curso a ver reporte:");
                    int id = Integer.parseInt(input);
                    Curso curso = serviceAdministrador.consultarCurso(id);
                    panelManager.setCursoSeleccionado(curso);
                    panelManager.mostrar(15);
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        jButtonVerReporteAprobados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String input = JOptionPane.showInputDialog("Ingrese ID del curso a ver reporte:");
                    int id = Integer.parseInt(input);
                    Curso curso = serviceAdministrador.consultarCurso(id);
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
                panelManager.mostrar(4);
            }
        });

        JLabel titulo = new JLabel("Lista Cursos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel recaudacionTotal = new JLabel();
        try{
            recaudacionTotal = new JLabel(serviceCurso.reporteRecaudacionTotal(), SwingConstants.CENTER);
        }
        catch(ServiceException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

        JPanel panelBotones = new JPanel();
        if(esAdmin){
            panelBotones.setLayout(new GridLayout(1, 7));
            panelBotones.add(jButtonAltaCurso);
            panelBotones.add(jButtonEliminarCurso);
            panelBotones.add(jButtonVerReporteRecaudacion);
            panelBotones.add(jButtonVerReporteAprobados);
        }
        else{
            panelBotones.setLayout(new GridLayout(1, 4));
        }
        panelBotones.add(jButtonModificarCurso);
        panelBotones.add(jButtonVolver);

        JPanel panelSuperior = new JPanel(new GridLayout(2,1));
        panelSuperior.add(titulo);
        panelSuperior.add(recaudacionTotal);

        setLayout(new BorderLayout());

        add(panelSuperior, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
}
