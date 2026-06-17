package gui;

import com.toedter.calendar.JDateChooser;
import entidades.Administrador;
import entidades.Curso;
import service.ServiceAdministrador;
import service.ServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarCurso extends JPanel {
    private PanelManager panelManager;
    private ServiceAdministrador serviceAdministrador;
    private JTextField jTextFieldCupo;
    private JDateChooser jDateChooserInicioDescuento;
    private JDateChooser jDateChooserFinDescuento;
    private JTextField jTextFieldPrecio;
    private JTextField jTextFieldPrecioDescuento;
    private JTextField jTextFieldCantidadParciales;
    private JTextField jTextFieldNotaAprobacion;
    private JTextField jTextFieldNotaPromocion;
    private JButton jButtonGuardar;
    private JButton jButtonVolver;

    public ModificarCurso(PanelManager panelManager){
        this.panelManager = panelManager;
        armarFormulario();
    }

    public void armarFormulario(){
        serviceAdministrador = new ServiceAdministrador();
        Curso curso = panelManager.getCursoSeleccionado();
        boolean esAdmin = panelManager.getUsuarioIniciado() instanceof Administrador;

        JLabel titulo = new JLabel("Modificar Datos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        jTextFieldCantidadParciales = new JTextField(String.valueOf(curso.getCantidadParciales()));
        jTextFieldNotaAprobacion = new JTextField(String.valueOf(curso.getNotaAprobacion()));
        jTextFieldNotaPromocion = new JTextField(String.valueOf(curso.getNotaPromocion()));
        jButtonGuardar = new JButton("Guardar");
        jButtonVolver = new JButton("Volver");

        if(esAdmin){
            jTextFieldCupo = new JTextField(String.valueOf(curso.getCupo()));
            jDateChooserInicioDescuento = new JDateChooser();
            jDateChooserInicioDescuento.setDate(curso.getFechaInicioDescuento());
            jDateChooserFinDescuento = new JDateChooser();
            jDateChooserFinDescuento.setDate(curso.getFechaFinDescuento());
            jTextFieldPrecio = new JTextField(String.valueOf(curso.getPrecio()));
            jTextFieldPrecioDescuento = new JTextField(String.valueOf(curso.getPrecioDescuento()));
        }

        jButtonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curso.setCantidadParciales(Integer.parseInt(jTextFieldCantidadParciales.getText()));
                curso.setNotaAprobacion(Double.parseDouble(jTextFieldNotaAprobacion.getText()));
                curso.setNotaPromocion(Double.parseDouble(jTextFieldNotaPromocion.getText()));
                if(esAdmin){
                    curso.setCupo(Integer.parseInt(jTextFieldCupo.getText()));
                    curso.setPrecio(Double.parseDouble(jTextFieldPrecio.getText()));
                    curso.setPrecioDescuento(Double.parseDouble(jTextFieldPrecioDescuento.getText()));
                    curso.setFechaInicioDescuento(jDateChooserInicioDescuento.getDate());
                    curso.setFechaFinDescuento(jDateChooserFinDescuento.getDate());
                }
                try{
                    serviceAdministrador.modificarCurso(curso);
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                    if(esAdmin){
                        panelManager.mostrar(14);
                    }
                    else{
                        panelManager.mostrar(3);
                    }
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
                }
            }
        });

        jButtonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(esAdmin){
                    panelManager.mostrar(14);
                }
                else{
                    panelManager.mostrar(3);
                }
            }
        });

        if(esAdmin){
            setLayout(new GridLayout(19, 1));
        }
        else{
            setLayout(new GridLayout(9, 1));
        }

        add(titulo);
        add(new JLabel("Cantidad de Parciales:"));
        add(jTextFieldCantidadParciales);
        add(new JLabel("Nota Aprobación:"));
        add(jTextFieldNotaAprobacion);
        add(new JLabel("Nota Promoción:"));
        add(jTextFieldNotaPromocion);
        if(esAdmin){
            add(new JLabel("Cupo:"));
            add(jTextFieldCupo);
            add(new JLabel("Precio:"));
            add(jTextFieldPrecio);
            add(new JLabel("Precio Descuento:"));
            add(jTextFieldPrecioDescuento);
            add(new JLabel("Fecha Inicio Descuento:"));
            add(jDateChooserInicioDescuento);
            add(new JLabel("Fecha Fin Descuento:"));
            add(jDateChooserFinDescuento);
        }
        add(jButtonGuardar);
        add(jButtonVolver);
    }
}
