/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pedidos;

import Usuarios.Cliente;
import Usuarios.Empleado;

public class EmpAtiendeCli {

    private Cliente cliente;
    private Empleado empleado;
    private String fechaRelacion;

    public EmpAtiendeCli(Cliente cliente, Empleado empleado) {
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public EmpAtiendeCli(Cliente cliente, Empleado empleado, String fechaRelacion) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.fechaRelacion = fechaRelacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getFechaRelacion() {
        return fechaRelacion;
    }

    public void setFechaRelacion(String fechaRelacion) {
        this.fechaRelacion = fechaRelacion;
    }

    //metodo para mostrar detalles de la relación
    public String mostrarDetalles() {
        return cliente.info() + "/n" + empleado.info() + "\nFecha relacion: " + fechaRelacion;
    }

}
