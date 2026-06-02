package gui;

import entidades.Usuario;

import javax.swing.*;
import java.awt.*;

public class PanelManager {
    private JFrame jFrame;
    private Usuario usuarioIniciado;
    private InicioSesion inicioSesion;





    public PanelManager(){
        jFrame = new JFrame("Sistema de Alumnos");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mostrar(1);
    }

    public Usuario getUsuarioIniciado() {
        return usuarioIniciado;
    }

    public void setUsuarioIniciado(Usuario usuarioIniciado) {
        this.usuarioIniciado = usuarioIniciado;
    }

    public void mostrar(JPanel panel){
        jFrame.getContentPane().removeAll();
        jFrame.getContentPane().add(BorderLayout.CENTER, panel);
        jFrame.getContentPane().validate();
        jFrame.getContentPane().repaint();
        jFrame.setVisible(true);
        jFrame.setSize(800,600);
    }

    public void mostrar(int codigoPantalla){
        switch (codigoPantalla){
            case 1:
                inicioSesion = new InicioSesion(this);
                mostrar(inicioSesion);
                break;
        }
    }
}
