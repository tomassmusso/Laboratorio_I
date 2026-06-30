package gui;

import entidades.Alumno;
import service.ServiceAlumno;
import service.ServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagarDeuda extends JPanel {
    private PanelManager panelManager;
    private ServiceAlumno serviceAlumno;
    private JTextField jTextFieldMonto;
    private JButton jButtonPagar;
    private JButton jButtonVolver;

    public PagarDeuda(PanelManager panelManager){
        this.panelManager = panelManager;
        armarFormulario();
    }

    public void armarFormulario(){
        serviceAlumno = new ServiceAlumno();
        Alumno alumno = (Alumno) panelManager.getUsuarioIniciado();

        JLabel titulo = new JLabel("Pago de Aranceles", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel labelDeuda = new JLabel("Deuda actual: $" + alumno.getDeuda(), SwingConstants.CENTER);

        jTextFieldMonto = new JTextField();

        jButtonPagar = new JButton("Pagar");
        jButtonVolver = new JButton("Volver");

        jButtonPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double monto = Double.parseDouble(jTextFieldMonto.getText());

                    serviceAlumno.pagarDeuda(alumno.getId(), monto);

                    JOptionPane.showConfirmDialog(null, "Confirmar Pago?");
                    JOptionPane.showMessageDialog(null, "Pago realizado correctamente\nEl pago puede tardar en impactar hasta 24 horas");
                    panelManager.mostrar(2);
                }
                catch(ServiceException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        jButtonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrar(2);
            }
        });

        setLayout(new GridLayout(6,1));
        add(titulo);
        add(labelDeuda);
        add(new JLabel("Monto a pagar:"));
        add(jTextFieldMonto);
        add(jButtonPagar);
        add(jButtonVolver);
    }
}