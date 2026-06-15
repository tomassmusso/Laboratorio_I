package gui;

import DAO.DAOException;
import service.ServiceAlumno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import entidades.Alumno;
import service.ServiceException;

public class ReporteAlumnos extends JPanel {
    private PanelManager panelManager;
    private JPanel reporte;
    private JTable jTable;
    private JButton volver;
    private DefaultTableModel contenido;
    private JScrollPane scrollPane;

    public ReporteAlumnos(PanelManager panelManager)  {
        this.panelManager = panelManager;
        armarTablaReporte();
    }
    public void armarTablaReporte() {
        reporte=new JPanel();
        reporte.setLayout(new BorderLayout());
        contenido= new DefaultTableModel();
        jTable = new JTable(contenido);
        scrollPane=new JScrollPane();
        scrollPane.setViewportView(jTable);
        contenido.addColumn("ID");
        contenido.addColumn("Apellido");
        contenido.addColumn("Nombre");
        reporte.add(scrollPane, BorderLayout.NORTH);
        ServiceAlumno service = new ServiceAlumno();
        volver=new JButton("Volver");
        add(volver, BorderLayout.SOUTH);
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(1);
            }
        });
        try {
            ArrayList<Alumno> alumnos = service.buscarTodos();
            for(Alumno alumno:alumnos)
            {
                Object [] fila= new Object[3];
                fila[0]= alumno.getId();
                fila[1]=alumno.getApellido();
                fila[2]=alumno.getNombre();
                contenido.addRow(fila);
            }
            
        }
        catch ( DAOException e)
        {
            JOptionPane.showMessageDialog(null, "Error");
        }
        add(scrollPane, BorderLayout.NORTH);
    }
    /*



     */

}
