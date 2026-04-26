package entidadaes;

import java.util.*;

public class Banco {
    private String nombre;
    private List<Cuenta> cuentas;

    public Banco(String nombre) {
        this.nombre = nombre;
        cuentas = new ArrayList<>();
    }

    public Banco() {}

    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }

    public void cerrarCuenta(Cuenta cuenta){
        cuentas.remove(cuenta);
    }

    public void cerrarCuenta(int nroCuenta){
        Cuenta buscada = buscar(nroCuenta);
        if(buscada != null){
            cuentas.remove(buscada);
        }
    }

    public Cuenta buscar(int nroCuenta){
        boolean noEncontre = true;
        Cuenta aux = null;
        Iterator<Cuenta> iterador = cuentas.iterator();
        while(iterador.hasNext() && noEncontre){
            Cuenta temp = iterador.next();
            if(temp.getNroCuenta() == nroCuenta){
                aux = temp;
                noEncontre = false;
            }
        }
        return aux;
    }

    public double consultarSaldoCuenta(int nroCuenta){
        Cuenta buscada = buscar(nroCuenta);
        if(buscada != null){
            return buscada.saldo;
        }
        return -1;
    }

    public void ordenar(){
        Collections.sort(cuentas);
    }

    public double totalCuentas(){
        double total = 0;
        for(Cuenta cuenta:cuentas){
            total += cuenta.saldo;
        }
        return total;
    }
}
