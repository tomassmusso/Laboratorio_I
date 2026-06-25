package gui;

import entidades.Profesor;
import service.ServiceAdministrador;
import service.ServiceException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaProfesor extends JPanel {
    private PanelManager panelManager;
    private ServiceAdministrador serviceAdministrador;
    private JTable jTable;
    private DefaultTableModel contenido;
    private JScrollPane jScrollPane;
    private JButton jButtonAltaProfesor;
    private JButton jButtonModificarProfesor;
    private JButton jButtonEliminarProfesor;
    private JButton jButtonConsultarCursosDicatados;
    private JButton jButtonVolver;

    public ListaProfesor(PanelManager panelManager){
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
        contenido.addColumn("Departamento");

        try{
            ArrayList<Profesor> profesores = serviceAdministrador.consultarTodosProfesores();
            for(Profesor profesor:profesores){
                Object[] fila = new Object[5];
                fila[0] = profesor.getId();
                fila[1] = profesor.getNombre();
                fila[2] = profesor.getApellido();
                fila[3] = profesor.getMail();
                fila[4] = profesor.getDepartamento();
                contenido.addRow(fila);
            }
        }
        catch(ServiceException ex){
            JOptionPane.showMessageDialog(null, "Error al cargar profesores: " + ex.getMessage());
        }

        jButtonAltaProfesor = new JButton("Alta Profesor");
        jButtonModificarProfesor = new JButton("Modificar Profesor");
        jButtonEliminarProfesor = new JButton("Despedir Profesor");
        jButtonConsultarCursosDicatados = new JButton("Consultar Cursos");
        jButtonVolver = new JButton("Volver");

        jButtonAltaProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(9);
            }
        });
        jButtonModificarProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el ID del profesor a modificar:");
                try{
                    int id = Integer.parseInt(input);
                    Profesor profesor = serviceAdministrador.consultarProfesor(id);
                    if(profesor != null){
                        panelManager.setUsuarioSeleccionado(profesor);
                        panelManager.mostrar(10);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No se encontró el profesor");
                    }
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        jButtonEliminarProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el ID del profesor a despedir:");
                try{
                    int id = Integer.parseInt(input);
                    Profesor profesor = serviceAdministrador.consultarProfesor(id);
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar este profesor?\nSe eliminarán también sus cursos\n" + profesor.getNombre() + " " + profesor.getApellido(), "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                    if(opcion == JOptionPane.YES_OPTION){
                        serviceAdministrador.eliminarProfesor(id);
                        JOptionPane.showMessageDialog(null, "Porfesor eliminado correctamente");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Profesor no eliminado");
                    }
                    panelManager.mostrar(8);
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        jButtonConsultarCursosDicatados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese ID del profesor a listar cursos dictados:");
                try{
                    int id = Integer.parseInt(input);
                    Profesor profesor = serviceAdministrador.consultarProfesor(id);
                    panelManager.setUsuarioSeleccionado(profesor);
                    panelManager.mostrar(11);
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

        JLabel titulo = new JLabel("Lista de Profesores", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 5));
        panelBotones.add(jButtonAltaProfesor);
        panelBotones.add(jButtonModificarProfesor);
        panelBotones.add(jButtonEliminarProfesor);
        panelBotones.add(jButtonConsultarCursosDicatados);
        panelBotones.add(jButtonVolver);

        setLayout(new BorderLayout());
        add(titulo, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
}
