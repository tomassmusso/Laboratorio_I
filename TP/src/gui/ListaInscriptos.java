package gui;

import entidades.Curso;
import entidades.Inscripcion;
import service.ServiceException;
import service.ServiceProfesor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaInscriptos extends JPanel {
    private PanelManager panelManager;
    private ServiceProfesor serviceProfesor;
    private JTable jTable;
    private DefaultTableModel contenido;
    private JScrollPane jScrollPane;
    private JButton jButtonCargarNotaParcial;
    private JButton jButtonCargarNotaFinal;
    private JButton jButtonVolver;

    public ListaInscriptos(PanelManager panelManager){
        this.panelManager = panelManager;
        armarLista();
    }

    public void armarLista(){
        serviceProfesor = new ServiceProfesor();

        Curso curso = panelManager.getCursoSeleccionado();
        contenido = new DefaultTableModel();
        jTable = new JTable(contenido);
        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(jTable);

        contenido.addColumn("ID Inscripción");
        contenido.addColumn("ID Alumno");
        contenido.addColumn("Alumno");
        contenido.addColumn("Notas Parciales");
        contenido.addColumn("Nota Final");

        try{
            ArrayList<Inscripcion> inscripciones =
                    serviceProfesor.consultarInscripciones(curso.getIdCurso());
            for(Inscripcion inscripcion:inscripciones){
                Object[] fila = new Object[5];
                fila[0] = inscripcion.getInscripcionId();
                fila[1] = inscripcion.getAlumnoId();
                fila[2] = inscripcion.getAlumno().getNombre() + " " + inscripcion.getAlumno().getApellido();
                fila[3] = inscripcion.getNotasParciales();
                fila[4] = inscripcion.getNotaFinal();
                contenido.addRow(fila);
            }
        }
        catch(ServiceException ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Error al cargar inscripciones: " + ex.getMessage()
            );
        }

        jButtonCargarNotaParcial = new JButton("Cargar Nota Parcial");
        jButtonCargarNotaFinal = new JButton("Cargar Nota Final");
        jButtonVolver = new JButton("Volver");

        jButtonCargarNotaParcial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputId = JOptionPane.showInputDialog("Ingrese ID de inscripción:");
                    int inscripcionId = Integer.parseInt(inputId);
                    String inputNota = JOptionPane.showInputDialog("Ingrese nota parcial:");
                    double nota = Double.parseDouble(inputNota);
                    if(nota < 1 || nota > 10){
                        JOptionPane.showMessageDialog(null, "Nota inválida");
                        return;
                    }
                    serviceProfesor.agregarNotaParcial(inscripcionId, nota);
                    JOptionPane.showMessageDialog(null, "Nota cargada correctamente");
                    panelManager.mostrar(18);
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        jButtonCargarNotaFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputId = JOptionPane.showInputDialog("Ingrese ID de inscripción:");
                    int inscripcionId = Integer.parseInt(inputId);
                    String inputNota = JOptionPane.showInputDialog("Ingrese nota final:");
                    double nota = Double.parseDouble(inputNota);
                    if(nota < 1 || nota > 10){
                        JOptionPane.showMessageDialog(null, "Nota inválida");
                        return;
                    }
                    serviceProfesor.agregarNotaFinal(inscripcionId, nota);
                    JOptionPane.showMessageDialog(null, "Nota final cargada correctamente");
                    panelManager.mostrar(18);
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        jButtonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(11);
            }
        });

        JLabel titulo = new JLabel("Inscriptos al Curso", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 3));
        panelBotones.add(jButtonCargarNotaParcial);
        panelBotones.add(jButtonCargarNotaFinal);
        panelBotones.add(jButtonVolver);

        setLayout(new BorderLayout());
        add(titulo, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
}