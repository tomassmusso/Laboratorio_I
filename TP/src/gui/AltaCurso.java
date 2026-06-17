package gui;

import com.toedter.calendar.JDateChooser;

import entidades.Curso;
import entidades.Profesor;
import service.ServiceAdministrador;
import service.ServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class AltaCurso extends JPanel {
    private PanelManager panelManager;
    private ServiceAdministrador serviceAdministrador;
    private JTextField jTextFieldNombre;
    private JTextField jTextFieldCupo;
    private JDateChooser jDateChooserInicio;
    private JDateChooser jDateChooserFin;
    private JTextField jTextFieldPrecio;
    private JDateChooser jDateChooserInicioDescuento;
    private JDateChooser jDateChooserFinDescuento;
    private JTextField jTextFieldPrecioDescuento;
    private JTextField jTextFieldProfesorId;
    private JTextField jTextFieldCantidadParciales;
    private JTextField jTextFieldNotaAprobacion;
    private JTextField jTextFieldNotaPromocion;
    private JTextField jTextFieldTurno;
    private JButton jButtonGuardar;
    private JButton jButtonVolver;

    public AltaCurso(PanelManager panelManager){
        this.panelManager = panelManager;
        armarFormulario();
    }

    public void armarFormulario(){
        serviceAdministrador = new ServiceAdministrador();

        JLabel titulo = new JLabel("Alta Curso", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        jTextFieldNombre = new JTextField();
        jTextFieldCupo = new JTextField();
        jDateChooserInicio = new JDateChooser();
        jDateChooserFin = new JDateChooser();
        jTextFieldPrecio = new JTextField();
        jDateChooserInicioDescuento = new JDateChooser();
        jDateChooserFinDescuento = new JDateChooser();
        jTextFieldPrecioDescuento = new JTextField();
        jTextFieldProfesorId = new JTextField();
        jTextFieldCantidadParciales = new JTextField();
        jTextFieldNotaAprobacion = new JTextField();
        jTextFieldNotaPromocion = new JTextField();
        jTextFieldTurno = new JTextField();

        jButtonGuardar = new JButton("Guardar");
        jButtonVolver = new JButton("Volver");

        jButtonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = jTextFieldNombre.getText();
                int cupo = Integer.parseInt(jTextFieldCupo.getText());
                Date fechaInicio = jDateChooserInicio.getDate();
                Date fechaFin = jDateChooserFin.getDate();
                double precio = Double.parseDouble(jTextFieldPrecio.getText());
                Date fechaInicioDescuento = jDateChooserInicioDescuento.getDate();
                Date fechaFinDescuento = jDateChooserFinDescuento.getDate();
                double precioDescuento = Double.parseDouble(jTextFieldPrecioDescuento.getText());
                int profesorId = Integer.parseInt(jTextFieldProfesorId.getText());
                int cantidadParciales = Integer.parseInt(jTextFieldCantidadParciales.getText());
                double notaAprobacion = Double.parseDouble(jTextFieldNotaAprobacion.getText());
                double notaPromocion = Double.parseDouble(jTextFieldNotaPromocion.getText());
                String turno = jTextFieldTurno.getText();
                try{
                    Profesor profesor = serviceAdministrador.consultarProfesor(profesorId);
                    Curso curso = new Curso(nombre, cupo, fechaInicio, fechaFin, precio, fechaInicioDescuento, fechaFinDescuento, precioDescuento, profesor, turno, cantidadParciales, notaAprobacion, notaPromocion);
                    serviceAdministrador.crearCurso(curso);
                    JOptionPane.showMessageDialog(null, "Curso creado correctamente");
                    panelManager.mostrar(14);
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
                }
            }
        });

        jButtonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(14);
            }
        });

        setLayout(new GridLayout(29, 1));
        add(titulo);
        add(new JLabel("Nombre:"));
        add(jTextFieldNombre);
        add(new JLabel("Cupo:"));
        add(jTextFieldCupo);
        add(new JLabel("Fecha de inicio:"));
        add(jDateChooserInicio);
        add(new JLabel("Fecha de fin:"));
        add(jDateChooserFin);
        add(new JLabel("Precio:"));
        add(jTextFieldPrecio);
        add(new JLabel("Fecha inicio descuento:"));
        add(jDateChooserInicioDescuento);
        add(new JLabel("Fecha fin descuento:"));
        add(jDateChooserFinDescuento);
        add(new JLabel("Precio descuento:"));
        add(jTextFieldPrecioDescuento);
        add(new JLabel("ID Profesor:"));
        add(jTextFieldProfesorId);
        add(new JLabel("Cantidad de parciales:"));
        add(jTextFieldCantidadParciales);
        add(new JLabel("Nota de aprobación:"));
        add(jTextFieldNotaAprobacion);
        add(new JLabel("Nota de promoción:"));
        add(jTextFieldNotaPromocion);
        add(new JLabel("Turno:"));
        add(jTextFieldTurno);
        add(jButtonGuardar);
        add(jButtonVolver);
    }
}
