package gui;

import entidades.Curso;
import service.ServiceCurso;
import service.ServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReporteCurso extends JPanel {
    private PanelManager panelManager;
    private ServiceCurso serviceCurso;
    private JButton jButtonVolver;

    public ReporteCurso(PanelManager panelManager){
        this.panelManager = panelManager;
        armarReporte();
    }

    public void armarReporte(){
        serviceCurso = new ServiceCurso();

        Curso curso = panelManager.getCursoSeleccionado();

        JLabel titulo = new JLabel("Reporte de Aprobados", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel reporte = new JLabel("", SwingConstants.CENTER);
        try{
            reporte = new JLabel(serviceCurso.reporteAnotadosAprobados(curso.getIdCurso()), SwingConstants.CENTER);
        }
        catch (ServiceException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

        jButtonVolver = new JButton("Volver");

        jButtonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(14);
            }
        });

        setLayout(new GridLayout(3, 1));

        add(titulo);
        add(reporte);
        add(jButtonVolver);
    }
}