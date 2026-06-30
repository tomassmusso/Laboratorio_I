package gui;

import entidades.Alumno;
import entidades.Curso;
import service.ServiceAdministrador;
import service.ServiceCurso;
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
    private ServiceCurso serviceCurso;
    private JTable jTable;
    private DefaultTableModel contenido;
    private JScrollPane jScrollPane;
    private JButton jButtonAltaAlumno;
    private JButton jButtonModificarAlumno;
    private JButton jButtonEliminarAlumno;
    private JButton jButtonInscribir;
    private JButton jButtonVolver;

    public ListaAlumno(PanelManager panelManager){
        this.panelManager = panelManager;
        armarLista();
    }

    public void armarLista(){
        serviceAdministrador = new ServiceAdministrador();
        serviceCurso = new ServiceCurso();

        contenido = new DefaultTableModel();
        jTable = new JTable(contenido);
        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(jTable);
        contenido.addColumn("ID");
        contenido.addColumn("Nombre");
        contenido.addColumn("Apellido");
        contenido.addColumn("Mail");
        contenido.addColumn("Limite Cursos");

        try{
            ArrayList<Alumno> alumnos = serviceAdministrador.consultarTodosAlumnos();
            for(Alumno alumno:alumnos){
                Object[] fila = new Object[5];
                fila[0] = alumno.getId();
                fila[1] = alumno.getNombre();
                fila[2] = alumno.getApellido();
                fila[3] = alumno.getMail();
                fila[4] = alumno.getLimiteCursos();
                contenido.addRow(fila);
            }
        }
        catch(ServiceException ex){
            JOptionPane.showMessageDialog(null, "Error al cargar alumnos: " + ex.getMessage());
        }

        jButtonAltaAlumno = new JButton("Alta Alumno");
        jButtonModificarAlumno = new JButton("Modificar Alumno");
        jButtonEliminarAlumno = new JButton("Eliminar Alumno");
        jButtonInscribir = new JButton("Inscribir Alumno");
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
                try{
                    int id = Integer.parseInt(input);
                    Alumno alumno = serviceAdministrador.consultarAlumno(id);
                    if(alumno != null){
                        panelManager.setUsuarioSeleccionado(alumno);
                        panelManager.mostrar(7);
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

        jButtonEliminarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el ID del alumno a eliminar:");
                try{
                    int id = Integer.parseInt(input);
                    Alumno alumno = serviceAdministrador.consultarAlumno(id);
                    int opcion = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar este alumno?\n" + alumno.getNombre() + " " + alumno.getApellido(), "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                    if(opcion == JOptionPane.YES_OPTION){
                        serviceAdministrador.eliminarAlumno(id);
                        JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Alumno no eliminado");
                    }
                    panelManager.mostrar(5);
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        jButtonInscribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputAlumno = JOptionPane.showInputDialog("Ingrese el ID del alumno:");
                    ArrayList<Curso> cursos = serviceAdministrador.consultarTodosCursos();

                    String mensaje = "Cursos disponibles:\n\n";

                    for(Curso curso:cursos){
                        mensaje += curso.getIdCurso() + " - " + curso.getNombre() + " - " + curso.getTurno() + " - Cupo: " + curso.getCupo() + " - Anotados: " + serviceCurso.cantidadInscriptos(curso.getIdCurso()) + "\n";
                    }

                    String inputCurso = JOptionPane.showInputDialog(null, mensaje + "\nIngrese el ID del curso:");

                    int alumnoId = Integer.parseInt(inputAlumno);
                    int cursoId = Integer.parseInt(inputCurso);

                    serviceAdministrador.inscribirAlumno(alumnoId, cursoId);

                    JOptionPane.showMessageDialog(null, "Alumno inscripto correctamente");
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

        JLabel titulo = new JLabel("Lista de Alumnos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 5));
        panelBotones.add(jButtonAltaAlumno);
        panelBotones.add(jButtonModificarAlumno);
        panelBotones.add(jButtonEliminarAlumno);
        panelBotones.add(jButtonInscribir);
        panelBotones.add(jButtonVolver);

        setLayout(new BorderLayout());
        add(titulo, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
}