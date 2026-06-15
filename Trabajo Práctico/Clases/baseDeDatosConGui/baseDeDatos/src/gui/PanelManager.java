package gui;

import javax.swing.*;
import java.awt.*;

public class PanelManager {
    private FormularioAlumno formularioAlumno;
    private ReporteAlumnos reporteAlumnos;
    JFrame jFrame;

    public PanelManager(int tipo)
    {
        formularioAlumno=null;
        reporteAlumnos=null;
        jFrame=new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (tipo==1)
            formularioAlumno=new FormularioAlumno(this);
        mostrar(formularioAlumno);
    }
    public void mostrar(JPanel panel)
    {
        jFrame.getContentPane().removeAll();
        jFrame.getContentPane().add(BorderLayout.CENTER,panel);
        jFrame.getContentPane().validate();
        jFrame.getContentPane().repaint();
        jFrame.setVisible(true);
        jFrame.pack();
       // jFrame.setSize(500,300);
    }
    public void mostrar(int codigoPantalla)
        {
            switch (codigoPantalla)
            {
                case 1:
                    formularioAlumno =formularioAlumno==null?new FormularioAlumno(this):formularioAlumno;
                    mostrar(formularioAlumno);
                    break;
                case 2:
                    reporteAlumnos =new ReporteAlumnos(this);
                    mostrar(reporteAlumnos);
                    break;
            }
        }
}
