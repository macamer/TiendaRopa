/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MisListas;

import Usuarios.Cliente;
import Pedidos.EmpAtiendeCli;
import Usuarios.Empleado;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class ListaEmpCli {

    //constructor por defecto
    public ListaEmpCli() {
        this.listaEmpCli = new ArrayList<>();
    }

    private ArrayList<EmpAtiendeCli> listaEmpCli;

    public boolean agregarRelacion(Cliente cliente, Empleado empleado) {
        boolean añadido = false;
        // Date fecha = new Date();
        EmpAtiendeCli reg;
        Calendar fecha = Calendar.getInstance();
        reg = new EmpAtiendeCli(cliente, empleado, fecha.getTime().toString());
        if (reg != null) {
            añadido = listaEmpCli.add(reg);
        }
        return añadido;
    }

    public boolean agregarRelacion(EmpAtiendeCli reg) {
        boolean añadido = false;
        if (reg != null) {
            añadido = listaEmpCli.add(reg);
        }
        return añadido;
    }

    public boolean eliminarRelacion(Cliente cliente, Empleado empleado) {
        boolean borrado = false;
        EmpAtiendeCli reg;
        reg = buscarRelacion(cliente, empleado);
        if (reg != null) {
            borrado = listaEmpCli.remove(reg);
        }
        return borrado;
    }

    public boolean eliminarRelacion(EmpAtiendeCli reg) {
        boolean borrado = false;
        if (reg != null) {
            borrado = listaEmpCli.remove(reg);
        }
        return borrado;
    }

    public EmpAtiendeCli buscarRelacion(Cliente cliente, Empleado empleado) {
        EmpAtiendeCli reg = null, enc = null;
        String clienteDni = cliente.getDni();
        String empleadoDni = empleado.getDni();
        boolean encontrado = false;
        Iterator <EmpAtiendeCli> iter = listaEmpCli.iterator();
        while (iter.hasNext() && encontrado == false) {
            reg = iter.next();
            if (reg.getCliente().getDni().equalsIgnoreCase(clienteDni)
                    && reg.getEmpleado().getDni().equalsIgnoreCase(empleadoDni)) {
                enc = reg;
                encontrado = true;
            }
        }
        return enc;
    }

    public EmpAtiendeCli buscarRelacion(EmpAtiendeCli reg) {
        EmpAtiendeCli enc = null;
        String clienteDni = reg.getCliente().getDni();
        String empleadoDni = reg.getEmpleado().getDni();
        boolean encontrado = false;
        Iterator <EmpAtiendeCli> iter = listaEmpCli.iterator();
        while (iter.hasNext() && encontrado == false) {
            reg = iter.next();
            if (reg.getCliente().getDni().equalsIgnoreCase(clienteDni)
                    && reg.getEmpleado().getDni().equalsIgnoreCase(empleadoDni)) {
                enc = reg;
                encontrado = true;
            }
        }
        return enc;
    }

    // Método para verificar si una relación existe dado el cliente y el empleado
    public void mostrarRelaciones() {
        for (EmpAtiendeCli relacion : listaEmpCli) {
            System.out.println(relacion.getCliente().info());
            System.out.println("Atiende A");
            System.out.println(relacion.getEmpleado().info());
            System.out.println("------------------------");
            System.out.println("");
        }
    }

    public void buscarEmpleados(String dni) {
        for (EmpAtiendeCli reg : listaEmpCli) {
            if (reg.getCliente().getDni().equalsIgnoreCase(dni)) {
                System.out.println(reg.getEmpleado().info());
            }
        }
    }

    /* Añade una opción en la que se solicite el dni de un cliente y 
    nos muestre los empleados que lo han atendido. */
    // Método para buscar una relación dado el dni cliente y empleado
    public void atiendeCliente(String dniC) {
        EmpAtiendeCli relacion = null;
        int cont = 1;
        Iterator<EmpAtiendeCli> it = listaEmpCli.iterator();
        while (it.hasNext()) {
            relacion = it.next();
            if (relacion.getCliente().getDni().equals(dniC)) {
                System.out.println("Empreado nº:" + cont + " " + relacion.getEmpleado().getNombre());
                cont++;
            }
        }
    }

    /*Añade una opción en la que se solicite el dni de un empleado y 
    nos muestre la cantidad de clientes atendidos en una fecha determinada*/
    // Método para buscar una relación dado el dni cliente y empleado
    public int atiendeCliente(String dniE, String fecha) {
        EmpAtiendeCli relacion = null;
        int cont = 0;
        Iterator<EmpAtiendeCli> it = listaEmpCli.iterator();
        while (it.hasNext()) {
            relacion = it.next();
            if (relacion.getEmpleado().getDni().equalsIgnoreCase(dniE)) {
                if (relacion.getFechaRelacion().equalsIgnoreCase(fecha)) {
                    cont++;
                }
            }
        }
        return cont;
    }
}
